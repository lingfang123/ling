package com.jyb.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jyb.base.BaseDao;
import com.jyb.pojo.Detail;

public interface DetailMapper extends BaseDao<Integer, Detail>{
	//查询总页数
	Integer getTotal(int id);
	//分页
	List<Detail> selectPage(Pagination page, Map<String, Object> map);
	List<Detail> findAll(Map<String, Object> map);
	//根据userid查询
	List<Detail> getListByUserid(Integer userid);
}
