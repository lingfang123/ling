package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.PconMapper;
import com.jyb.pojo.City;
import com.jyb.pojo.District;
import com.jyb.pojo.Province;
import com.jyb.service.PconService;

@Transactional
@Service
public class PconServiceImpl implements PconService{
	@Resource
	private PconMapper pconMapper;

	@Override
	public List<Province> provinceList() {
		// TODO Auto-generated method stub
		return pconMapper.provinceList();
	}


	@Override
	public List<City> cityList(Integer pid) {
		// TODO Auto-generated method stub
		return pconMapper.cityList(pid);
	}


	@Override
	public List<District> districtList(Integer cid) {
		// TODO Auto-generated method stub
		return pconMapper.districtList(cid);
	}


	@Override
	public Province selProByid(Integer pid) {
		// TODO Auto-generated method stub
		return pconMapper.selProByid(pid);
	}


	@Override
	public City selCityByid(Integer cid) {
		// TODO Auto-generated method stub
		return pconMapper.selCityByid(cid);
	}


	@Override
	public District selDisByid(Integer did) {
		// TODO Auto-generated method stub
		return pconMapper.selDisByid(did);
	}

	
}
