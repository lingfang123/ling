package com.jyb.service;

import java.util.List;

import com.jyb.base.BaseService;
import com.jyb.pojo.MarkInfo;
import com.jyb.util.PageBean;

public interface MarkInfoService extends BaseService<Integer, MarkInfo>{
	//根据markid查询List
	List<MarkInfo> listByMarkid(Integer markid);
	//查询平台已筹金额
	double sumMoney();
	//分页
	PageBean<MarkInfo> listAll(Integer currentPage);
	//查询总页数
	Integer getTotal();
	//查询各种标总页数
	Integer getTotalBymark(Integer markid);
	//单种标分页
	PageBean<MarkInfo> pageByMark(Integer markid,Integer currentPage);
}
