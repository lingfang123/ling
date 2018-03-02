package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.FinanceCompanydetailMapper;
import com.jyb.pojo.FinanceCompanydetail;
import com.jyb.service.FinanceCompanydetailService;
@Transactional
@Service
public class FinanceCompanydetailServiceImpl implements FinanceCompanydetailService{
	@Resource
	private FinanceCompanydetailMapper financeCompanydetailMapper;
	
	public void add(FinanceCompanydetail t) {
		financeCompanydetailMapper.add(t);
	}
	public List<FinanceCompanydetail> list() {
		return financeCompanydetailMapper.list();
	}
	public FinanceCompanydetail getById(Integer id) {
		return financeCompanydetailMapper.getById(id);
	}
	public void update(FinanceCompanydetail t) {
		financeCompanydetailMapper.update(t);
	}
	public void delete(Integer id) {
		financeCompanydetailMapper.delete(id);
	}
}
