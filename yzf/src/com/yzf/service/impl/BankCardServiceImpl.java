package com.yzf.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yzf.pojo.BankCard;
import com.yzf.repsotory.BankCardRepsotory;
import com.yzf.service.BankCardService;
@Transactional
@Service
public class BankCardServiceImpl implements BankCardService{
	@Resource
	private BankCardRepsotory bankCardRepsotory;
	public void userAddBankCard(BankCard bankCard) {
		bankCardRepsotory.save(bankCard);
	}
}
