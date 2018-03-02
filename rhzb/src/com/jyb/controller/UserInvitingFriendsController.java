package com.jyb.controller;

import java.net.UnknownHostException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jyb.pojo.User;
import com.jyb.service.UserService;
import com.jyb.util.AddressUtils;
import com.jyb.util.ZxingQRcode;

@Controller
@RequestMapping("InvitingFriends")
public class UserInvitingFriendsController {
	/* 这是用户邀请好友的 Controler*/
	
	// 用户
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	// 打开邀请好友页面
	@RequestMapping("UserInvitingFriends")
	public  String UserInvitingFriends(
			@ModelAttribute("userid") Integer suerid,
			HttpSession session,Model model,
			HttpServletRequest request) throws UnknownHostException {
		User user = (User) session.getAttribute("user");
		AddressUtils AddressUtils= new AddressUtils();
		// 调用二维码
		ZxingQRcode qRcode = new ZxingQRcode();
		// 二维码内容
		String context = "http://"+AddressUtils.getIP()+":8080/rhzb/register/openRegisterPage?referrerm="+user.getReferrerm();
		// 二维码小图标       
		String path = "F:\\tomcat\\apache-tomcat-9.0.0.M22\\webapps\\update\\logo1.png";
		// 二维码存放路径	
		String codepath = "F:\\tomcat\\apache-tomcat-9.0.0.M22\\webapps\\update\\"+user.getId();
		qRcode.createQRcode(context,path,codepath);
		List<User> usera = userService.getByUserReferrer(user.getReferrerm());
		User users = userService.getById(suerid);
		model.addAttribute("users",users);
		model.addAttribute("ipa", AddressUtils.getIP());
		model.addAttribute("usera", usera);
		return "/frontpage/UserInvitingFriends";
	} 
	 
	public static void main(String[] args) {
		ZxingQRcode qRcode = new ZxingQRcode();
		AddressUtils AddressUtils = new AddressUtils();
		try {
			qRcode.createQRcode("http://"+AddressUtils.getIP()+":8080/rhzb/index/frontpage", "F:\\tomcat\\apache-tomcat-9.0.0.M22\\webapps\\update\\logo1.png", "F:\\tomcat\\apache-tomcat-9.0.0.M22\\webapps\\update\\rhzb");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
