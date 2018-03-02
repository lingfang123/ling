package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.RelationUsMapper;
import com.jyb.pojo.RelationUs;
import com.jyb.service.RelationUsService;
@Transactional
@Service
public class RelationUsServiceImpl implements RelationUsService{

	@Resource
	private RelationUsMapper relationUsMapper;
	@Override
	public void add(RelationUs t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RelationUs> list() {
		return relationUsMapper.list();
	}

	@Override
	public RelationUs getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(RelationUs t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
