package com.jyb.resp;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RechargeDetailResp implements Serializable{
	/**
	 * 充值
	 * 易支付响应给合作方的数据
	 * @param code 应答码
	 * @param context 返回内容
	 * 
	 * @param money 到账金额
	 * @param lsnumber 流水号
	 * @param custid 客户号
	 * */
	private Integer code;
	private String context;
	
	private double money;
	private String lsnumber;
	private Integer custid;
	public RechargeDetailResp() {
		super();
	}
	public RechargeDetailResp(Integer code, String context, double money, String lsnumber, Integer custid) {
		super();
		this.code = code;
		this.context = context;
		this.money = money;
		this.lsnumber = lsnumber;
		this.custid = custid;
	}
	@Override
	public String toString() {
		return "RechargeDetailResp [code=" + code + ", context=" + context + ", money=" + money + ", lsnumber="
				+ lsnumber + ", custid=" + custid + "]";
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
	public String getLsnumber() {
		return lsnumber;
	}
	public void setLsnumber(String lsnumber) {
		this.lsnumber = lsnumber;
	}
	public Integer getCustid() {
		return custid;
	}
	public void setCustid(Integer custid) {
		this.custid = custid;
	}
}
