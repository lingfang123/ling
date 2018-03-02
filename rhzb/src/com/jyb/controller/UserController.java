package com.jyb.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jyb.annotation.SystemControllerLog;
import com.jyb.arithmetic.EqualityCorpusAndInterest;
import com.jyb.arithmetic.InterestAfterPrincipal;
import com.jyb.http.HttpUtil;
import com.jyb.pojo.City;
import com.jyb.pojo.Detail;
import com.jyb.pojo.District;
import com.jyb.pojo.FinanceCompany;
import com.jyb.pojo.Invest;
import com.jyb.pojo.Ip;
import com.jyb.pojo.MarkInfo;
import com.jyb.pojo.Province;
import com.jyb.pojo.RedInfo;
import com.jyb.pojo.Redenvelopes;
import com.jyb.pojo.RefundRecord;
import com.jyb.pojo.User;
import com.jyb.pojo.UserBankcard;
import com.jyb.pojo.UserInfo;
import com.jyb.pojo.UserMoney;
import com.jyb.req.IncomeReq;
import com.jyb.req.UserIncomeReq;
import com.jyb.resp.IncomeResp;
import com.jyb.resp.UserIncomeResp;
import com.jyb.service.DetailService;
import com.jyb.service.FinanceCompanyService;
import com.jyb.service.InvestService;
import com.jyb.service.IpService;
import com.jyb.service.MarkInfoService;
import com.jyb.service.PconService;
import com.jyb.service.RedInfoService;
import com.jyb.service.RedenvelopesService;
import com.jyb.service.RefundRecordService;
import com.jyb.service.UserBankcardService;
import com.jyb.service.UserInfoService;
import com.jyb.service.UserMoneyService;
import com.jyb.service.UserService;
import com.jyb.util.Base64File;
import com.jyb.util.PageBean;

/**
 * 关于用户
 * */
@Controller
@RequestMapping("user")
public class UserController {
	@Resource(name="userServiceImpl")
	private UserService userService;
	@Resource(name="userBankcardServiceImpl")
	private UserBankcardService userBankcradService;
	@Resource(name="redenvelopesServiceImpl")
	private RedenvelopesService redenvelopesService;
	@Resource(name="redInfoServiceImpl")
	private RedInfoService redInfoService;
	@Resource(name="detailServiceImpl")
	private DetailService detailService;
	@Resource(name="userMoneyServiceImpl")
	private UserMoneyService userMoneyService;
	@Resource(name="pconServiceImpl")
	private PconService pconService;
	@Resource(name="investServiceImpl")
	private InvestService investService;
	@Resource(name="refundRecordServiceImpl")
	private RefundRecordService refundRecordService;
	@Resource(name="markInfoServiceImpl")
	private MarkInfoService markInfoService;
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoService;
	@Resource(name="ipServiceImpl")
	private IpService ipService;
	@Resource(name="financeCompanyServiceImpl")
	private FinanceCompanyService financeCompanyService;

	
	
	//头像上传
	@SystemControllerLog(description="头像上传")
	@RequestMapping("uploadImg")
    @ResponseBody 
	public String uploadImg(User user,String base64,String fileName,HttpServletRequest request,HttpSession session) {
		// 去掉base64数据头部data:image/png;base64,和尾部的” " “  
        String[] ww= base64.split(",");  
        base64 = ww[1];  
        String[] aa = base64.split("\"");  
        base64 = aa[0];  
        try {  
        	User u=(User) session.getAttribute("user");
        	
            //图片保存到本地  
        	//String url="upload/userImg/"+fileName;
        	String url="F:\\tomcat\\apache-tomcat-9.0.0.M22\\webapps\\update\\"+fileName;
        	//String path=request.getSession().getServletContext().getRealPath(url);  
            Base64File file = new Base64File();  
            file.decoderBase64File(base64, url);  
            
           //将图片插入数据库  
        	
    		user.setId(u.getId());
        	user.setUserimg("/update/"+fileName);
        	userService.update(user);
        	
        	
        	//更新之后，把session移除再添加，前台el表达式才能获取更新数据
           u.setUserimg(user.getUserimg());
           
           session.removeAttribute("user");
           session.setAttribute("user", u);
            //	 成功标识  
            return "success";  
        } catch (Exception e) {  
        	return "nosuccess";  
        }  
	}
	
	
	
	//完善个人资料
	@SystemControllerLog(description="完善个人资料")
	@RequestMapping("saveUser")
	@ResponseBody
	public String saveUser(User user,HttpSession session) throws UnsupportedEncodingException, UnknownHostException{
		
		User u=(User) session.getAttribute("user");
		user.setId(u.getId());
		//根据id查询出数据库user
		User us=userService.getById(u.getId());
		//判断us是否为空
		if(us!=null) {
			//用户名
			if(user.getUsername()!=null&&!user.getUsername().equals("")) {
				user.setUsername(user.getUsername());
				if(us.getUsername()==null||us.getUsername().equals("")) {
					userService.add(user);
				}else{
					userService.update(user);
				}
			}
			
			//密码的更改
			//判断旧密码是否填写（js里已验证，可不写）
			if(user.getPassword()!=null&&!user.getPassword().equals("")) {
				//判断输入的原密码是否和数据库相同
				Object oldpwd = new SimpleHash("MD5",user.getPassword(), ByteSource.Util.bytes(u.getUsername()), 10);	
				if(us.getPassword().equals(oldpwd.toString())) {
					//把新密码加密，设置进密码
					Object newpwd = new SimpleHash("MD5",user.getNewPwd(), ByteSource.Util.bytes(u.getUsername()), 10);	
					
					user.setPassword(newpwd.toString());
					userService.update(user);
					us.setAddress(u.getAddress());

					session.removeAttribute("user");
					
					return "success";
				}else{
					//输入密码不对
					return "nosuccess";
				}
			}

			//昵称
			if(user.getNickname()!=null&&!user.getNickname().equals("")) {
				user.setNickname(user.getNickname());
				
				userService.update(user);
				
				//把值设置进一个完整的对象
				us.setNickname(user.getNickname());
				us.setAddress(u.getAddress());

				session.removeAttribute("user");
				session.setAttribute("user", us);
				return "success";
			}
			//性别
			if(user.getSex()!=null&&!user.getSex().equals("")) {
				user.setSex(user.getSex());
				userService.update(user);
				
				us.setSex(user.getSex());
				us.setAddress(u.getAddress());

				session.removeAttribute("user");
				session.setAttribute("user", us);
				return "success";
			}
			//年龄
			if(user.getAge()!=null&&!user.getAge().equals("")) {
				user.setAge(user.getAge());
				userService.update(user);
				//
				us.setAge(user.getAge());
				us.setAddress(u.getAddress());
				session.removeAttribute("user");
				session.setAttribute("user", us);
				return "success";
			}
			//手机号
			if(user.getPhone()!=null&&!user.getPhone().equals("")) {
				user.setPhone(user.getPhone());
				if(us.getPhone()==null||us.getPhone().equals("")) {
					userService.add(user);
				}else{
					userService.update(user);
				}
			}
			//推荐人
			if(user.getReferrer()!=null&&!user.getReferrer().equals("")) {
				user.setReferrer(user.getReferrer());
				if(us.getReferrer()==null||us.getReferrer().equals("")) {
					userService.add(user);
				}else{
					userService.update(user);
				}
			}
			
			//生日
			if(user.getBirthday()!=null&&!user.getBirthday().equals("")) {
				user.setBirthday(user.getBirthday());
				userService.update(user);
				//把值设置进一个完整的对象
				us.setBirthday(user.getBirthday());
				us.setAddress(u.getAddress());
				session.removeAttribute("user");
				
				session.setAttribute("user", us);
				return "success";
			}
			
			//地址因为是虚拟字段，每次更新user相关，都要set Address
			if(user.getProvinceID()!=null&&user.getCityID()!=null&&user.getDistrictID()!=null) {
				user.setProvinceID(user.getProvinceID());
				user.setCityID(user.getCityID());
				user.setDistrictID(user.getDistrictID());
				userService.update(user);
				
				//更新虚拟字段address的值
				Province province=pconService.selProByid(user.getProvinceID());
				City city=pconService.selCityByid(user.getCityID());
				District district=pconService.selDisByid(user.getDistrictID());
				
				us.setProvinceID(user.getProvinceID());
				us.setCityID(user.getCityID());
				us.setDistrictID(user.getDistrictID());
				
				us.setPidName(province.getProvinceName());
				us.setCidName(city.getCityName());
				us.setDidName(district.getDistrictName());
				us.setAddress(province.getProvinceName()+city.getCityName()+district.getDistrictName());
				
				session.removeAttribute("user");
				session.setAttribute("user", us);
				return "success";
			}
		}
		return "null";
	}
	
	//跳转个人中心
	@SystemControllerLog(description="个人中心")
	@RequestMapping("/personal")
	public String userPersonal(@RequestParam(value="rows",defaultValue="1",required=false) int rows,
	Detail detail,Model model,HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user==null) {
			
		}
		PageBean<Detail> pageBean = detailService.findAll(rows,user.getId());
		model.addAttribute("pageBean", pageBean);
		
			//查询出投资记录选项卡内容
			User u=(User) session.getAttribute("user");
			if(u!=null) {
				Integer userid=u.getId();
				if(userid!=null) {
					//累计投资
					double allCorpus = investService.getAllCorpus(userid);
					model.addAttribute("allCorpus",allCorpus);
					//查询累计收益
					double allLucre = investService.getAllLucre(userid, 5);
					model.addAttribute("allLucre",allLucre);
					//查询待收本金
					double waitCorpus = investService.getWaitCorpus(userid, 5);
					model.addAttribute("waitCorpus",waitCorpus);
					//查询待收收益
					double waitLucre = investService.getWaitLucre(userid, 5);
					model.addAttribute("waitLucre", waitLucre);
					//查询用户的投标中记录(status=1)
					PageBean<Invest> invests1 = investService.listByUseridWithStatus(userid, 1,rows);
					model.addAttribute("investList1", invests1);
					//查询用户的回款记录
					PageBean<Invest> invests2 = investService.listByUseridWithStatus(userid, 4,rows);
					model.addAttribute("investList2", invests2);
					//查询用户的完成记录
					PageBean<Invest> invests3 = investService.listByUseridWithStatus(userid, 5,rows);
					model.addAttribute("investList3", invests3);
				}
			}
		return "/frontpage/personal";
	}
	

	
	//跳转投资记录
	@SystemControllerLog(description="跳转投资记录")
	@RequestMapping("/investment")
	public String investment(@ModelAttribute("userid")Integer userid,Model model) {
		model.addAttribute("userid", userid);
		return "forward:/invest/openInvestPage";
	}
	
	//跳转我要借款
	@RequestMapping("userLoan")
	public String userLoan() {
		return "/frontpage/userLoan";
	}
	
	//跳转回款计划
	@SystemControllerLog(description="我的借款")
	@RequestMapping("/payback")
	public String payback(Integer userid,Model model) {
		List<RefundRecord> refundRecord = refundRecordService.getByUserId(userid);
		model.addAttribute("refundRecord", refundRecord);
		return "/frontpage/payback";
	}
	
	//跳转资金记录
	@SystemControllerLog(description="跳转资金记录")
	@RequestMapping("/recordMoney")
	public String recordMoney(
		@RequestParam(value="rows",defaultValue="1",required=false) int rows,
		Detail detail,Model model,HttpSession session){
		User user = (User)session.getAttribute("user");
		if(user==null) {
			
		}
		PageBean<Detail> pageBean = detailService.findAll(rows,user.getId());
		model.addAttribute("pageBean", pageBean);
		return "/frontpage/recordMoney";
	}
	
	
	//跳转开通第三方
	@SystemControllerLog(description="跳转开通第三方")
	@RequestMapping("/thirdParty")
	public String thirdParty(HttpSession session) {
		UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
		//判断是否有第三方交易密码，跳转页面
		
		if(userInfo.getDealPassstatus()==1) {
			//跳转已认证邮箱第三方页面
			return "/frontpage/thirdParty1";
		}else {
			//跳转未认证邮箱第三方页面
			return "/frontpage/thirdParty";
		}
		
	}
	
	//跳转充值
	@SystemControllerLog(description="跳转充值")
	@RequestMapping("/recharge")
	public String recharge(Model model,HttpSession session) {
		User user=(User) session.getAttribute("user");
		List<UserBankcard> listCard=userBankcradService.findBank(user.getId());
		model.addAttribute("listCard", listCard);
		return "/frontpage/recharge1";
	}
	
	//跳转提现
	@SystemControllerLog(description="跳转提现")
	@RequestMapping("/withdrawal")
	public String withdrawal(Model model,HttpSession session) {
		User user=(User) session.getAttribute("user");
		UserMoney money	=userMoneyService.getByuserid(user.getId());
		List<UserBankcard> listCard=userBankcradService.findBank(user.getId());
		model.addAttribute("listCard", listCard);
		model.addAttribute("money", money);
		
		return "/frontpage/withdrawal1";
		
	}
	
	//跳转我的红包
	@SystemControllerLog(description="跳转我的红包")
	@RequestMapping("/envelope")
	public String envelope(HttpSession session,Model model) {
		User user = (User) session.getAttribute("user");
		Integer userid = user.getId();
		//未使用
		List<Redenvelopes> listA=redenvelopesService.findList(userid,0);
		//已使用
		List<Redenvelopes> listB=redenvelopesService.findList(userid,1);
		//已过期
		List<Redenvelopes> listC=redenvelopesService.findList(userid,2);
		model.addAttribute("listA", listA);
		model.addAttribute("listB", listB);
		model.addAttribute("listC", listC);
		
		return "/frontpage/envelope";
	}
	
	//跳转兑换历史
	@SystemControllerLog(description="跳转兑换历史")
	@RequestMapping("/changeHistory")
	public String changeHistory(Model model) {
		List<RedInfo> listR=redInfoService.list();
		model.addAttribute("listR", listR);
		return "/frontpage/changeHistory";
	}
	
	//跳转系统信息
	@SystemControllerLog(description="跳转系统信息")
	@RequestMapping("/systemInfo")
	public String systemInfo() {
		return "/frontpage/systemInfo";
	}
	
	//跳转账户设置
	@SystemControllerLog(description="跳转账户设置")
	@RequestMapping("/userSet")
	public String userSet() {
		return "/frontpage/userSet";
	}
	//查询用户绑定的银行卡
	@SystemControllerLog(description="查询用户绑定的银行卡")
	@RequestMapping("/findBank")
	public String findBank(Model model) {
		List<UserBankcard> listB=userBankcradService.findBank(1);
		model.addAttribute("listB", listB);
		return "/frontpage/recharge1";
	}
	//用户绑定银行卡
	@SystemControllerLog(description="用户绑定银行卡")
	@RequestMapping("/addBankCard")
	public String addBankCard(HttpServletSession session,UserBankcard userBankcard) {
		userBankcradService.add(userBankcard);
		return " ";
	}
	@SystemControllerLog(description="用户还款")
	@ResponseBody
	@RequestMapping("/userhuankuan")
	public String userhuankuan(Double hkmoney,Integer tmarkid,Integer userid,Integer backup1,Integer id,HttpSession session) {
		List<Ip> ip = ipService.list();
		Ip I1 = ip.get(0);
		String sa = null;
		UserMoney userMoney = userMoneyService.getByuserid(userid);
		MarkInfo markInfo = markInfoService.getById(tmarkid);
		userMoney.setAccountMoney(userMoney.getAccountMoney()-hkmoney);
		UserInfo userinfos = userInfoService.getByuserid(userid);
		List<RefundRecord> refundRecord =  refundRecordService.getByUserId(userid);
		List<Invest> invest = investService.getBytmakid(tmarkid);
		for(RefundRecord rf:refundRecord) {
			if(rf.getTmarkid().equals(tmarkid)&&rf.getBackup1().equals(backup1.toString())) {
				double makimaney =(double)investService.getmaney(tmarkid);
				System.out.println(makimaney);
				if(markInfo.getPaymentMode()==1) {
					Double sum = 0.00;
					for(Invest i:invest) {
						double usermaney = EqualityCorpusAndInterest.getPerMonthPrincipalInterest(i.getMarkmoney(), markInfo.getAccrual(), Integer.parseInt(markInfo.getBorrowtime()));
						sum = sum+usermaney;
						UserInfo userinfo = userInfoService.getByuserid(i.getUserid());
						HttpUtil<UserIncomeReq> http = new HttpUtil<>();
						UserIncomeReq userIncomeReq = new UserIncomeReq();
						userIncomeReq.setMoney(usermaney);
						userIncomeReq.setUname1(userinfos.getOpenAccount());
						userIncomeReq.setUname2(userinfo.getOpenAccount());
						userIncomeReq.setUid("zyd7850");
						userIncomeReq.setPass("ling");
						try { 
							String httpurl = "http://"+I1.getIp()+":8080/yzf/srmoney.do";
							String msg=	(String) http.httpRequest(userIncomeReq,httpurl);
							
						  Gson gson = new Gson();  
						  UserIncomeResp userIncomeResp=gson.fromJson(msg, UserIncomeResp.class);
						  if(userIncomeResp.getCode()==800) {
							  rf.setStatus(1);
							  
							  Detail detail1 = new Detail();
							  detail1.setUserid(userid);
							  detail1.setMoney(usermaney);
							  detail1.setDateiltime(new Date());
							  detail1.setRemark("还款");
							  detail1.setStruts(5);
							  Detail detail2 = new Detail();
							  detail2.setUserid(i.getUserid());
							  detail2.setMoney(usermaney);
							  detail2.setDateiltime(new Date());
							  detail2.setRemark("收入");
							  detail2.setStruts(3);
							  
							  Map<Integer, BigDecimal> mapPrincipal = EqualityCorpusAndInterest.getPerMonthInterest(i.getMarkmoney(), markInfo.getAccrual(), Integer.parseInt(markInfo.getBorrowtime()));
							  double zqmoney = mapPrincipal.get(backup1).doubleValue();
							  UserMoney usermaney1 = userMoneyService.getByuserid(i.getUserid());
							  usermaney1.setZqMoney(usermaney1.getZqMoney()+zqmoney);
							  usermaney1.setAccountMoney(usermaney1.getAccountMoney()+userIncomeResp.getMoney());
							  usermaney1.setCollectionMoney(usermaney1.getCollectionMoney()-userIncomeResp.getMoney());
							  usermaney1.setUsableMoney(usermaney1.getUsableMoney()+userIncomeResp.getMoney());
							  
							  UserMoney usermaney2 = userMoneyService.getByuserid(userid);
							  usermaney2.setAccountMoney(usermaney2.getAccountMoney()-userIncomeResp.getMoney());
							  usermaney2.setUsableMoney(usermaney2.getUsableMoney()-userIncomeResp.getMoney());
							  usermaney2.setRepayMoney(usermaney2.getRepayMoney()-userIncomeResp.getMoney());

							  refundRecordService.update(rf);
							  detailService.add(detail1);
							  detailService.add(detail2);
							  userMoneyService.updateUserMoney(usermaney1);
							  userMoneyService.updateUserMoney(usermaney2);
							  
							   sa = "800";
						  }
						  if(userIncomeResp.getCode()==802) {
							  sa = "802";
						  }
						}catch (Exception e) {
							e.printStackTrace();
							sa= "000";
						}
					}
					userMoney=userMoneyService.getByuserid(userid);
					session.setAttribute("userMoney", userMoney);

					if(hkmoney-sum>0) {
						Double maner5= hkmoney-sum;
						BigDecimal perMonthInterest = new BigDecimal(maner5).setScale(2, BigDecimal.ROUND_DOWN);

						IncomeReq incomeReq = new IncomeReq();
						incomeReq.setUidl("zyd7850");
						incomeReq.setPass("ling");
						incomeReq.setMoney(perMonthInterest.doubleValue());
						incomeReq.setUname(userinfos.getOpenAccount());
						HttpUtil<IncomeReq> http = new HttpUtil<>();
						try { 
							String httpurl = "http://"+I1.getIp()+":8080/yzf/income.do";
							String msg=	(String) http.httpRequest(incomeReq,httpurl);
							
						  Gson gson = new Gson();  
						  IncomeResp incomeResp=gson.fromJson(msg, IncomeResp.class);
						  if(incomeResp.getCode()==800) {
							  rf.setStatus(1);
							  
							  Detail detail1 = new Detail();
							  detail1.setUserid(userid);
							  detail1.setMoney(incomeResp.getMoney());
							  detail1.setDateiltime(new Date());
							  detail1.setRemark("还款");
							  detail1.setStruts(5);
							  Detail detail2 = new Detail();
							  detail2.setUserid(1);
							  detail2.setMoney(incomeResp.getMoney());
							  detail2.setDateiltime(new Date());
							  detail2.setRemark("收入");
							  detail2.setStruts(3);
							  

							  FinanceCompany financeCompany = new FinanceCompany();
							  
							  financeCompany.setSumMoney(incomeResp.getMoney());
							  financeCompany.setId(1);
							  
							  UserMoney usermaney2 = userMoneyService.getByuserid(userid);
							  usermaney2.setAccountMoney(usermaney2.getAccountMoney()-incomeResp.getMoney());
							  usermaney2.setUsableMoney(usermaney2.getUsableMoney()-incomeResp.getMoney());
							  usermaney2.setRepayMoney(usermaney2.getRepayMoney()-incomeResp.getMoney());

							  refundRecordService.update(rf);
							  detailService.add(detail1);
							  detailService.add(detail2);
							  financeCompanyService.update(financeCompany);
							  userMoneyService.updateUserMoney(usermaney2);
							  
							  sa= "800";
						  }
						}catch (Exception e) {
							e.printStackTrace();
							sa= "000";
						}

					}
				}else {
					Double sums = 0.00;
					Integer mark  = refundRecordService.getmaxmarkid(tmarkid);
					
					if(mark!=backup1) {
					for(Invest i:invest) {
						double usermaney = InterestAfterPrincipal.getMonthlyInterest(i.getMarkmoney(), markInfo.getAccrual(), Integer.parseInt(markInfo.getBorrowtime()));
						sums = sums+usermaney;
						UserInfo userinfo = userInfoService.getByuserid(i.getUserid());
						HttpUtil<UserIncomeReq> http = new HttpUtil<>();
						UserIncomeReq userIncomeReq = new UserIncomeReq();
						userIncomeReq.setMoney(usermaney);
						userIncomeReq.setUname1(userinfos.getOpenAccount());
						userIncomeReq.setUname2(userinfo.getOpenAccount());
						userIncomeReq.setUid("zyd7850");
						userIncomeReq.setPass("ling");
						try { 
							String httpurl = "http://"+I1.getIp()+":8080/yzf/srmoney.do";
							String msg=	(String) http.httpRequest(userIncomeReq,httpurl);
							
						  Gson gson = new Gson();  
						  UserIncomeResp userIncomeResp=gson.fromJson(msg, UserIncomeResp.class);
						  if(userIncomeResp.getCode()==800) {
							  rf.setStatus(1);
							  
							  Detail detail1 = new Detail();
							  detail1.setUserid(userid);
							  detail1.setMoney(usermaney);
							  detail1.setDateiltime(new Date());
							  detail1.setRemark("还款");
							  detail1.setStruts(5);
							  Detail detail2 = new Detail();
							  detail2.setUserid(i.getUserid());
							  detail2.setMoney(usermaney);
							  detail2.setDateiltime(new Date());
							  detail2.setRemark("收入");
							  detail2.setStruts(3);
							  
							  double zqmoney = InterestAfterPrincipal.getMonthlyInterest(i.getMarkmoney(), markInfo.getAccrual(), Integer.parseInt(markInfo.getBorrowtime()));
							  UserMoney usermaney1 = userMoneyService.getByuserid(i.getUserid());
							  usermaney1.setZqMoney(usermaney1.getZqMoney()+zqmoney);
							  usermaney1.setAccountMoney(usermaney1.getAccountMoney()+userIncomeResp.getMoney());
							  usermaney1.setCollectionMoney(usermaney1.getCollectionMoney()-userIncomeResp.getMoney());
							  usermaney1.setUsableMoney(usermaney1.getUsableMoney()+userIncomeResp.getMoney());
							  
							  UserMoney usermaney2 = userMoneyService.getByuserid(userid);
							  usermaney2.setAccountMoney(usermaney2.getAccountMoney()-userIncomeResp.getMoney());
							  usermaney2.setUsableMoney(usermaney2.getUsableMoney()-userIncomeResp.getMoney());
							  usermaney2.setRepayMoney(usermaney2.getRepayMoney()-userIncomeResp.getMoney());

							  refundRecordService.update(rf);
							  detailService.add(detail1);
							  detailService.add(detail2);
							  userMoneyService.updateUserMoney(usermaney1);
							  userMoneyService.updateUserMoney(usermaney2);
							  
							  sa= "800";
						  }
						  if(userIncomeResp.getCode()==802) {
							  sa= "802";
						  }
						}catch (Exception e) {
							e.printStackTrace();
							sa= "000";
						}
					}
					}else {
						for(Invest i:invest) {
							double usermaney = InterestAfterPrincipal.getMonthlyInterest(i.getMarkmoney(), markInfo.getAccrual(), Integer.parseInt(markInfo.getBorrowtime()));
							
							sums = sums+usermaney+i.getMarkmoney();
							UserInfo userinfo = userInfoService.getByuserid(i.getUserid());
							
							HttpUtil<UserIncomeReq> http = new HttpUtil<>();
							UserIncomeReq userIncomeReq = new UserIncomeReq();
							userIncomeReq.setMoney(usermaney+i.getMarkmoney());
							userIncomeReq.setUname1(userinfos.getOpenAccount());
							userIncomeReq.setUname2(userinfo.getOpenAccount());
							userIncomeReq.setUid("zyd7850");
							userIncomeReq.setPass("ling");
							try { 
								String httpurl = "http://"+I1.getIp()+":8080/yzf/srmoney.do";
								String msg=	(String) http.httpRequest(userIncomeReq,httpurl);
								
							  Gson gson = new Gson();  
							  UserIncomeResp userIncomeResp=gson.fromJson(msg, UserIncomeResp.class);
							  if(userIncomeResp.getCode()==800) {
								  rf.setStatus(1);
								  
								  Detail detail1 = new Detail();
								  detail1.setUserid(userid);
								  detail1.setMoney(usermaney+i.getMarkmoney());
								  detail1.setDateiltime(new Date());
								  detail1.setRemark("还款");
								  detail1.setStruts(5);
								  Detail detail2 = new Detail();
								  detail2.setUserid(i.getUserid());
								  detail2.setMoney(usermaney+i.getMarkmoney());
								  detail2.setDateiltime(new Date());
								  detail2.setRemark("收入");
								  detail2.setStruts(3);
								  
								  double zqmoney = InterestAfterPrincipal.getMonthlyInterest(i.getMarkmoney(), markInfo.getAccrual(), Integer.parseInt(markInfo.getBorrowtime()));
								  UserMoney usermaney1 = userMoneyService.getByuserid(i.getUserid());
								  usermaney1.setZqMoney(usermaney1.getZqMoney()+zqmoney);
								  usermaney1.setAccountMoney(usermaney1.getAccountMoney()+userIncomeResp.getMoney());
								  usermaney1.setCollectionMoney(usermaney1.getCollectionMoney()-userIncomeResp.getMoney());
								  usermaney1.setUsableMoney(usermaney1.getUsableMoney()+userIncomeResp.getMoney());
								  
								  UserMoney usermaney2 = userMoneyService.getByuserid(userid);
								  usermaney2.setAccountMoney(usermaney2.getAccountMoney()-userIncomeResp.getMoney());
								  usermaney2.setUsableMoney(usermaney2.getUsableMoney()-userIncomeResp.getMoney());
								  usermaney2.setRepayMoney(usermaney2.getRepayMoney()-userIncomeResp.getMoney());

								  refundRecordService.update(rf);
								  detailService.add(detail1);
								  detailService.add(detail2);
								  userMoneyService.updateUserMoney(usermaney1);
								  userMoneyService.updateUserMoney(usermaney2);
								  
								  sa= "800";
							  }
							  if(userIncomeResp.getCode()==802) {
								  sa= "802";
							  }
							}catch (Exception e) {
								e.printStackTrace();
								sa= "000";
							}
						}
						
					}
					userMoney=userMoneyService.getByuserid(userid);
					session.setAttribute("userMoney", userMoney);
					System.out.println(hkmoney-sums);
					if(hkmoney-sums>0) {
						Double maner5= hkmoney-sums;
						BigDecimal perMonthInterest = new BigDecimal(maner5).setScale(2, BigDecimal.ROUND_DOWN);
						IncomeReq incomeReq = new IncomeReq();
						incomeReq.setUidl("zyd7850");
						incomeReq.setPass("ling");
						incomeReq.setMoney(perMonthInterest.doubleValue());
						incomeReq.setUname(userinfos.getOpenAccount());
						HttpUtil<IncomeReq> http = new HttpUtil<>();
						try { 
							String httpurl = "http://"+I1.getIp()+":8080/yzf/income.do";
							String msg=	(String) http.httpRequest(incomeReq,httpurl);
							
						  Gson gson = new Gson();  
						  IncomeResp incomeResp=gson.fromJson(msg, IncomeResp.class);
						  if(incomeResp.getCode()==800) {
							  rf.setStatus(1);
							  
							  Detail detail1 = new Detail();
							  detail1.setUserid(userid);
							  detail1.setMoney(incomeResp.getMoney());
							  detail1.setDateiltime(new Date());
							  detail1.setRemark("还款");
							  detail1.setStruts(5);
							  Detail detail2 = new Detail();
							  detail2.setUserid(1);
							  detail2.setMoney(incomeResp.getMoney());
							  detail2.setDateiltime(new Date());
							  detail2.setRemark("收入");
							  detail2.setStruts(3);
							  

							  FinanceCompany financeCompany = new FinanceCompany();
							  FinanceCompany financeCompany1 = financeCompanyService.getById(1);
							  financeCompany.setSumMoney(financeCompany1.getSumMoney()+incomeResp.getMoney());
							  financeCompany.setId(1);
							  
							  UserMoney usermaney2 = userMoneyService.getByuserid(userid);
							  usermaney2.setAccountMoney(usermaney2.getAccountMoney()-incomeResp.getMoney());
							  usermaney2.setUsableMoney(usermaney2.getUsableMoney()-incomeResp.getMoney());
							  usermaney2.setRepayMoney(usermaney2.getRepayMoney()-incomeResp.getMoney());

							  refundRecordService.update(rf);
							  detailService.add(detail1);
							  detailService.add(detail2);
							  financeCompanyService.update(financeCompany);
							  userMoneyService.updateUserMoney(usermaney2);
							  
							  sa= "800";
						  }
						}catch (Exception e) {
							e.printStackTrace();
							sa= "000";
						}

					}

				}

			}
			
		}

		
		return sa;
	}
	
	//测试cookie
	@RequestMapping("cookie")
	public boolean cookie(HttpServletRequest request, HttpServletResponse response, String id) {
	    Cookie cookies[]=request.getCookies();
	    if(cookies != null){
	        for(int i=0;i<cookies.length; i++)
	        {
	            if(cookies[i].getValue().equals(id)){
	                return false;
	            }
	        }
	    }
	    Cookie _cookie=new Cookie(id,  id);
	    _cookie.setMaxAge(60*60*24*365*5);
	    _cookie.setPath("/");
	    response.addCookie(_cookie);
	    return true;
	}
	
	
	//用户本月已收未收查询
	@RequestMapping("/selMoneys")
	@ResponseBody
	public Map<String,Object> selMoneys(HttpSession session) {
		
		Map<String,Object> map = new HashMap<>();
		/**
		 * 设置一个全局变量，以收入和未收入
		 * */
		double haveIncome=0;
		double noIncome=0;
		
		/**
		 * 根据userid查询投资记录表，
		 * 根据投资记录表的markid获取还款表，相关标的利息
		 * 再用投资金额和利息计算
		 * */
		User user=(User) session.getAttribute("user");
		
		List<Invest> invests=investService.getByUserid(user.getId());
		for(int i=0;i<invests.size();i++) {
			Invest invest=invests.get(i);
			double markMoney=invest.getMarkmoney();				//获取投资金额
			
			/**
			 * 获取发标表
			 * */
			MarkInfo markInfo=markInfoService.getById(invest.getTmarkid());
			double accrual=  markInfo.getAccrual();		//获取年化率
			String boorowtime=markInfo.getBorrowtime();		//获取还款分期
			
			/**
			 * 获取还款表，进行分期判断
			 * */
			List<RefundRecord> refundRecords= refundRecordService.getByTmarkid(invest.getTmarkid());
			for(int x=0;x<refundRecords.size();x++) {
				RefundRecord record=refundRecords.get(x);
				Date start=new Date();				
				Date end=record.getRefundtime();
				//判断两个日期是否为同一年，同一月
				
				Calendar c = Calendar.getInstance();
				c.setTime(start);
				Integer startYear=c.get(Calendar.YEAR);
				Integer startMonth=c.get(Calendar.MONTH)+1;
				
				Calendar c2 = Calendar.getInstance();
				c2.setTime(end);
				Integer endYear=c2.get(Calendar.YEAR);
				Integer endMonth=c2.get(Calendar.MONTH)+1;
				
				if(startYear.equals(endYear)&&startMonth.equals(endMonth)) {
					EqualityCorpusAndInterest corpusAndInteres=new EqualityCorpusAndInterest();
					double benxi=corpusAndInteres.getPerMonthPrincipalInterest(markMoney, accrual, Integer.parseInt(boorowtime));
					
					//再比较两个日期大小，判断为未收入或为已收入
					int res = start.compareTo(end);		//相等则返回0,start大返回1,start返回-1;
					if(res>=0) {		//已收入
						haveIncome=haveIncome+benxi;
					}else {			//未收入
						noIncome=noIncome+benxi;
						
					}
				}
			}
			
		}
			map.put("haveIncome", haveIncome);
			map.put("noIncome", noIncome);
			
		return map;
	}
	
	
	
}
