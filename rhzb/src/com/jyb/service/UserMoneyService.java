package com.jyb.service;

import com.jyb.base.BaseService;
import com.jyb.pojo.UserMoney;

public interface UserMoneyService extends BaseService<Integer, UserMoney>{
	//根据userid查询
	UserMoney getByuserid(Integer userid);
	//充值
	void updateAdd(UserMoney userMoney);
	//修改数据
	void updateUserMoney(UserMoney userMoney);
	void updateUserMoneyh(UserMoney userMoney);
	//平台为用户赚取金额
	double sumZqmoney();
}
