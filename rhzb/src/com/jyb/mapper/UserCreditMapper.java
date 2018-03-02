package com.jyb.mapper;

import com.jyb.base.BaseDao;
import com.jyb.pojo.UserCredit;

public interface UserCreditMapper extends BaseDao<Integer, UserCredit>{
	//根据userid查询
	UserCredit getByuserid(Integer userid);
}
