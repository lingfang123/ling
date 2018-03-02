package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.RecruitMapper;
import com.jyb.pojo.Recruit;
import com.jyb.service.RecruitService;
@Transactional
@Service
public class RecruitServiceImpl implements RecruitService{
	
	@Resource
	private RecruitMapper recruitMapper;
	@Override
	public void add(Recruit t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Recruit> list() {
		return recruitMapper.list();
	}

	@Override
	public Recruit getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Recruit t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
