package com.yzf.resp;

public class BindingBankCardResp {
	/**
	 * 易支付响应给合作平台的数据
	 * code 状态码
	 * context 响应内容
	 * bankcardno 银行卡号
	 * custid 客户号
	 * */
	private Integer code;
	private String context;
	private String bankcardno;
	private Integer custid;
	public BindingBankCardResp() {
		super();
	}
	public BindingBankCardResp(Integer code, String context, String bankcardno, Integer custid) {
		super();
		this.code = code;
		this.context = context;
		this.bankcardno = bankcardno;
		this.custid = custid;
	}
	@Override
	public String toString() {
		return "BindingBankCardResp [code=" + code + ", context=" + context + ", bankcardno=" + bankcardno + ", custid="
				+ custid + "]";
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
	public String getBankcardno() {
		return bankcardno;
	}
	public void setBankcardno(String bankcardno) {
		this.bankcardno = bankcardno;
	}
	public Integer getCustid() {
		return custid;
	}
	public void setCustid(Integer custid) {
		this.custid = custid;
	}
}
