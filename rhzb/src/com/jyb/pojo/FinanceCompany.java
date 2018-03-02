package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class FinanceCompany implements Serializable{
	//公司金额t_finance_company
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//主键id
	@TableField("sumMoney")
	private double sumMoney;//余额
	@Override
	public String toString() {
		return "FinanceCompany [id=" + id + ", sumMoney=" + sumMoney + "]";
	}
	public FinanceCompany() {}
	public FinanceCompany(Integer id, double sumMoney) {
		this.id = id;
		this.sumMoney = sumMoney;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getSumMoney() {
		return sumMoney;
	}
	public void setSumMoney(double sumMoney) {
		this.sumMoney = sumMoney;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
