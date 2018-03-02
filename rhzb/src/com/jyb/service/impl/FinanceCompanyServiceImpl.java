package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.FinanceCompanyMapper;
import com.jyb.pojo.FinanceCompany;
import com.jyb.service.FinanceCompanyService;
@Transactional
@Service
public class FinanceCompanyServiceImpl implements FinanceCompanyService{
	@Resource
	private FinanceCompanyMapper financeCompanyMapper;
	
	public void add(FinanceCompany t) {
		financeCompanyMapper.add(t);
	}
	public List<FinanceCompany> list() {
		return financeCompanyMapper.list();
	}
	public FinanceCompany getById(Integer id) {
		return financeCompanyMapper.getById(id);
	}
	public void update(FinanceCompany t) {
		financeCompanyMapper.update(t);
	}
	public void delete(Integer id) {
		financeCompanyMapper.delete(id);
	}
	public void reduceFinanceCompanyMoney(FinanceCompany financeCompany) {
		financeCompanyMapper.reduceFinanceCompanyMoney(financeCompany);
	}
}
