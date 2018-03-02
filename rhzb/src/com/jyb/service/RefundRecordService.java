package com.jyb.service;

import java.util.Date;
import java.util.List;

import com.jyb.base.BaseService;
import com.jyb.pojo.RefundRecord;
import com.jyb.util.PageBean;

public interface RefundRecordService extends BaseService<Integer, RefundRecord>{
	//查询单个标的还款记录数
	Integer getTotal(Integer tmarkid);
	//分页查询
	PageBean<RefundRecord> refundRecordPage(Integer tmarkid,Integer currentPage);
	double bxSumMoney(Integer tmarkid);
	List<RefundRecord> getByUserId(Integer userid);
	Date xqRefundtime(Integer tmarkid);
	
	//根据发标表id获取还款表的利息
	List<RefundRecord> getByTmarkid(Integer userid);
	Integer getmaxmarkid(Integer tmarkid);
	//平台已还本息
	double sumPrincipal(Integer struts);
}
