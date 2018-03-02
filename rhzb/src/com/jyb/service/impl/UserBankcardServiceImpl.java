package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.UserBankcardMapper;
import com.jyb.pojo.UserBankcard;
import com.jyb.service.UserBankcardService;
@Transactional
@Service
public class UserBankcardServiceImpl implements UserBankcardService {
	@Resource
	private UserBankcardMapper userBankcardMapper;

	@Override
	public void add(UserBankcard t) {
		userBankcardMapper.add(t);
	}

	@Override
	public List<UserBankcard> list() {
		// TODO Auto-generated method stub
		return userBankcardMapper.list();
	}

	@Override
	public UserBankcard getById(Integer id) {
		// TODO Auto-generated method stub
		return userBankcardMapper.getById(id);
	}

	@Override
	public void update(UserBankcard t) {
		// TODO Auto-generated method stub
		userBankcardMapper.update(t);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		userBankcardMapper.delete(id);
	}

	@Override
	public List<UserBankcard> findBank(Integer id) {
		// TODO Auto-generated method stub
		return userBankcardMapper.findBank(id);
	}

	public List<UserBankcard> findUserBank(String bankcardno) {
		return userBankcardMapper.findUserBank(bankcardno);
	}

	@Override
	public UserBankcard findBankNo(String bankcardno) {
		// TODO Auto-generated method stub
		return userBankcardMapper.findBankNo(bankcardno);
	}
	
	

}
