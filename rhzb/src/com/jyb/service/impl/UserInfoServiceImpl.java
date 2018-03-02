package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.UserInfoMapper;
import com.jyb.pojo.UserInfo;
import com.jyb.service.UserInfoService;
@Transactional
@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Resource
	private UserInfoMapper userInfoMapper;

	public void add(UserInfo t) {
		userInfoMapper.add(t);		
	}
	public List<UserInfo> list() {
		return userInfoMapper.list();
	}
	public UserInfo getById(Integer id) {
		return userInfoMapper.getById(id);
	}
	public void update(UserInfo t) {
		userInfoMapper.update(t);
	}
	public void delete(Integer id) {
		userInfoMapper.delete(id);
	}
	public UserInfo getByuserid(Integer userid) {
		return userInfoMapper.getByuserid(userid);
	}
	public List<UserInfo> getUserEmail(String email) {
		return userInfoMapper.getUserEmail(email);
	}
}
