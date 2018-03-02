package com.jyb.service;


import com.jyb.base.BaseService;
import com.jyb.pojo.UserCredit;
import com.jyb.pojo.UserVip;

public interface UserVipService extends BaseService<Integer, UserVip>{
	//根据userid查询
	UserVip getByuserid(Integer userid);
}
