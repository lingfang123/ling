package com.jyb.service;

import java.util.List;

import com.jyb.base.BaseService;
import com.jyb.pojo.Redenvelopes;

public interface RedenvelopesService extends BaseService<Integer, Redenvelopes>{
	List<Redenvelopes> findList(Integer userid,Integer struts);
	//根据用户ID查找（userid）
	List<Redenvelopes> getByUserid(Integer userid);
}
