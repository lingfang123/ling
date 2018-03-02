package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.LawMapper;
import com.jyb.pojo.Law;
import com.jyb.service.LawService;
@Transactional
@Service
public class LawServiceImpl implements LawService{

	@Resource
	private LawMapper lawMapper;
	@Override
	public void add(Law t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Law> list() {
		return lawMapper.list();
	}

	@Override
	public Law getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Law t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Law> listLaw(Integer style) {
		// TODO Auto-generated method stub
		return lawMapper.listLaw(style);
	}

}
