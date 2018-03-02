package com.jyb.mapper;

import java.util.List;

import com.jyb.base.BaseDao;
import com.jyb.pojo.Redenvelopes;

public interface RedenvelopesMapper extends BaseDao<Integer, Redenvelopes>{
	List<Redenvelopes> findList(Integer userid,Integer struts);
	//根据用户ID查找（userid）
	List<Redenvelopes> getByUserid(Integer userid);
}
