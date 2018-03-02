package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.UserCreditMapper;
import com.jyb.mapper.UserInfoMapper;
import com.jyb.pojo.UserCredit;
import com.jyb.pojo.UserInfo;
import com.jyb.service.UserCreditService;
import com.jyb.service.UserInfoService;
@Transactional
@Service
public class UserCreditServiceImpl implements UserCreditService {
	@Resource
	private UserCreditMapper userCreditMapper;

	@Override
	public void add(UserCredit t) {
		// TODO Auto-generated method stub
		userCreditMapper.add(t);
	}

	@Override
	public List<UserCredit> list() {
		// TODO Auto-generated method stub
		return userCreditMapper.list();
	}

	@Override
	public UserCredit getById(Integer id) {
		// TODO Auto-generated method stub
		return userCreditMapper.getById(id);
	}

	@Override
	public void update(UserCredit t) {
		// TODO Auto-generated method stub
		userCreditMapper.update(t);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		userCreditMapper.delete(id);
	}

	@Override
	public UserCredit getByuserid(Integer userid) {
		// TODO Auto-generated method stub
		return userCreditMapper.getByuserid(userid);
	}

	
}
