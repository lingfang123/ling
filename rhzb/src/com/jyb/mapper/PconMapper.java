package com.jyb.mapper;


import java.util.List;

import com.jyb.pojo.City;
import com.jyb.pojo.District;
import com.jyb.pojo.Province;

public interface PconMapper {
	List<Province> provinceList();
	List<City> cityList(Integer pid);
	List<District> districtList(Integer cid);
	
	Province selProByid(Integer pid);
	City selCityByid(Integer cid);
	District selDisByid(Integer did);
}

 