package com.jyb.service;

import java.util.List;

import com.jyb.base.BaseService;
import com.jyb.pojo.UserInfo;

public interface UserInfoService extends BaseService<Integer, UserInfo>{
	//根据userid查询
	UserInfo getByuserid(Integer userid);
	//依据email查询
	List<UserInfo> getUserEmail(String email);
}
