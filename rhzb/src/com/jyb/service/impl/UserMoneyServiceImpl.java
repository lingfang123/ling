package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.jyb.mapper.UserMoneyMapper;
import com.jyb.pojo.UserMoney;
import com.jyb.service.UserMoneyService;
@Transactional
@Service
public class UserMoneyServiceImpl implements UserMoneyService {
	@Resource
	private UserMoneyMapper userMoneyMapper;

	public void add(UserMoney t) {
		userMoneyMapper.add(t);
	}

	public List<UserMoney> list() {
		return userMoneyMapper.list();
	}

	public UserMoney getById(Integer id) {
		return userMoneyMapper.getById(id);
	}

	public void update(UserMoney t) {
		userMoneyMapper.update(t);
	}

	public void delete(Integer id) {
		userMoneyMapper.delete(id);
	}

	public UserMoney getByuserid(Integer userid) {
		return userMoneyMapper.getByuserid(userid);
	}

	public void updateAdd(UserMoney userMoney) {
		userMoneyMapper.updateAdd(userMoney);
	}

	public void updateUserMoney(UserMoney userMoney) {
		userMoneyMapper.updateUserMoney(userMoney);
	}

	public void updateUserMoneyh(UserMoney userMoney) {
		userMoneyMapper.updateUserMoneyh(userMoney);
	}

	public double sumZqmoney() {
		return userMoneyMapper.sumZqmoney();
	}
}
