package com.jyb.service;

import java.util.List;

import com.jyb.base.BaseService;
import com.jyb.pojo.Detail;
import com.jyb.util.PageBean;
import com.jyb.util.PageInfoUtil;

public interface DetailService extends BaseService<Integer, Detail>{
	//查询总页数
	Integer getTotal();
	//分页
	void selectPage(PageInfoUtil pageInfoUtil,Detail detail);
	PageBean<Detail> findAll(Integer currentPage,Integer userid);
	/*List<Detail> selectPage(Pagination page, Map<String, Object> map);
	List<Detail> findAll(Map<String, Object> map);*/
	//根据userid查询
	List<Detail> getListByUserid(Integer userid);
}
