package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.HelpCenterMapper;
import com.jyb.pojo.HelpCenter;
import com.jyb.service.HelpCenterService;
@Transactional
@Service
public class HelpCenterServiceImpl implements HelpCenterService{

	@Resource
	private HelpCenterMapper helpCenterMapper;
	@Override
	public void add(HelpCenter t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HelpCenter> list() {
		return helpCenterMapper.list();
	}

	@Override
	public HelpCenter getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(HelpCenter t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
