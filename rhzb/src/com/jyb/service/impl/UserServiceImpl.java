package com.jyb.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.UserMapper;
import com.jyb.pojo.User;
import com.jyb.service.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	/**
	 * 插入
	 * */
	public void add(User t) {
		userMapper.add(t);
	}

	/**
	 * 查询所有
	 * */
	public List<User> list() {
		return userMapper.list();
	}

	/**
	 * 根据ID查询
	 * */
	public User getById(Integer id) {
		return userMapper.getById(id);
	}

	/**
	 * 修改
	 * */
	public void update(User t) {
		userMapper.update(t);
	}

	/**
	 * 删除
	 * */
	public void delete(Integer id) {
		userMapper.delete(id);
	}

	/**
	 * 根据用户名查询
	 * */
	public User getByuserName(String username) {
		return userMapper.getByuserName(username);
	}

	/**
	 * 验证手机号是否存在
	 * */
	public List<User> checkPhone(String phone) {
		return userMapper.checkPhone(phone);
	}

	/**
	 * 验证用户名是否存在
	 * */
	public List<User> checkUsername(String username) {
		return userMapper.checkUsername(username);
	}

	/**
	 * 查询用户电话号码
	 * */
	public User getByuserPhone(String phone) {
		return userMapper.getByuserPhone(phone);
	}

	/**
	 * 根据用户电话号码修改密码
	 * */
	public void updateUserPasssword(User user) {
		userMapper.updateUserPasssword(user);
	}
	//查询注册人数
	public Integer userCount() {
		return userMapper.userCount();
	}

	public List<User> getMonthUserNum(String createTime) {
		return userMapper.getMonthUserNum(createTime);
	}

	public Integer getByUserPid(Integer pid) {
		return userMapper.getByUserPid(pid);
	}

	public List<User> getByUserReferrer(String referrer) {
		return userMapper.getByUserReferrer(referrer);
	}

}
