package com.jyb.service;

import java.util.List;

import com.jyb.base.BaseService;
import com.jyb.pojo.NewCompany;
import com.jyb.util.PageBean;

public interface NewCompanyService extends BaseService<Integer, NewCompany>{
	List<NewCompany> listNewInfo(Integer type);
	//分页
	PageBean<NewCompany> listAll(Integer currentPage);
	//查询总页数
	Integer getTotal();
}
