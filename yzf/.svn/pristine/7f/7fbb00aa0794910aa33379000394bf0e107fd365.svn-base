package com.yzf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yzf.pojo.RechargeDetail;
import com.yzf.repsotory.RechargeDetailRepsotory;
import com.yzf.service.RechargeDetailService;
@Transactional
@Service
public class RechargeDetailServiceImpl implements RechargeDetailService{
	@Resource
	private RechargeDetailRepsotory rechargeDetailRepsotory;
	public void addRecharge(RechargeDetail rechargeDetail) {
		rechargeDetailRepsotory.save(rechargeDetail);
	}
}
