package com.jyb.service;

import com.jyb.base.BaseService;
import com.jyb.pojo.FinanceCompany;

public interface FinanceCompanyService extends BaseService<Integer,  FinanceCompany>{
	void reduceFinanceCompanyMoney(FinanceCompany financeCompany);
}
