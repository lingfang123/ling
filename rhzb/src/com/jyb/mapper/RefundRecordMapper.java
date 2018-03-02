package com.jyb.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jyb.base.BaseDao;
import com.jyb.pojo.RefundRecord;

public interface RefundRecordMapper extends BaseDao<Integer, RefundRecord>{
	//查询单个标的还款记录数
	Integer getTotal(Integer tmarkid);
	//分页查询
	List<RefundRecord> refundRecordPage(Map<String, Object> map);
	double bxSumMoney(Integer tmarkid);
	List<RefundRecord> getByUserId(Integer userid);
	Date xqRefundtime(Integer tmarkid);
	
	//根据发标表id获取还款表的利息
	List<RefundRecord> getByTmarkid(Integer tmarkid);
	
	Integer getmaxmarkid(Integer tmarkid);
	//平台已还本息
	double sumPrincipal(Integer struts);
}