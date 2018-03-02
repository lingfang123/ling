package com.jyb.resp;

public class OrderResp {
	/**
	 * 易支付返回给合作方的数据
	 * code 状态码
	 * context 响应内容
	 * 
	 * tbmoney 投标金额
	 * uname 返回给合作方的用户虚拟账号
	 * custid 客户号
	 * ornumber //在易支付的订单号
	 * */
	private Integer code;
	private String context;
	private double tbmoney;
	private String uname;
	private String ornumber;
	private Integer custid;
	public OrderResp() {
		super();
	}
	public OrderResp(Integer code, String context, double tbmoney, String uname, Integer custid) {
		super();
		this.code = code;
		this.context = context;
		this.tbmoney = tbmoney;
		this.uname = uname;
		this.custid = custid;
	}
	@Override
	public String toString() {
		return "OrderResp [code=" + code + ", context=" + context + ", tbmoney=" + tbmoney + ", uname=" + uname
				+ ", custid=" + custid + "]";
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
	public double getTbmoney() {
		return tbmoney;
	}
	public void setTbmoney(double tbmoney) {
		this.tbmoney = tbmoney;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getCustid() {
		return custid;
	}
	public void setCustid(Integer custid) {
		this.custid = custid;
	}
	public String getOrnumber() {
		return ornumber;
	}
	public void setOrnumber(String ornumber) {
		this.ornumber = ornumber;
	}
}
