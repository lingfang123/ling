package com.yzf.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yzf.pojo.BankCardMn;
import com.yzf.repsotory.BankCardMnRepsotory;
import com.yzf.service.BankCardMnService;
@Transactional
@Service
public class BankCardMnServiceImpl implements BankCardMnService{
	@Resource
	private BankCardMnRepsotory bankCardMnRepsotory;
	public List<BankCardMn> bankCardMnFindAll() {
		return bankCardMnRepsotory.findAll();
	}
	public Page<BankCardMn> getPage(Integer pageNo, Integer pageSize) {
		PageRequest pageRequest = new PageRequest(pageNo, pageSize);
		return bankCardMnRepsotory.findAll(pageRequest);
	}
	public BankCardMn getBankCardMn(BankCardMn bankCardMn) {
		String phone = bankCardMn.getPhone();
		String bankcardno = bankCardMn.getBankcardno();
		String sfbankcardno = bankCardMn.getSfbankcardno();
		String name = bankCardMn.getName();
		System.out.println(phone+">>"+bankcardno);
		return bankCardMnRepsotory.findOne(bankcardno,phone,sfbankcardno,name);
	}
	public BankCardMn getByBankcardno(String bankcardno) {
		return bankCardMnRepsotory.getByBankcardno(bankcardno);
	}
	public void save(BankCardMn bankCardMn) {
		bankCardMnRepsotory.save(bankCardMn);
	}
}
