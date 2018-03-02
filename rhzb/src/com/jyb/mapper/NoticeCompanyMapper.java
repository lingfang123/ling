package com.jyb.mapper;

import java.util.List;
import java.util.Map;

import com.jyb.base.BaseDao;
import com.jyb.pojo.NoticeCompany;

public interface NoticeCompanyMapper extends BaseDao<Integer, NoticeCompany>{
	List<NoticeCompany> noticeCompanyList(Integer type);
	//分页
	List<NoticeCompany> listAll(Map<String, Object> map);
	//查询总页数
	Integer getTotal();
}
