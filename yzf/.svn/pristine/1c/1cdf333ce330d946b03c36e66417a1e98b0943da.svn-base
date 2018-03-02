package com.yzf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yzf.pojo.User;
import com.yzf.repsotory.UserRepsotory;
import com.yzf.service.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserRepsotory userRepsotory;
	public void userRegister(User user) {
		userRepsotory.save(user);
	}
	public User getUser(String username) {
		return userRepsotory.getByUsername(username);
	}
}
