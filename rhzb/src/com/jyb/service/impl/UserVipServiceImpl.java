package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.UserCreditMapper;
import com.jyb.mapper.UserInfoMapper;
import com.jyb.mapper.UserVipMapper;
import com.jyb.pojo.UserCredit;
import com.jyb.pojo.UserInfo;
import com.jyb.pojo.UserVip;
import com.jyb.service.UserCreditService;
import com.jyb.service.UserInfoService;
import com.jyb.service.UserVipService;
@Transactional
@Service
public class UserVipServiceImpl implements UserVipService {
	@Resource
	private UserVipMapper userVipMapper;

	@Override
	public void add(UserVip t) {
		// TODO Auto-generated method stub
		userVipMapper.add(t);
	}

	@Override
	public List<UserVip> list() {
		// TODO Auto-generated method stub
		return userVipMapper.list();
	}

	@Override
	public UserVip getById(Integer id) {
		// TODO Auto-generated method stub
		return userVipMapper.getById(id);
	}

	@Override
	public void update(UserVip t) {
		// TODO Auto-generated method stub
		userVipMapper.update(t);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		userVipMapper.delete(id);
	}

	@Override
	public UserVip getByuserid(Integer userid) {
		// TODO Auto-generated method stub
		return userVipMapper.getByuserid(userid);
	}
	
	
}
