package com.jyb.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyb.annotation.SystemControllerLog;
import com.jyb.pojo.Redenvelopes;
import com.jyb.pojo.User;
import com.jyb.pojo.UserCredit;
import com.jyb.pojo.UserInfo;
import com.jyb.pojo.UserMoney;
import com.jyb.pojo.UserVip;
import com.jyb.service.RedenvelopesService;
import com.jyb.service.UserCreditService;
import com.jyb.service.UserInfoService;
import com.jyb.service.UserMoneyService;
import com.jyb.service.UserService;
import com.jyb.service.UserVipService;
import com.jyb.sms.CodeSMS;
import com.jyb.util.AddressUtils;
/**
 * 用户注册
 * */
@Controller
@RequestMapping("register")
public class RegisterController {
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoService;
	
	@Resource(name="userMoneyServiceImpl")
	private UserMoneyService userMoneyService;
	
	@Resource(name="userCreditServiceImpl")
	private UserCreditService userCreditService;
	
	@Resource(name="userVipServiceImpl")
	private UserVipService userVipService;
	@Resource(name="redenvelopesServiceImpl")
	private RedenvelopesService redenvelopesService;
	/**
	 * 打开注册页面
	 * */
	@SystemControllerLog(description="打开注册页面")
	@RequestMapping("openRegisterPage")
	public String openRegisterPage() {
		return "/frontpage/register";
	}
	/**
	 * 用户注册
	 * @throws UnsupportedEncodingException 
	 * @throws UnknownHostException 
	 * */
	@SystemControllerLog(description="用户注册")
	@RequestMapping("userRegister")
	public String userRegister(User user,HttpSession session) throws UnsupportedEncodingException, UnknownHostException {
		AddressUtils addressUtils = new AddressUtils();
		Object pw = new SimpleHash("MD5",user.getPassword(), ByteSource.Util.bytes(user.getUsername()), 10);	
		user.setPassword(pw.toString());
		user.setUsername(user.getUsername());
		user.setNickname("金源宝用户");
		user.setUserimg("upload/userImg/touxiang.png");
		user.setSex(0);
		user.setAge(0);
		user.setProvinceID(1);
		user.setCityID(1);
		user.setDistrictID(1);
		user.setPhone(user.getPhone());
		user.setCreateTime(new Date());
		user.setMoneyid(user.getMoneyid());
		user.setCreditid(user.getCreditid());
		user.setVipid(user.getVipid());
		user.setReferrer(user.getReferrer());
		//邀请码：时间+手机号 通过 手机号进行加密
		Date d = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		user.setReferrerm((new SimpleHash("MD5",dateFormat.format(d)+user.getPhone(), ByteSource.Util.bytes(user.getPhone()), 10)).toString());
		user.setStatus(1);
		user.setLoginNumber(0);
		user.setLastIp(addressUtils.getIP());
		user.setLastTime(user.getLastTime());
		user.setAreaIp(addressUtils.getAddresses("ip="+addressUtils.getIP(), "utf-8"));
		
		userService.add(user);
		
		//用户注册后，再根据用户名，查询userid
		User u = userService.getByuserName(user.getUsername());
		
		//注册时再把userid设置进userinfo表，再把默认值设置
		UserInfo userInfo=new UserInfo();
		userInfo.setUserid(u.getId());
		userInfo.setNamestatus(0);
		userInfo.setCardstatus(0);
		userInfo.setDealPassstatus(0);
		userInfo.setEmailstatus(0);
		userInfo.setExitgencystatus(0);
		userInfoService.add(userInfo);
		
		//资金表usermoney
		UserMoney userMoney=new UserMoney();
		userMoney.setUserid(u.getId());
		userMoney.setAccountMoney(0);
		userMoney.setCollectionMoney(0);
		userMoney.setFreezeMoney(0);
		userMoney.setRepayMoney(0);
		userMoney.setUsableMoney(0);
		userMoney.setZqMoney(0);
		userMoneyService.add(userMoney);
		
		//用户信用表UserCredit
		UserCredit userCredit=new UserCredit();
		userCredit.setUserid(u.getId());
		userCredit.setIntegral(0);
		userCredit.setJknumber(0);
		userCredit.setLineOfCredit(0);
		userCredit.setYqnumber(0);
		userCreditService.add(userCredit);
		
		//用户vip表
		UserVip userVip=new UserVip();
		userVip.setUserid(u.getId());
		userVip.setVipdj(0);
		userVipService.add(userVip);
		//新人红包
		Date date = new Date();
        
        Redenvelopes redenvelopes1 = new Redenvelopes();
        Redenvelopes redenvelopes2 = new Redenvelopes();
		redenvelopes1.setUserid(u.getId());
		redenvelopes2.setUserid(u.getId());
		redenvelopes1.setHarvesttime(date);
		redenvelopes2.setHarvesttime(date);
		redenvelopes1.setMinmoney(200);
		redenvelopes2.setMinmoney(1000);
		redenvelopes1.setTjmoney(1000);
		redenvelopes2.setTjmoney(5000);
		redenvelopes1.setHbmoney(10);
		redenvelopes2.setHbmoney(50);
		//当前时间加7天
		Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, 7);
        date = ca.getTime();
		
        redenvelopes1.setExpiretime(date);
		redenvelopes2.setExpiretime(date);
		redenvelopes1.setStruts(0);
		redenvelopes2.setStruts(0);
		redenvelopes1.setDaynumber(7);
		redenvelopes2.setDaynumber(7);
		redenvelopes1.setRemark("新人红包");
		redenvelopes2.setRemark("新人红包");
		redenvelopesService.add(redenvelopes1);
		redenvelopesService.add(redenvelopes2);
		
		session.setAttribute("user",u);
		return "/frontpage/register1";
	}
	
	/**
	 * 验证用户名是否存在
	 * */
	@ResponseBody
	@RequestMapping("checkUsername")
	public String checkUsername(@RequestParam("userName") String username) {
		List<User> list = new ArrayList<>();
		list = userService.checkUsername(username);
		if(list.size()==0) {
			return "false";
		}
		return "true";
	}
	
	/**
	 * 验证手机号是否存在
	 * */
	@ResponseBody
	@RequestMapping("checkPhone")
	public String checkphone(@RequestParam("phone") String phone) {
		List<User> list = new ArrayList<>();
		list = userService.checkPhone(phone);
		if(list.size()==0) {
			return "false";
		}
		return "true";
	}
	
	/**
	 * 点击进入我的用户
	 * */
	@SystemControllerLog(description="进入我的用户")
	@RequestMapping("myUser")
	public String myUser(HttpSession session) {
		//User u = (User) session.getAttribute("user");
		//System.out.println(u);
		return "/frontpage/personal";
	}
	/**
	 * 发送手机验证码
	 * @throws IOException 
	 * @throws HttpException 
	 * */
	@ResponseBody
	@RequestMapping("sendCode")
	public Object sendCode(@RequestParam("phone")String phone) throws HttpException, IOException {
		Integer random = (int)((Math.random()*9+1)*100000);
		String context="尊敬的用户：感谢您注册众易贷，您注册的验证码为："+random+"，验证码60秒内有效，为了保证您账户的安全，验证码请勿转发给他人，请及时验证【众易贷】";
		CodeSMS codeSMS = new CodeSMS();
		codeSMS.code(phone, context);
		System.out.println(random);
		return random;
	}
	
	public static void main(String[] args) {
		 Date d = new Date();
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String currdate = format.format(d);
		 System.out.println("现在的日期是：" + currdate);
		 //System.out.println("现在的日期是：" + d);
		 
		         Calendar ca = Calendar.getInstance();
		         ca.add(Calendar.DATE, 9);// num为增加的天数，可以改变的
		 d = ca.getTime();
		 String enddate = format.format(d);
		 System.out.println("增加天数以后的日期：" + enddate);
		 //System.out.println("增加天数以后的日期：" + d);
	}
	
}
