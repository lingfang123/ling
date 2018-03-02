package com.jyb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyb.pojo.MailInfo;
import com.jyb.pojo.User;
import com.jyb.pojo.UserInfo;
import com.jyb.service.UserInfoService;
import com.jyb.service.UserService;
import com.jyb.sms.CodeSMS;
import com.jyb.util.MailSendUtil;

// 找回用户密码
@Controller
@RequestMapping("forget")
public class ForgetPasswordController {
		@Resource(name="userServiceImpl")
		private UserService userService;
	
		@Resource(name="userInfoServiceImpl")
		private UserInfoService userInfoService;
		
		// 打开第一个找回密码页面   
		@RequestMapping("forgetPassword1")
		public String forgetPassword() {
			return "/frontpage/forgetPassword1";
		}
		
		//  打开第二个找回密码页面   
		@RequestMapping("forgetPassword2")
		public String forget(Model model,String phone) {
			model.addAttribute("phone", phone);
			
			return "/frontpage/forgetPassword2";
		}
		
		//  打开第三个找回密码页面   
		@RequestMapping("forgetPassword3")
		public String forgetPassword3(Model model,String phone) {
			model.addAttribute("phone", phone);
			
			return "/frontpage/forgetPassword3";
		}
		
		// 修改密码 成功或就返回登入页面
		@RequestMapping("forgetPassword4")
		public String forgetPassword4(String phone,String password) {
			String regex = "^1[3-8][0-9]{9}$";
			// 编译正则表达式
			Pattern pattern = Pattern.compile(regex);
			//字符串是否与正则表达式相匹配
			Boolean boolean1 = pattern.matcher(phone).matches();
			if(boolean1) {
				// 当传过来的值是手机格式就进入 这里
				User user = userService.getByuserPhone(phone);
				Object pw = new SimpleHash("MD5",password, ByteSource.Util.bytes(user.getUsername()), 10);
				user.setPassword(pw.toString());
				userService.updateUserPasssword(user);
			}else {
				// 不是手机格式就进入这里
				List<UserInfo> userInfos = new ArrayList<>();
				userInfos = userInfoService.getUserEmail(phone);
				Integer userId = null; 
				for(UserInfo list:userInfos) {
					userId = list.getUserid();
				}
				User users = userService.getById(userId);
				Object psw = new SimpleHash("MD5",password, ByteSource.Util.bytes(users.getUsername()), 10);
				users.setPassword(psw.toString());
				userService.update(users);
			}
			
			return "/frontpage/login";
		}
		
		
		// 发送手机验证码
		@RequestMapping("checkPhoneCode")
		@ResponseBody
		public Map<String,Object> checkPhoneCode(String phone) throws Exception {
			Map<String, Object> result = new HashMap<>();
			
			Integer random =  (int) ((Math.random()*9+1)*100000);
			
			//手机短信验证码
			String context = "您的账户正在提交找回登入密码申请，验证码为："+ random +",请及时认证！为了保证您账户的安全，请勿将此验证码告知他人【众易贷】";
			CodeSMS codeSMS = new CodeSMS();
			codeSMS.code(phone, context);
			
			System.out.println(random);
			result.put("success",random);
			return result;
		}
		
		// 邮箱短信验证码
		@RequestMapping("checkEmailCode")
		@ResponseBody
		public Map<String,Object> checkEmailCode(MailInfo mailInfo) throws Exception{
			Map<String, Object> result = new HashMap<>();
			
			Integer random =  (int) ((Math.random()*9+1)*100000);
			System.out.println(random+"我是QQ邮箱验证码");
			//主题
			mailInfo.setSubject("【众易贷邮箱验证码】");
			mailInfo.setRandom(random.toString());
			String str="您好！<br><br>您收到该信息，是由于在 【众易贷】 (http://localhost:8080/rhzb/forget/forgetPassword2)<br>进行用户找回密码服务，需要通过这个邮箱地址进行验证。如果您并没有访问过 【众易贷】，或没有进行上述操作，请忽略这封邮件。您不需要退订或进行其他进一步的操作。<br><br>您的本次操作的验证码为<br>----------------------------------------------------------------------<br>"+mailInfo.getRandom()+"<br>----------------------------------------------------------------------<br>请注意：该验证码将在60秒后失效，请尽快验证！";
			mailInfo.setContent(str);
			MailSendUtil send = new MailSendUtil();
			send.sendHtmlMail(mailInfo);
			result.put("success",random);
			return result;
		}
		
		
		
		// 判断用户是否绑定了邮箱
		@RequestMapping("checkUserEmailStatus")
		@ResponseBody
		public String checkUserEmailStatus(@RequestParam("email") String email) {
			List<UserInfo> lUserInfos = new ArrayList<>();
			
			lUserInfos = userInfoService.getUserEmail(email);
			
			if(lUserInfos.size() == 0) {
				return "false";
			}
			
			return "true";
			
		}
		
		
}
