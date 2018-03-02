package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.RedInfoMapper;
import com.jyb.pojo.RedInfo;
import com.jyb.service.RedInfoService;
@Transactional
@Service
public class RedInfoServiceImpl implements RedInfoService{
	@Resource
	private RedInfoMapper redInfoMapper;
	@Override
	public void add(RedInfo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RedInfo> list() {
		
		return redInfoMapper.list();
	}

	@Override
	public RedInfo getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(RedInfo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
