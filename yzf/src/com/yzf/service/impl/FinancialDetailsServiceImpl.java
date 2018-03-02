package com.yzf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yzf.pojo.FinancialDetails;
import com.yzf.repsotory.FinancialDetailsRepsotory;
import com.yzf.service.FinancialDetailsService;
@Transactional
@Service
public class FinancialDetailsServiceImpl implements FinancialDetailsService{
	@Resource
	private FinancialDetailsRepsotory financialDetailsRepsotory;
	public void save(FinancialDetails financialDetails) {
		financialDetailsRepsotory.save(financialDetails);
	}
}
