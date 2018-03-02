package com.jyb.controller;

import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jyb.annotation.SystemControllerLog;
import com.jyb.pojo.City;
import com.jyb.pojo.Detail;
import com.jyb.pojo.District;
import com.jyb.pojo.Invest;
import com.jyb.pojo.Province;
import com.jyb.pojo.User;
import com.jyb.pojo.UserCredit;
import com.jyb.pojo.UserInfo;
import com.jyb.pojo.UserMoney;
import com.jyb.pojo.UserVip;
import com.jyb.service.DetailService;
import com.jyb.service.InvestService;
import com.jyb.service.PconService;
import com.jyb.service.UserCreditService;
import com.jyb.service.UserInfoService;
import com.jyb.service.UserMoneyService;
import com.jyb.service.UserService;
import com.jyb.service.UserVipService;
import com.jyb.util.AddressUtils;
import com.jyb.util.IdcardInfoExtractor;
import com.jyb.util.PageBean;
import com.jyb.util.StringSplitUtil;
@Controller
@RequestMapping("/login")
public class FrontdeskLoginController {
	/**
	 * 前台登入
	 * */
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@Resource(name="userMoneyServiceImpl")
	private UserMoneyService userMoneyService;
	
	@Resource(name="userCreditServiceImpl")
	private UserCreditService userCreditService;
	
	@Resource(name="userVipServiceImpl")
	private UserVipService userVipService;
	
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoService;
	
	@Resource(name="pconServiceImpl")
	private PconService pconService;
	
	@Resource(name="detailServiceImpl")
	private DetailService detailService;
	
	@Resource(name="investServiceImpl")
	private InvestService investService;
	
	//跳转登陆页面
	@RequestMapping("/userLogin")
	public String userLogin() {
		return "/frontpage/login";
	}
	//登陆验证
	@SystemControllerLog(description="登陆验证")
	@RequestMapping("/loginVerify")
	public String loginVerify(@RequestParam(value="rows",defaultValue="1",required=false) int rows,@RequestParam("phone") String phone,@RequestParam("password") String password,HttpSession session,Model model) throws UnknownHostException, UnsupportedEncodingException {
		UsernamePasswordToken token =new UsernamePasswordToken(phone, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		}catch(AuthenticationException e) {
			model.addAttribute("loginFail", "用户名或密码错误");
			return "/frontpage/login";
		}
		AddressUtils addressUtils = new AddressUtils();
		User user = userService.getByuserPhone(phone);

		user.setLoginNumber(user.getLoginNumber()+1);
		user.setLastIp(addressUtils.getIP());
		user.setLastTime(new Date());
		user.setAreaIp(addressUtils.getAddresses("ip="+addressUtils.getIP(), "utf-8"));
		userService.update(user);
		
		//判断省市县是否为空
		if(user.getProvinceID()!=null&&user.getCityID()!=null&&user.getDistrictID()!=null) {
			Province province=pconService.selProByid(user.getProvinceID());
			City city=pconService.selCityByid(user.getCityID());
			District district=pconService.selDisByid(user.getDistrictID());
		
			//把相关值设置进虚拟字段
			user.setPidName(province.getProvinceName());
			user.setCidName(city.getCityName());
			user.setDidName(district.getDistrictName());
			user.setAddress(province.getProvinceName()+city.getCityName()+district.getDistrictName());
		}
		
		
		user.setNickname(user.getNickname());
		//创建截取字符串对象,
		StringSplitUtil splitUtil=new StringSplitUtil();
		user.setPhoneYC(splitUtil.phoneCut(user.getPhone()));	//设置隐藏的手机号
		
		/**
		 * 获取用户资金表的信息
		 * */
		UserMoney userMoney=userMoneyService.getByuserid(user.getId());
		session.setAttribute("userMoney", userMoney);
		
		/**
		 * 获取用户信用表信息
		 * */
		UserCredit userCredit=userCreditService.getByuserid(user.getId());
		session.setAttribute("userCredit", userCredit);
		
		/**
		 * 获取用户vip表信息
		 * */
		UserVip userVip=userVipService.getByuserid(user.getId());
		session.setAttribute("userVip", userVip);
		
		/**
		 * 获取用户安全信息表
		 * */
		UserInfo userInfo=userInfoService.getByuserid(user.getId());
		//把紧急联系人设置进userinfo 的session中
		if(userInfo.getEmailstatus()==1) {
			//设置隐藏的邮箱
			userInfo.setEmailYC(splitUtil.emailCut(userInfo.getEmail()));
		}
		if(userInfo.getExitgencyphone()!=null&&!userInfo.getExitgencyphone().equals("")) {
			userInfo.setExitgencyphone(splitUtil.phoneCut(userInfo.getExitgencyphone()));
		}
		
		//判断身份证号是否为空，如果不为空，根据身份证号获取性别，年龄，生日等信息
		if(userInfo.getIdentityCard()!=null&&!userInfo.getIdentityCard().equals("")) {
			IdcardInfoExtractor idcardInfo=new IdcardInfoExtractor(userInfo.getIdentityCard());  
			String birthday=idcardInfo.getYear()+"-"+idcardInfo.getMonth()+"-"+idcardInfo.getDay();
			Integer sex=idcardInfo.getGenderId();
			Integer age=idcardInfo.getAge();
			String address=idcardInfo.getProvince()+idcardInfo.getCity()+idcardInfo.getRegion();
			
			//再对性别，生日等判断是否为空
			if(user.getBirthday()==null ||user.getBirthday().equals("")) {
				user.setBirthday(birthday);
			}
			if(user.getSex()==null) {
				user.setSex(sex);
			}
			if(user.getAge()==null) {
				user.setAge(age);
			}
			if(user.getAddress()==null) {
				user.setAddress(address);
			}
		}
		
		session.setAttribute("userInfo", userInfo);
		
		session.setAttribute("user", user);
		
		//首页选项卡，资金记录
		PageBean<Detail> pageBean = detailService.findAll(rows,user.getId());
		model.addAttribute("pageBean", pageBean);
		
		//首页选项卡，投资记录
		//累计投资
		double allCorpus = investService.getAllCorpus(user.getId());
		model.addAttribute("allCorpus",allCorpus);
		//查询累计收益
		double allLucre = investService.getAllLucre(user.getId(), 5);
		model.addAttribute("allLucre",allLucre);
		//查询待收本金
		double waitCorpus = investService.getWaitCorpus(user.getId(), 5);
		model.addAttribute("waitCorpus",waitCorpus);
		//查询待收收益
		double waitLucre = investService.getWaitLucre(user.getId(), 5);
		model.addAttribute("waitLucre", waitLucre);
		//查询用户的投标中记录(status=1)
		PageBean<Invest> invests1 = investService.listByUseridWithStatus(user.getId(), 1,rows);
		model.addAttribute("investList1", invests1);
		//查询用户的回款记录
		PageBean<Invest> invests2 = investService.listByUseridWithStatus(user.getId(), 4,rows);
		model.addAttribute("investList2", invests2);
		//查询用户的完成记录
		PageBean<Invest> invests3 = investService.listByUseridWithStatus(user.getId(), 5,rows);
		model.addAttribute("investList3", invests3);
		return "/frontpage/personal";
	}
	
	/**
	 * 用户安全退出
	 * */
	@SystemControllerLog(description="用户安全退出")
	@RequestMapping("loginOut")
	public String loginOut(HttpSession session) {
		session.removeAttribute("user");
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "/frontpage/login";
	}
	
}
