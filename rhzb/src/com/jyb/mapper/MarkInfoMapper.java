package com.jyb.mapper;

import java.util.List;
import java.util.Map;

import com.jyb.base.BaseDao;
import com.jyb.pojo.MarkInfo;

public interface MarkInfoMapper extends BaseDao<Integer, MarkInfo> {
	//根据markid查询List
	List<MarkInfo> listByMarkid(Integer markid);
	//查询平台已筹金额
	double sumMoney();
	//分页
	List<MarkInfo> listAll(Map<String, Object> map);
	//查询总页数
	Integer getTotal();
	//查询各种标总页数
	Integer getTotalBymark(Integer markid);
	//单种标分页
	List<MarkInfo> pageByMark(Map<String, Object> map);
}
