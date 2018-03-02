package com.jyb.mapper;

import java.util.Date;
import java.util.List;

import com.jyb.base.BaseDao;
import com.jyb.pojo.User;

public interface UserMapper extends BaseDao<Integer,User>{
	//根据用户名查询
	User getByuserName(String username);
	//验证手机号是否存在
	List<User> checkPhone(String phone);
	//验证用户名是否存在
	List<User> checkUsername(String username);
	//用户电话号码
	User getByuserPhone(String phone);
	//根据用户电话号码修改密码
	void updateUserPasssword(User user);
	//查询注册人数
	Integer userCount();
	// 通过时间查找注册人数
	List<User> getMonthUserNum(String createTime);
	//根据省份查寻各省注册人数
	Integer getByUserPid(Integer pid);
	List<User> getByUserReferrer(String referrer);
}
