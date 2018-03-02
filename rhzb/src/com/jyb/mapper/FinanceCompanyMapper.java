package com.jyb.mapper;

import com.jyb.base.BaseDao;
import com.jyb.pojo.FinanceCompany;

public interface FinanceCompanyMapper extends BaseDao<Integer, FinanceCompany>{
	void reduceFinanceCompanyMoney(FinanceCompany financeCompany);
}
