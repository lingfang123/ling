package com.jyb.resp;

public class CompensateResp {
	/**
	 * 合作方垫付下单  如：红包、优惠券 等  各种抵扣 由合作方垫付
	 * 响应合作方需要的数据
	 * code 状态码
	 * context 响应内容
	 * money 金额
	 * custid 客户号
	 * */
	private Integer code;
	private String context;
	private double money;
	private Integer custid;
	public CompensateResp() {
		super();
	}
	public CompensateResp(Integer code, String context, double money, Integer custid) {
		super();
		this.code = code;
		this.context = context;
		this.money = money;
		this.custid = custid;
	}
	@Override
	public String toString() {
		return "CompensateResp [code=" + code + ", context=" + context + ", money=" + money + ", custid=" + custid
				+ "]";
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
