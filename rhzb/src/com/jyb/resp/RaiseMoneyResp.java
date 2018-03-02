package com.jyb.resp;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RaiseMoneyResp implements Serializable{
	/**
	 * 易支付筹集资金返回给合作方
	 * @param code 应答码
	 * @param context 返回内容
	 * 
	 * @param cjmoney 筹集金额
	 * @param cjnumber 筹集号
	 * @param custid 客户号
	 * */
	private Integer code;
	private String context;
	
	private double cjmoney;
	private String cjnumber;
	private Integer custid;
	public RaiseMoneyResp() {
		super();
	}
	public RaiseMoneyResp(Integer code, String context, double cjmoney, String cjnumber, Integer custid) {
		super();
		this.code = code;
		this.context = context;
		this.cjmoney = cjmoney;
		this.cjnumber = cjnumber;
		this.custid = custid;
	}
	@Override
	public String toString() {
		return "RaiseMoneyResp [code=" + code + ", context=" + context + ", cjmoney=" + cjmoney + ", cjnumber="
				+ cjnumber + ", custid=" + custid + "]";
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
	public double getCjmoney() {
		return cjmoney;
	}
	public void setCjmoney(double cjmoney) {
		this.cjmoney = cjmoney;
	}
	public String getCjnumber() {
		return cjnumber;
	}
	public void setCjnumber(String cjnumber) {
		this.cjnumber = cjnumber;
	}
	public Integer getCustid() {
		return custid;
	}
	public void setCustid(Integer custid) {
		this.custid = custid;
	}
}
