package com.jyb.mapper;

import com.jyb.base.BaseDao;
import com.jyb.pojo.UserMoney;

public interface UserMoneyMapper extends BaseDao<Integer,UserMoney>{
	//充值
	void updateAdd(UserMoney userMoney);
	//根据userid查询
	UserMoney getByuserid(Integer userid);
	//修改数据
	void updateUserMoney(UserMoney userMoney);
	void updateUserMoneyh(UserMoney userMoney);
	//平台为用户赚取金额
	double sumZqmoney();
}
