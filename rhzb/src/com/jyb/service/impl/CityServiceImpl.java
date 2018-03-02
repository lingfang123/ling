package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.CityMapper;
import com.jyb.pojo.City;
import com.jyb.service.CityService;
@Transactional
@Service
public class CityServiceImpl implements CityService{
	@Resource
	private CityMapper cityMapper;
	//插入
	@Override
	public void add(City c) {
		cityMapper.add(c);
	}
	//查询所有
	@Override
	public List<City> list() {
		return null;
	}
	//根据id查询
	@Override
	public City getById(Integer id) {
		return null;
	}
	//修改
	@Override
	public void update(City t) {
		
	}
	//删除
	@Override
	public void delete(Integer id) {
		
	}

}
