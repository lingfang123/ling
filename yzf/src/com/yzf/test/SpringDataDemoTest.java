package com.yzf.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yzf.pojo.BankCardMn;
import com.yzf.service.BankCardMnService;
import com.yzf.service.impl.BankCardMnServiceImpl;

public class SpringDataDemoTest {
	private ApplicationContext ctx = null;
	private BankCardMnService bankCardMnService = null;
	public SpringDataDemoTest(){
		ctx = new ClassPathXmlApplicationContext("classPath:applicationContext.xml");
		bankCardMnService = ctx.getBean(BankCardMnServiceImpl.class);
	}
	@Test
	public void ad() {
		BankCardMn bm = new BankCardMn();
		bm.setName("凌云");
		bm.setPhone("15779897850");
		bm.setBankcardno("6227");
		bm.setSfbankcardno("360734");
		BankCardMn bcm = bankCardMnService.getBankCardMn(bm);
		System.out.println(bcm);
	}
}
