package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.ProvinceMapper;
import com.jyb.pojo.Province;
import com.jyb.service.ProvinceService;
@Transactional
@Service
public class ProvinceServiceImpl implements ProvinceService{
	@Resource
	private ProvinceMapper provinceMapper;
	
	public void add(Province t) {
		provinceMapper.add(t);
	}
	public List<Province> list() {
		return provinceMapper.list();
	}
	public Province getById(Integer id) {
		return provinceMapper.getById(id);
	}
	public void update(Province t) {
		provinceMapper.update(t);
	}
	public void delete(Integer id) {
		provinceMapper.delete(id);
	}

}
