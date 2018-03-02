package com.jyb.mapper;

import java.util.List;
import java.util.Map;

import com.jyb.base.BaseDao;
import com.jyb.pojo.NewCompany;

public interface NewCompanyMapper extends BaseDao<Integer, NewCompany>{
	List<NewCompany> listNewInfo(Integer type);
	//分页
	List<NewCompany> listAll(Map<String, Object> map);
	//查询总页数
	Integer getTotal();
}
