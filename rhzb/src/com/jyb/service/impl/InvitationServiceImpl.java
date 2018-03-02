package com.jyb.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.CityMapper;
import com.jyb.pojo.City;
import com.jyb.pojo.Invitation;
import com.jyb.service.CityService;
import com.jyb.service.InvitationService;
@Transactional
@Service
public class InvitationServiceImpl implements InvitationService{

	@Override
	public void add(Invitation t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Invitation> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Invitation getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Invitation t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
}
