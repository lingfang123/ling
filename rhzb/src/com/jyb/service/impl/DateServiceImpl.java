package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.DatesMapper;
import com.jyb.pojo.Dates;
import com.jyb.service.DateService;

@Transactional
@Service
public class DateServiceImpl implements DateService{
	@Resource
	private DatesMapper datesMapper;
	
	@Override
	public void add(Dates t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Dates> list() {
		
		return datesMapper.list();
	}

	@Override
	public Dates getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Dates t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
