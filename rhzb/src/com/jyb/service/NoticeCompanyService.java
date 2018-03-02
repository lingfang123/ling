package com.jyb.service;

import java.util.List;

import com.jyb.base.BaseService;
import com.jyb.pojo.NoticeCompany;
import com.jyb.util.PageBean;

public interface NoticeCompanyService extends BaseService<Integer, NoticeCompany>{
	List<NoticeCompany> noticeCompanyList(Integer type);
	//分页
	PageBean<NoticeCompany> listAll(Integer currentPage);
	//查询总页数
	Integer getTotal();
}
