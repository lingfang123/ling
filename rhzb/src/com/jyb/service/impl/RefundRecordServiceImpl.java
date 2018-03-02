package com.jyb.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.RefundRecordMapper;
import com.jyb.pojo.RefundRecord;
import com.jyb.service.RefundRecordService;
import com.jyb.util.PageBean;
@Transactional
@Service
public class RefundRecordServiceImpl implements RefundRecordService{
	@Resource
	private RefundRecordMapper refundRecordMapper;
	public void add(RefundRecord t) {
		refundRecordMapper.add(t);
	}
	public List<RefundRecord> list() {
		return refundRecordMapper.list();
	}
	public RefundRecord getById(Integer id) {
		return refundRecordMapper.getById(id);
	}
	public void update(RefundRecord t) {
		refundRecordMapper.update(t);
	}
	public void delete(Integer id) {
		refundRecordMapper.delete(id);
	}
	public Integer getTotal(Integer tmarkid) {
		return refundRecordMapper.getTotal(tmarkid);
	}
	public PageBean<RefundRecord> refundRecordPage(Integer tmarkid, Integer currentPage) {
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<RefundRecord> pageBean = new PageBean<RefundRecord>();
        
        Integer pageSize = 3;
        pageBean.setCurrPage(currentPage);
        pageBean.setPageSize(pageSize);
        //查询总条数
        int totalCount = refundRecordMapper.getTotal(tmarkid);
        pageBean.setTotalCount(totalCount);
        //查询总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        //设置从第几页开始，每页显示多少条数据
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("tmarkid", tmarkid);
        List<RefundRecord> lists = refundRecordMapper.refundRecordPage(map);
        pageBean.setLists(lists);
        /**
         * select * from user u
         * limit #{start},#{size}
         * */
        return pageBean;
	}
	public List<RefundRecord> getByUserId(Integer userid) {
		return refundRecordMapper.getByUserId(userid);
	}
	public Date xqRefundtime(Integer tmarkid) {
		return refundRecordMapper.xqRefundtime(tmarkid);
	}

	public double bxSumMoney(Integer tmarkid) {
		return refundRecordMapper.bxSumMoney(tmarkid);
	}
	@Override
	public List<RefundRecord> getByTmarkid(Integer userid) {
		// TODO Auto-generated method stub
		return refundRecordMapper.getByTmarkid(userid);
	}
	@Override
	public Integer getmaxmarkid(Integer tmarkid) {
		return refundRecordMapper.getmaxmarkid(tmarkid);
	}

	public double sumPrincipal(Integer struts) {
		return refundRecordMapper.sumPrincipal(struts);
	}

}
