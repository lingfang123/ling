package com.jyb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyb.annotation.SystemControllerLog;
import com.jyb.pojo.MailInfo;
import com.jyb.util.MailSendUtil;

@Controller
public class EmailController {
	@SystemControllerLog(description="rzemail")
	@RequestMapping("rzemail")
	@ResponseBody
	public Map<String,Object> rzEmail(MailInfo mailInfo) throws Exception{
		Map<String,Object> result = new HashMap<>();
		Integer random=(int)((Math.random()*9+1)*100000);
		
		mailInfo.setRandom(random.toString());
		//主题
		mailInfo.setSubject("【众易贷邮箱验证码】");
		String str="您好！<br><br>您收到该信息，是由于在 【众易贷】 (http://localhost:8080/rhzb/user/personal)<br>进行了新用户注册，或修改账户信息时，需要通过这个邮箱地址进行验证。如果您并没有访问过 【众易贷】，或没有进行上述操作，请忽略这封邮件。您不需要退订或进行其他进一步的操作。<br><br>您的本次操作的验证码为<br>----------------------------------------------------------------------<br>"+mailInfo.getRandom()+"<br>----------------------------------------------------------------------<br>请注意：该验证码将在60秒后失效，请尽快验证！";
		mailInfo.setContent(str);
		

		//调用发送
		MailSendUtil send = new MailSendUtil();
		send.sendHtmlMail(mailInfo);
		result.put("success", random);

		return result;
	}
}
