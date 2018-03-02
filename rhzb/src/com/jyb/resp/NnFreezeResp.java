package com.jyb.resp;

public class NnFreezeResp {
	/**
	 * 易支付响应给合作平台的数据---解冻
	 * code 状态码
	 * context 响应内容
	 * 
	 * money 解冻金额
	 * custid 客户号
	 * */
	private Integer code;
	private String context;
	private double money;
	private Integer custid;
	public NnFreezeResp() {
		super();
	}
	public NnFreezeResp(Integer code, String context, double money, Integer custid) {
		super();
		this.code = code;
		this.context = context;
		this.money = money;
		this.custid = custid;
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
