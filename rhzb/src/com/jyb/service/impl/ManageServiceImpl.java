package com.jyb.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.CityMapper;
import com.jyb.pojo.City;
import com.jyb.pojo.Manage;
import com.jyb.service.CityService;
import com.jyb.service.ManageService;
@Transactional
@Service
public class ManageServiceImpl implements ManageService{

	@Override
	public void add(Manage t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Manage> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Manage getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Manage t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	
}
