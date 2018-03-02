package com.jyb.resp;

public class IncomeResp {
	/**
	 * 响应
	 * 合作方资金增加
	 * 
	 * code 状态码
	 * context 响应内容
	 * 
	 * money 金额
	 * custid 客户号
	 * */
	private Integer code;
	private String context;
	private double money;
	private Integer custid;
	public IncomeResp() {
		super();
	}
	public IncomeResp(Integer code, String context, double money, Integer custid) {
		super();
		this.code = code;
		this.context = context;
		this.money = money;
		this.custid = custid;
	}
	@Override
	public String toString() {
		return "IncomeResp [code=" + code + ", context=" + context + ", money=" + money + ", custid=" + custid + "]";
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Integer getCustid() {
		return custid;
	}
	public void setCustid(Integer custid) {
		this.custid = custid;
	}
}
