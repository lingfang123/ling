package com.jyb.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jyb.annotation.SystemControllerLog;
import com.jyb.arithmetic.EqualityCorpusAndInterest;
import com.jyb.arithmetic.InterestAfterPrincipal;
import com.jyb.http.HttpUtil;
import com.jyb.pojo.Applyfor;
import com.jyb.pojo.Detail;
import com.jyb.pojo.FinanceCompany;
import com.jyb.pojo.FinanceCompanydetail;
import com.jyb.pojo.Invest;
import com.jyb.pojo.Ip;
import com.jyb.pojo.MarkInfo;
import com.jyb.pojo.Redenvelopes;
import com.jyb.pojo.RefundRecord;
import com.jyb.pojo.User;
import com.jyb.pojo.UserInfo;
import com.jyb.pojo.UserMoney;
import com.jyb.req.CompensateReq;
import com.jyb.req.IncomeReq;
import com.jyb.req.NnFreezeReq;
import com.jyb.req.OrderReq;
import com.jyb.resp.CompensateResp;
import com.jyb.resp.IncomeResp;
import com.jyb.resp.NnFreezeResp;
import com.jyb.resp.OrderResp;
import com.jyb.service.ApplyforService;
import com.jyb.service.DetailService;
import com.jyb.service.FinanceCompanyService;
import com.jyb.service.FinanceCompanydetailService;
import com.jyb.service.InvestService;
import com.jyb.service.IpService;
import com.jyb.service.MarkInfoService;
import com.jyb.service.RedenvelopesService;
import com.jyb.service.RefundRecordService;
import com.jyb.service.UserInfoService;
import com.jyb.service.UserMoneyService;
/**
 * 用户投资Controller
 * */
@Controller
public class UserInvestController {
	@Resource(name="markInfoServiceImpl")
	private MarkInfoService markInfoService;
	@Resource(name="redenvelopesServiceImpl")
	private RedenvelopesService redenvelopesService;
	@Resource(name="userMoneyServiceImpl")
	private UserMoneyService userMoneyService;
	@Resource(name="investServiceImpl")
	private InvestService investService;
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoService;
	@Resource(name="applyforServiceImpl")
	private ApplyforService applyforService;
	@Resource(name="refundRecordServiceImpl")
	private RefundRecordService refundRecordService;
	@Resource(name="financeCompanyServiceImpl")
	private FinanceCompanyService financeCompanyService;
	@Resource(name="financeCompanydetailServiceImpl")
	private FinanceCompanydetailService financeCompanydetailService;
	@Resource(name="detailServiceImpl")
	private DetailService detailService;
	@Resource(name="ipServiceImpl")
	private IpService ipService;

	@SystemControllerLog(description="用户投标")
	@ResponseBody
	@RequestMapping("userInvest")
	public String userInvest(@RequestParam("money")double money,@RequestParam("markinfoId")Integer markinfoId,
			@RequestParam("overduemoney")double overduemoney,HttpSession session) throws Exception {
		List<Ip> ip = ipService.list();
		Ip I1 = ip.get(0);

		Redenvelopes redenvelopes = null;//用来接收可以使用的红包
		double redeMoney = 0.0;////用来接收可以使用的红包的金额
		User u = (User) session.getAttribute("user");
		
		List<Redenvelopes> redeList = redenvelopesService.getByUserid(u.getId());
		for(int i=0;i<redeList.size();i++) {
			if(money>=redeList.get(i).getMinmoney() && money<=redeList.get(i).getTjmoney()) {
				redenvelopes = redeList.get(i);
				redeMoney = redeList.get(i).getHbmoney();
			}
		}
		if(redenvelopes!=null) {
			//修改红包状态（t_redenvelopes）
			redenvelopes.setStruts(1);
			redenvelopesService.update(redenvelopes);
		}
		
		UserInfo userInfo =  userInfoService.getByuserid(u.getId());
		MarkInfo markInfo = markInfoService.getById(markinfoId);
		
		//正常请求（无优惠券等）
		OrderReq orderReq = new OrderReq();
		orderReq.setUid("zyd7850");
		orderReq.setPass("ling");
		orderReq.setUname(userInfo.getOpenAccount());
		orderReq.setDjnumber(markInfo.getBackup1());
		orderReq.setMoney(money-redeMoney);
		HttpUtil<OrderReq> httputil = new HttpUtil<>();
		
		/*********************** 向易支付发送请求 ***************************/
		String httpurl = "http://"+I1.getIp()+":8080/yzf/order.do";
		String mags = (String)httputil.httpRequest(orderReq, httpurl);
		
		Gson gson = new Gson();
		OrderResp orderResp = gson.fromJson(mags, OrderResp.class);
		if(orderResp.getCode() == 700) {
			//修改用户钱包（t_user_money）
			UserMoney userMoney = userMoneyService.getByuserid(u.getId());
			if(redeMoney>0) {
				//使用了红包 公司垫付红包
				CompensateReq compensateReq = new CompensateReq();
				compensateReq.setUid("zyd7850");
				compensateReq.setPass("ling");
				compensateReq.setMoney(redeMoney);
				compensateReq.setDjnumber(markInfo.getBackup1());
				
				/*********************** 向易支付发送请求 ***************************/
				HttpUtil<CompensateReq> httputil2 = new HttpUtil<>();
				httpurl = "http://"+I1.getIp()+":8080/yzf/dfmoney.do";
				mags = (String)httputil2.httpRequest(compensateReq, httpurl);
				CompensateResp compensateResp = gson.fromJson(mags, CompensateResp.class);
				
				if(compensateResp.getCode()==700) {
					//公司金额减少
					FinanceCompany financeCompany = new FinanceCompany();
					financeCompany.setId(1);
					financeCompany.setSumMoney(compensateResp.getMoney());
					financeCompanyService.reduceFinanceCompanyMoney(financeCompany);
					financeCompany = financeCompanyService.getById(1);
					//增加公司明细
					FinanceCompanydetail companydetail = new  FinanceCompanydetail();
					companydetail.setIncomeType(1);
					companydetail.setTransMoney(compensateResp.getMoney());
					companydetail.setOperateTime(new Date());
					companydetail.setRemark("用户投标红包抵扣，公司垫付");
					companydetail.setUseableMoney(financeCompany.getSumMoney());
					financeCompanydetailService.add(companydetail);
					
					userMoney.setAccountMoney(userMoney.getAccountMoney()-(money-redeMoney));
					userMoney.setUsableMoney(userMoney.getUsableMoney()-(money-redeMoney));
					userMoney.setFreezeMoney(money-redeMoney);
					//用户资金明细
				}
			}else {
				//未使用红包的情况下
				userMoney.setAccountMoney(userMoney.getAccountMoney()-money);
				userMoney.setUsableMoney(userMoney.getUsableMoney()-money);
				userMoney.setFreezeMoney(userMoney.getFreezeMoney()+money);
				//用户资金明细
			}
			//修改用户资金
			userMoneyService.updateUserMoney(userMoney);
			//用户资金明细
			Detail detail = new Detail();
			detail.setUserid(userMoney.getUserid());
			detail.setMoney(money-redeMoney);
			detail.setStruts(4);
			detail.setRemark("理财");
			detail.setDateiltime(new Date());
			detailService.add(detail);
			
			//修改标的已筹金额（t_mark_info）
			markInfo.setCountmoney(markInfo.getCountmoney()+money);
			markInfoService.update(markInfo);
			
			//添加投资记录（t_invest）
			Invest invest = new Invest();
			invest.setUserid(u.getId());
			invest.setTmarkid(markInfo.getId());
			invest.setMarkid(markInfo.getMarkid());
			invest.setRefundtime(markInfo.getStarttime());
			invest.setMarkmoney(money);
			invest.setOverduemoney(overduemoney);
			invest.setBorrowtime(markInfo.getBorrowtime());
			invest.setBidtime(new Date());
			invest.setStatus(1);
			if(redeMoney>0) {
				invest.setHbid(redenvelopes.getId());
				invest.setHbmoney(redeMoney);
			}
			invest.setBackup1("");
			invest.setBackup2("");
			investService.add(invest);
		}
		
		//判断标的金额剩余多少 如果小于 最小投标金额   用户无法再进行投标  所以 由公司垫付
		double symoney = markInfo.getMoney() - markInfo.getCountmoney() - redeMoney;
		if(symoney<markInfo.getInvestmin()) {
			CompensateReq compensateReq = new CompensateReq();
			compensateReq.setUid("zyd7850");
			compensateReq.setPass("ling");
			compensateReq.setMoney(symoney);
			compensateReq.setDjnumber(markInfo.getBackup1());
			
			/*********************** 向易支付发送请求 ***************************/
			HttpUtil<CompensateReq> httputil2 = new HttpUtil<>();
			httpurl = "http://"+I1.getIp()+":8080/yzf/dfmoney.do";
			mags = (String)httputil2.httpRequest(compensateReq, httpurl);
			CompensateResp compensateResp = gson.fromJson(mags, CompensateResp.class);
			
			if(compensateResp.getCode()==700) {
				//公司金额减少
				FinanceCompany financeCompany = new FinanceCompany();
				financeCompany.setId(1);
				financeCompany.setSumMoney(compensateResp.getMoney());
				financeCompanyService.reduceFinanceCompanyMoney(financeCompany);
				financeCompany = financeCompanyService.getById(1);
				//增加公司明细
				FinanceCompanydetail companydetail = new  FinanceCompanydetail();
				companydetail.setIncomeType(1);
				companydetail.setTransMoney(compensateResp.getMoney());
				companydetail.setOperateTime(new Date());
				companydetail.setRemark("用户投标红包抵扣，公司垫付");
				companydetail.setUseableMoney(financeCompany.getSumMoney());
				financeCompanydetailService.add(companydetail);
				
				markInfo.setCountmoney(markInfo.getCountmoney()+compensateResp.getMoney());
				markInfoService.update(markInfo);
			}
		}
		
		//判断是否满标
		if(markInfo.getCountmoney()>=markInfo.getMoney()) {
			//满标放款
			//请求易支付-----解冻
			NnFreezeReq nFreezeReq = new NnFreezeReq();
			nFreezeReq.setUid("zyd7850");
			nFreezeReq.setPass("ling");
			//查询贷款用户
			UserInfo userInfo2 = userInfoService.getByuserid(markInfo.getUserid());
			nFreezeReq.setUname(userInfo2.getOpenAccount());
			nFreezeReq.setDjnumber(markInfo.getBackup1());
			
			/*********************** 向易支付发送请求 ***************************/
			HttpUtil<NnFreezeReq> httputil3 = new HttpUtil<>();
			httpurl = "http://"+I1.getIp()+":8080/yzf/unfreeze.do";
			mags = (String)httputil3.httpRequest(nFreezeReq, httpurl);
			NnFreezeResp compensateResp = gson.fromJson(mags, NnFreezeResp.class);
			if(compensateResp.getCode() == 605) {
				//解冻成功
				//根据标的申请id 查询借款申请表  收取管理费
				Applyfor applyfor = applyforService.getById(markInfo.getApplyforid());
				UserMoney userMoney2 = userMoneyService.getByuserid(markInfo.getUserid());
				//平台收取管理费
				IncomeReq incomeReq = new IncomeReq();
				incomeReq.setUidl("zyd7850");
				incomeReq.setPass("ling");
				incomeReq.setUname(userInfo2.getOpenAccount());
				incomeReq.setMoney(applyfor.getManagemoney());
				
				/*********************** 向易支付发送请求 ***************************/
				HttpUtil<IncomeReq> httputil4 = new HttpUtil<>();
				httpurl = "http://"+I1.getIp()+":8080/yzf/income.do";
				mags = (String)httputil4.httpRequest(incomeReq, httpurl);
				IncomeResp incomeResp = gson.fromJson(mags, IncomeResp.class);
				
				if(incomeResp.getCode() == 800) {
					//计算用户 需要还款金额
					double bxmoney = 0;
					if(markInfo.getPaymentMode()==1) {
						//等额本息
						bxmoney = EqualityCorpusAndInterest.getPrincipalInterestCount(markInfo.getCountmoney(),applyfor.getNhrate(),applyfor.getBorrowtime());
					}else {
						//先息后本
						bxmoney = InterestAfterPrincipal.getPrincipalAndInterest(markInfo.getCountmoney(),applyfor.getNhrate(),applyfor.getBorrowtime());
					}
					
					//用户借款 实际可以得到的借款金额
					userMoney2.setAccountMoney(userMoney2.getAccountMoney()+markInfo.getCountmoney()-applyfor.getManagemoney());
					userMoney2.setUsableMoney(userMoney2.getUsableMoney()+markInfo.getCountmoney()-applyfor.getManagemoney());
					userMoney2.setRepayMoney(bxmoney);
					
					//计算还款笔数，还款时间...
					//判断还款方式
					Date date = new Date();
					if(markInfo.getPaymentMode()==1) {
						//等额本息
						//每月需还本息
						double perMonthPrincipalInterest = EqualityCorpusAndInterest.getPerMonthPrincipalInterest(markInfo.getCountmoney(), applyfor.getNhrate(), applyfor.getBorrowtime());
						//每月还款利息
						Map<Integer, BigDecimal> mapInterest = EqualityCorpusAndInterest.getPerMonthInterest(markInfo.getCountmoney(), applyfor.getNhrate(), applyfor.getBorrowtime()); 
						//便利mapperMonthPrincipalInterest
						for (Map.Entry<Integer, BigDecimal> entry : mapInterest.entrySet()) {  
							RefundRecord record = new RefundRecord();
							record.setUserid(userInfo2.getUserid());
							record.setTmarkid(markInfo.getId());
							
							//还款时间
							Calendar calendar = new GregorianCalendar();
							calendar.setTime(date); 
							calendar.add(Calendar.MONTH, entry.getKey());
							
							record.setRefundtime(calendar.getTime());//还款日期
							
							record.setHkmoney(perMonthPrincipalInterest);
							record.setPrincipal(perMonthPrincipalInterest-entry.getValue().doubleValue());
							record.setIntegererests(entry.getValue().doubleValue());
							record.setBackup1(String.valueOf(entry.getKey()));
							record.setOverduestatus(0);//是否逾期
							record.setOverduedays(0);//逾期天数
							record.setOverduemoney(0.0);//逾期罚息
							record.setStatus(0);//待还款
							refundRecordService.add(record);
						}
						
					}else if(markInfo.getPaymentMode()==2) {
						//先息后本
						//月利息
						double mapInteresta = InterestAfterPrincipal.getMonthlyInterest(markInfo.getCountmoney(), applyfor.getNhrate(), applyfor.getBorrowtime());
						for(int i = 1;i <= applyfor.getBorrowtime();i++) {
							RefundRecord record = new RefundRecord();
							record.setUserid(userInfo2.getUserid());
							record.setTmarkid(markInfo.getId());
							
							//还款时间
							Calendar calendar = new GregorianCalendar();
							calendar.setTime(date); 
							calendar.add(Calendar.MONTH, i);
							
							record.setRefundtime(calendar.getTime());//还款日期
							if(i==applyfor.getBorrowtime()) {
								//最后一个月  本金+利息
								record.setHkmoney(mapInteresta+markInfo.getCountmoney());//还款金额
								record.setPrincipal(markInfo.getCountmoney());//还款本金
								record.setIntegererests(mapInteresta);//还款利息
							}else{
								//只换利息
								record.setHkmoney(mapInteresta);//还款金额
								record.setPrincipal(0);//还款本金
								record.setIntegererests(mapInteresta);//还款利息
							}
							record.setBackup1(String.valueOf(i));
							record.setOverduestatus(0);//是否逾期
							record.setOverduedays(0);//逾期天数
							record.setOverduemoney(0.0);//逾期罚息
							record.setStatus(0);//待还款
							refundRecordService.add(record);
						}
					}
					userMoneyService.updateUserMoney(userMoney2);
					List<Invest> invests = investService.getByInvestTmarkid(markInfo.getId());
					for(Invest invest : invests) {
						invest.setStatus(5);
						investService.update(invest);
						UserMoney userMoney = new UserMoney();
						userMoney.setFreezeMoney(0);
						userMoney.setCollectionMoney(userMoney.getCollectionMoney() + invest.getMarkmoney()+invest.getOverduemoney());
						userMoney.setUserid(invest.getUserid());
						userMoneyService.updateUserMoneyh(userMoney);
					}
				}
			}
		}
		return "true";
	}
	
}