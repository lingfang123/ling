package com.jyb.service;

import java.util.List;

import com.jyb.base.BaseService;
import com.jyb.pojo.Law;

public interface LawService extends BaseService<Integer, Law>{
	List<Law> listLaw(Integer style);
}
