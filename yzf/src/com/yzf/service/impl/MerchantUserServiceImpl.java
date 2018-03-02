package com.yzf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yzf.pojo.MerchantUser;
import com.yzf.repsotory.MerchantUserRepsotory;
import com.yzf.service.MerchantUserService;
@Transactional
@Service
public class MerchantUserServiceImpl implements MerchantUserService{
	@Resource
	private MerchantUserRepsotory merchantUserRepsotory;
	public MerchantUser getMerchantUser(String merchname, String password) {
		return merchantUserRepsotory.getByUsernameAndPassword(merchname, password);
	}
	public void addMerchantUser(MerchantUser merchantUser) {
		merchantUserRepsotory.save(merchantUser);
	}
}
