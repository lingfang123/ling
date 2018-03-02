package com.yzf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yzf.pojo.YZFMoneyMx;
import com.yzf.repsotory.MoneyMxRepsotory;
import com.yzf.service.MoneyMxService;
@Transactional
@Service
public class MoneyMxServiceImpl implements MoneyMxService {
	@Resource
	private MoneyMxRepsotory moneyMxRepsotory;

	public void save(YZFMoneyMx yZFMoneyMx) {
		moneyMxRepsotory.save(yZFMoneyMx);
	}
}
