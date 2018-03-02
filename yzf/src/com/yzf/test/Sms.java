package com.yzf.test;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.yzf.util.CodeSMS;

public class Sms {
	public static void main(String[] args) throws HttpException, IOException {
		CodeSMS sms = new CodeSMS();
		String phone = "15779897850";
		String context = "尊敬的用户：感谢您注册众易贷，您注册的验证码为："+23411+"，验证码1分钟内有效，为了保证您账户的安全，验证码请勿转发给他人，请及时验证【众意贷】";
		sms.code(phone, context);
	}
}
