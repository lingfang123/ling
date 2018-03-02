package com.jyb.req;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserRegisterReq implements Serializable{
	/**
	 * 开户
	 * 接入易支付命令
	 * uname 合作公司用户名
	 * pwd 合作密码
	 * 开户数据
	 * name 真实姓名
	 * cardNo 身份证号
	 * phone 手机号码
	 * paypass 交易密码
	 * */
	private String uid;//商户
	private String pass;//密码
	private String name;//真实姓名
	private String cardNo;//身份证号
	private String phone;//手机号码
	private String paypass;//交易密码
	public UserRegisterReq() {
		super();
	}
	public UserRegisterReq(String uid, String pass, String name, String cardNo, String phone, String paypass) {
		super();
		this.uid = uid;
		this.pass = pass;
		this.name = name;
		this.cardNo = cardNo;
		this.phone = phone;
		this.paypass = paypass;
	}
	@Override
	public String toString() {
		return "UserRegisterReq [uid=" + uid + ", pass=" + pass + ", name=" + name + ", cardNo=" + cardNo + ", phone="
				+ phone + ", paypass=" + paypass + "]";
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPaypass() {
		return paypass;
	}
	public void setPaypass(String paypass) {
		this.paypass = paypass;
	}
}
