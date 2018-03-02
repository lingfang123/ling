package com.yzf.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yzf.pojo.MerchantUser;
import com.yzf.service.MerchantUserService;
@Controller
public class MerchantUserController {
	@Resource(name="merchantUserServiceImpl")
	private MerchantUserService merchantUserService;
	@RequestMapping("adsas")
	@ResponseBody
	public MerchantUser getMerchantUser() {
		String username = "zyd7850";
		String pasword = "ling";
		MerchantUser merchantUser = merchantUserService.getMerchantUser(username, pasword);
		if(merchantUser==null) {
			return merchantUser;
		}
		merchantUser.setSiteurl("11111111111111111");
		merchantUserService.addMerchantUser(merchantUser);
		return merchantUser;
	}
}
