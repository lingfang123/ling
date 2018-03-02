package com.jyb.controller;

import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//充值
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jyb.annotation.SystemControllerLog;
import com.jyb.http.HttpUtil;
import com.jyb.pojo.Detail;
import com.jyb.pojo.Ip;
import com.jyb.pojo.User;
import com.jyb.pojo.UserBankcard;
import com.jyb.pojo.UserInfo;
import com.jyb.pojo.UserMoney;
import com.jyb.pojo.UserRecharge;
import com.jyb.pojo.UserWithdraw;
import com.jyb.req.RechargeDetailReq;
import com.jyb.req.WithdrawDepositReq;
import com.jyb.resp.RechargeDetailResp;
import com.jyb.resp.WithdrawDepositResp;
import com.jyb.service.DetailService;
import com.jyb.service.IpService;
import com.jyb.service.UserBankcardService;
import com.jyb.service.UserInfoService;
import com.jyb.service.UserMoneyService;
import com.jyb.service.UserRechargeService;
import com.jyb.service.UserWithdrawService;
import com.jyb.util.AddressUtils;
import com.jyb.util.PageBean;
@Controller
@RequestMapping("userRecharge")
public class UserRechargeController {
	//充值
	@Resource(name="userRechargeServiceImpl")
	private UserRechargeService userRechargeService;
	//明细
	@Resource(name="detailServiceImpl")
	private DetailService detailService;
	//用户资金
	@Resource(name="userMoneyServiceImpl")
	private UserMoneyService userMoneyService;
	//提现表
	@Resource(name="userWithdrawServiceImpl")
	private UserWithdrawService userWithdrawSwevice;
	@Resource(name="userBankcardServiceImpl")
	private UserBankcardService userBankcardService;
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoService;
	@Resource(name="ipServiceImpl")
	private IpService ipService;
	
	
	@RequestMapping("selectRecharge")
	public String listRecharge() {
		
		//return "/frontpage/personal";
		return "/frontpage/recharge1";
	}

	@RequestMapping("list")
	public String list() {
		
		//return "/frontpage/personal";
		return "/frontpage/demo";
	}
	//充值
	@SystemControllerLog(description="充值")
	@ResponseBody
	@RequestMapping("addRecharge")
	public String addRecharge(Double money,String bankCard,HttpSession session) throws UnknownHostException, UnsupportedEncodingException {
		String sa = null;
		User user = (User)session.getAttribute("user");
		List<Ip> ip = ipService.list();
		Ip I1 = ip.get(0);
		if(user.getId()==null) {
			//错误页面
			return "";
		}
		UserInfo userInfo = userInfoService.getByuserid(user.getId());
		UserBankcard bank=new UserBankcard();
		AddressUtils add=new AddressUtils();
		bank = userBankcardService.findBankNo(bankCard);
		Detail detail = new Detail();
		UserMoney userMoney=userMoneyService.getByuserid(user.getId());
		UserRecharge userRecharge = new UserRecharge();
		userRecharge.setRechargeType(1);
		userRecharge.setCztime(new Date());
		userRecharge.setUserid(user.getId());
		userRecharge.setBankcardno(bank.getBankcardno());
		userRecharge.setBankName(bank.getPlacebank());
		userRecharge.setIpAddress(add.getIP());
		userRecharge.setAreaIp(add.getAddresses("ip="+add.getIP(), "utf-8"));
		detail.setUserid(userRecharge.getUserid());
		detail.setMoney(money);
		detail.setDateiltime(userRecharge.getCztime());
		detail.setBychar(userMoney.getAccountMoney());
		detail.setStruts(0);
		userMoney.setAccountMoney(money);
		
		RechargeDetailReq rechargeDetailReq = new RechargeDetailReq();
		rechargeDetailReq.setBankno(bank.getBankcardno());
		rechargeDetailReq.setUsername(userInfo.getOpenAccount());
		rechargeDetailReq.setUid("zyd7850");
		rechargeDetailReq.setPass("ling");
		rechargeDetailReq.setMoney(money);
		
		HttpUtil<RechargeDetailReq> http = new HttpUtil<>();
		try { 
			String httpurl = "http://"+I1.getIp()+":8080/yzf/addRechargeDetail.do";
			String msg=	(String) http.httpRequest(rechargeDetailReq,httpurl);
			
		  Gson gson = new Gson();  
		  RechargeDetailResp rechargeDetailResp=gson.fromJson(msg, RechargeDetailResp.class);
		  
		  if(rechargeDetailResp.getCode()==401) {
			  	userRecharge.setBillcode(rechargeDetailResp.getLsnumber());
			  	userRecharge.setPaynumber(rechargeDetailResp.getLsnumber());
				userRechargeService.add(userRecharge);
				detailService.add(detail);
				userRecharge.setRechargeMoney(rechargeDetailResp.getMoney());
				userMoneyService.updateAdd(userMoney);
				System.out.println("充值成功");
				userMoney=userMoneyService.getByuserid(user.getId());
				session.setAttribute("userMoney", userMoney);
				sa = "401";
		  }
		  if(rechargeDetailResp.getCode()==101) {
			  System.out.println("没有找到合作公司");
			  	sa = "101";
		  }
		  
		  if(rechargeDetailResp.getCode()==201) {
			  System.out.println("银行卡不存在");
			  	sa = "201";
		  }

		  if(rechargeDetailResp.getCode()==400) {
			  System.out.println("银行卡没有这么多钱");
			  sa = "400";
		  }
		  if(rechargeDetailResp.getCode()==105) {
			  System.out.println("没有开通第三方");
			  sa = "105";
		  }
		  if(rechargeDetailResp.getCode()==403) {
			  System.out.println("充值异常");
			  sa = "403";
		  }

		} catch (Exception e) {
			e.printStackTrace();
			sa = "000";
		}

	
		
		return sa;
	}
	
	//提现
	@SystemControllerLog(description="提现")
	@ResponseBody
	@RequestMapping("updateMoney")
	public String addMoney(Double money,String bankCard,HttpSession session) throws UnknownHostException, UnsupportedEncodingException {
		String sa = null;
		Date dateTime = new Date();
		List<Ip> ip = ipService.list();
		Ip I1 = ip.get(0);
		UserBankcard bank=userBankcardService.findBankNo(bankCard);
		User userse=(User) session.getAttribute("user");
		UserInfo userInfo = userInfoService.getByuserid(userse.getId());
		WithdrawDepositReq withdrawDepositReq = new WithdrawDepositReq();
		withdrawDepositReq.setBankno(bank.getBankcardno());
		withdrawDepositReq.setUname(userInfo.getOpenAccount());
		withdrawDepositReq.setUid("zyd7850");
		withdrawDepositReq.setPass("ling");
		withdrawDepositReq.setMoney(money);

		HttpUtil<WithdrawDepositReq> http = new HttpUtil<>();
		try { 
			String httpurl = "http://"+I1.getIp()+":8080/yzf/addWithdrawDeposit.do";
			String msg=	(String) http.httpRequest(withdrawDepositReq,httpurl);
			
			Gson gson = new Gson();  
			WithdrawDepositResp withdrawDepositResp=gson.fromJson(msg, WithdrawDepositResp.class);
			
			  if(withdrawDepositResp.getCode()==500) {
					User user=(User) session.getAttribute("user");
					AddressUtils add=new AddressUtils();
					UserWithdraw userWithdraw = new UserWithdraw();
					userWithdraw.setUserid(user.getId());
					userWithdraw.setArriveMoney(money);
					userWithdraw.setWithdrawMoney(money);
					userWithdraw.setWithdrawTime(new Date());
					userWithdraw.setBankcardno(bank.getBankcardno());
					userWithdraw.setBankName(bank.getPlacebank());
					userWithdraw.setIpAddress(add.getIP());
					userWithdraw.setOperatorId(1);
					userWithdraw.setStatus(2);
					userWithdraw.setAreaIp(add.getAddresses("ip="+add.getIP(), "utf-8"));
					UserMoney userMoney=userMoneyService.getByuserid(user.getId());
					Detail detail=new Detail();
					
					
					detail.setUserid(userWithdraw.getUserid());
					detail.setDateiltime(dateTime);
					detail.setStruts(1);

				  	userWithdraw.setPoundage(withdrawDepositResp.getSxmoney());
				  	userWithdraw.setArriveTime(new Date());
					userWithdrawSwevice.add(userWithdraw);
					userMoney.setAccountMoney(userMoney.getAccountMoney()-(money+withdrawDepositResp.getSxmoney()));
					userMoneyService.update(userMoney);
					detail.setMoney(money);
					detail.setBychar(userMoney.getAccountMoney());
					detailService.add(detail);

					
					
					System.out.println("提现成功");
					userMoney=userMoneyService.getByuserid(user.getId());
					session.setAttribute("userMoney", userMoney);
					sa = "500";
			  }
			  if(withdrawDepositResp.getCode()==101) {
				  System.out.println("没有找到合作公司");
				  	sa = "101";
			  }
			  
			  if(withdrawDepositResp.getCode()==201) {
				  System.out.println("银行卡不存在");
				  	sa = "201";
			  }

			  if(withdrawDepositResp.getCode()==503) {
				  System.out.println("用户提现出现异常");
				  sa = "503";
			  }

			  if(withdrawDepositResp.getCode()==105) {
				  System.out.println("没有开通第三方");
				  sa = "105";
			  }

		}catch (Exception e) {
			e.printStackTrace();
			sa = "000";
		}
		
		return sa;
	}
	//查询资金明细
	@SystemControllerLog(description="查询资金明细")
	@RequestMapping("selectDetail")
	public String selectDetail(
		@RequestParam(value="rows",defaultValue="1",required=false) int rows,
		Detail detail,Model model,HttpSession session) {
		User user = (User)session.getAttribute("user");
		if(user==null) {
			
		}
		PageBean<Detail> pageBean = detailService.findAll(rows,user.getId());
		model.addAttribute("pageBean", pageBean);
		return "/frontpage/recordMoney";
    
	}
	@ResponseBody
	@RequestMapping("yzpassword")
	public String password(String pass,HttpSession session) {
		String sa = null;
		User user = (User)session.getAttribute("user");
		if(user==null) {
			return "";
		}
		//根据用户 id 查询用户的交易密码
		UserInfo info=userInfoService.getByuserid(user.getId());
		//对输入密码进行加密
		Object oldpwd = new SimpleHash("MD5",pass, ByteSource.Util.bytes(user.getUsername()), 10);
		
		if(oldpwd.toString().equals(info.getDealPassword())) {
			sa="true";
		}else {
			sa="false";
		}
		

		return sa;
	}
	
	
	
}
