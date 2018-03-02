package com.jyb.mapper;

import java.util.List;

import com.jyb.base.BaseDao;
import com.jyb.pojo.Mark;

public interface MarkMapper extends BaseDao<Integer, Mark>{
	List<Mark> markList();
}
