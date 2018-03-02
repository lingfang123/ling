package com.jyb.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyb.annotation.SystemControllerLog;
import com.jyb.sms.CodeSMS;

@Controller
public class PhoneController {
	@SystemControllerLog(description="yzphone")
	@RequestMapping("yzphone")
	@ResponseBody
	public Map<String,Object> yzPhone(String phone) throws Exception{
		Map<String,Object> result = new HashMap<>();
		
		Integer random=(int)((Math.random()*9+1)*100000);
		String context="您的账户正在提交更换邮箱申请，验证码为：{"+random+"},请及时认证！为了保证您账户的安全，请勿将此验证码告知他人【众易贷】";
		
		CodeSMS codeSMS=new CodeSMS();
		codeSMS.code(phone, context);
		
		result.put("success", random);
		System.out.println(random);
		return result;
	}
}