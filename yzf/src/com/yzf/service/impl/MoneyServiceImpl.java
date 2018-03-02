package com.yzf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yzf.pojo.YZFMoney;
import com.yzf.repsotory.MoneyRepsotory;
import com.yzf.service.MoneyService;
@Transactional
@Service
public class MoneyServiceImpl implements MoneyService {
	@Resource
	private MoneyRepsotory moneyRepsotory;
	
	public void save(YZFMoney yZFMoney) {
		moneyRepsotory.save(yZFMoney);
	}
	public YZFMoney getByid(Integer id) {
		return moneyRepsotory.findOne(id);
	}
}
