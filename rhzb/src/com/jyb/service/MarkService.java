package com.jyb.service;

import java.util.List;

import com.jyb.base.BaseService;
import com.jyb.pojo.Mark;

public interface MarkService extends BaseService<Integer, Mark>{
	List<Mark> markList();
}
