package com.jyb.mapper;

import java.util.List;
import java.util.Map;

import com.jyb.base.BaseDao;
import com.jyb.pojo.Invest;

public interface InvestMapper extends BaseDao<Integer, Invest>{
	//按status查询个人总记录数
	Integer getTotal(Integer userid,Integer status);
	//根据userid、状态（status）查询list（包括分页）
	List<Invest> listByUseridWithStatus(Map<String, Object> map);
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
	List<Invest> listByTmarkid(Map<String, Object> map);
	//按tmarkid查询总记录数
	Integer getTotalBytmarkid(Integer tmarkid);

	List<Invest> getBytmakid(Integer tmkid);
	
	Integer getmaney(Integer makid);
	List<Invest> getByInvestTmarkid(Integer tmarkid);
	//导出
	List<Invest> investPoi(Integer userid);
	//根据userid查询
	List<Invest> getByUserid(Integer userid);

}
