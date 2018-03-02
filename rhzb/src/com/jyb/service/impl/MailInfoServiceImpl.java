package com.jyb.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.CityMapper;
import com.jyb.pojo.City;
import com.jyb.pojo.MailInfo;
import com.jyb.service.CityService;
import com.jyb.service.MailInfoService;
@Transactional
@Service
public class MailInfoServiceImpl implements MailInfoService{

	@Override
	public void add(MailInfo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MailInfo> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MailInfo getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(MailInfo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
