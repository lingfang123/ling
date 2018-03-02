package com.jyb.mapper;

import java.util.List;

import com.jyb.base.BaseDao;
import com.jyb.pojo.Law;

public interface LawMapper extends BaseDao<Integer,Law>{
	List<Law> listLaw(Integer style);
}
