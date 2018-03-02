package com.jyb.mapper;

import com.jyb.base.BaseDao;
import com.jyb.pojo.UserVip;

public interface UserVipMapper extends BaseDao<Integer,UserVip>{
	//根据userid进行查询
	UserVip getByuserid(Integer userid);
}
