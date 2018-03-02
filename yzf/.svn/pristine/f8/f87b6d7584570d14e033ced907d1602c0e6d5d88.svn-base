package com.yzf.resp;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserRegisterResp implements Serializable{
	/**
	 * 开户响应
	 * 返回给合作方的数据
	 * code 应答码
	 * context 返回内容
	 * uname 用户开通的虚拟账户
	 * custid 客户号
	 * */
	private Integer code;//应答码
	private String context;//返回内容更
	private String uname;//用户在易支付的虚拟账号
	private Integer custid;//客户号
	public UserRegisterResp() {
		super();
	}
	public UserRegisterResp(Integer code, String context, String uname, Integer custid) {
		super();
		this.code = code;
		this.context = context;
		this.uname = uname;
		this.custid = custid;
	}
	@Override
	public String toString() {
		return "UserRegisterResp [code=" + code + ", context=" + context + ", uname=" + uname + ", custid=" + custid
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
}
