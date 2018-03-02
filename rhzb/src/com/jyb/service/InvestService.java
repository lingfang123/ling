package com.jyb.service;

import java.util.List;

import com.jyb.base.BaseService;
import com.jyb.pojo.Invest;
import com.jyb.util.PageBean;

public interface InvestService extends BaseService<Integer, Invest>{
	//按status查询总记录数
	Integer getTotal(Integer userid,Integer status);
	//根据userid、状态（status）查询list
	PageBean<Invest> listByUseridWithStatus(Integer userid,Integer status,Integer currentPage);
	//查询累计投资
	double getAllCorpus(Integer userid);
	//查询累计收益
	double getAllLucre(Integer userid,Integer status);
	//查询待收本金
	double getWaitCorpus(Integer userid,Integer status);
	//查询待收收益
	double getWaitLucre(Integer userid,Integer status);
	
	// 通过时间查找注册人数
	List<Invest> getMonthBidTime(String bidtime);

	//根据标的id（tmarkid）查询投资记录
	PageBean<Invest> listByTmarkid(Integer tmarkid,Integer currentPage);
	//按tmarkid查询总记录数
	Integer getTotalBytmarkid(Integer tmarkid);
	List<Invest> getByInvestTmarkid(Integer tmarkid);
	//导出
	List<Invest> investPoi(Integer userid);
	
	List<Invest> getBytmakid(Integer tmkid);
	
	Integer getmaney(Integer makid);
	
	//根据userid查询
	List<Invest> getByUserid(Integer userid);
}
