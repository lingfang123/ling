package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.UserBankcardMapper;
import com.jyb.mapper.UserInfoMapper;
import com.jyb.mapper.UserMapper;
import com.jyb.mapper.UserMoneyMapper;
import com.jyb.mapper.UserRechargeMapper;
import com.jyb.pojo.User;
import com.jyb.pojo.UserBankcard;
import com.jyb.pojo.UserInfo;
import com.jyb.pojo.UserMoney;
import com.jyb.pojo.UserRecharge;
import com.jyb.service.UserBankcardService;
import com.jyb.service.UserInfoService;
import com.jyb.service.UserMoneyService;
import com.jyb.service.UserRechargeService;
import com.jyb.service.UserService;
@Transactional
@Service
public class UserRechargeServiceImpl implements UserRechargeService {
	@Resource
	private UserRechargeMapper userRechargeMapper;

	@Override
	public void add(UserRecharge t) {
		// TODO Auto-generated method stub
		userRechargeMapper.add(t);
	}

	@Override
	public List<UserRecharge> list() {
		// TODO Auto-generated method stub
		return userRechargeMapper.list();
	}

	@Override
	public UserRecharge getById(Integer id) {
		// TODO Auto-generated method stub
		return userRechargeMapper.getById(id);
	}

	@Override
	public void update(UserRecharge t) {
		// TODO Auto-generated method stub
		userRechargeMapper.update(t);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		userRechargeMapper.delete(id);
	}
	
	
}
