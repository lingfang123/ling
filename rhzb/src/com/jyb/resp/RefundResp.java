package com.jyb.resp;

public class RefundResp {
	/**
	 * 流标退还
	 * 易支付返回给合作方的数据
	 * 
	 * code 状态码
	 * context 响应内容
	 * 
	 * djnumber 冻结编号
	 * custid 客户号
	 * */
	private Integer code;
	private String context;
	private String djnumber;
	private Integer custid;
	public RefundResp() {
		super();
	}
	public RefundResp(Integer code, String context, String djnumber, Integer custid) {
		super();
		this.code = code;
		this.context = context;
		this.djnumber = djnumber;
		this.custid = custid;
	}
	@Override
	public String toString() {
		return "RefundResp [code=" + code + ", context=" + context + ", djnumber=" + djnumber + ", custid=" + custid
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
	public String getDjnumber() {
		return djnumber;
	}
	public void setDjnumber(String djnumber) {
		this.djnumber = djnumber;
	}
	public Integer getCustid() {
		return custid;
	}
	public void setCustid(Integer custid) {
		this.custid = custid;
	}
}
