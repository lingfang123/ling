package com.jyb.mapper;

import java.util.List;

import com.jyb.base.BaseDao;
import com.jyb.pojo.UserInfo;

public interface UserInfoMapper extends BaseDao<Integer,UserInfo>{
	//根据userid查询
	UserInfo getByuserid(Integer userid);
	//依据email查询
	List<UserInfo> getUserEmail(String email);
}
