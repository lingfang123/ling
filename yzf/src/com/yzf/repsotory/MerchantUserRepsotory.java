package com.yzf.repsotory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yzf.pojo.MerchantUser;
public interface MerchantUserRepsotory extends JpaRepository<MerchantUser, Integer>{
	MerchantUser getByUsernameAndPassword(String username,String password);
}
