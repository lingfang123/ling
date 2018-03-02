package com.jyb.service;


import com.jyb.base.BaseService;
import com.jyb.pojo.UserCredit;

public interface UserCreditService extends BaseService<Integer, UserCredit>{
	//根据userid查询
	UserCredit getByuserid(Integer userid);
}
