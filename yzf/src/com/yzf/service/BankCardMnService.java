package com.yzf.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yzf.pojo.BankCardMn;

public interface BankCardMnService {
	List<BankCardMn> bankCardMnFindAll();
	public Page<BankCardMn> getPage(Integer pageNo,Integer pageSize);
	BankCardMn getBankCardMn(BankCardMn bankCardMn);
	BankCardMn getByBankcardno(String bankcardno);
	void save(BankCardMn bankCardMn);
}
