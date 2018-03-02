package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.jyb.mapper.UserWithdrawMapper;
import com.jyb.pojo.UserWithdraw;
import com.jyb.service.UserWithdrawService;
@Transactional
@Service
public class UserWithdrawServiceImpl implements UserWithdrawService {
	@Resource
	private UserWithdrawMapper userWithdrawMapper;

	@Override
	public void add(UserWithdraw t) {
		// TODO Auto-generated method stub
		userWithdrawMapper.add(t);
	}

	@Override
	public List<UserWithdraw> list() {
		// TODO Auto-generated method stub
		return userWithdrawMapper.list();
	}

	@Override
	public UserWithdraw getById(Integer id) {
		// TODO Auto-generated method stub
		return userWithdrawMapper.getById(id);
	}

	@Override
	public void update(UserWithdraw t) {
		// TODO Auto-generated method stub
		userWithdrawMapper.update(t);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		userWithdrawMapper.delete(id);
	}
	
	
}
