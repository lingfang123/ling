package com.yzf.req;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RechargeDetailReq implements Serializable{
	/**
	 * 合作方用户充值需要返回的数据
	 * uid 合作人
	 * pass 密码
	 * 
	 * username 合作方用户在易支付虚拟账户
	 * bankno 银行卡
	 * money 充值金额
	 * pws 交易密码
	 * */
	private String uid;//商户
	private String pass;//密码
	
	
	private String username;
	private String bankno;
	private double money;
	private String pws;
	public RechargeDetailReq() {
		super();
	}
	public RechargeDetailReq(String uid, String pass, String username, String bankno, double money, String pws) {
		super();
		this.uid = uid;
		this.pass = pass;
		this.username = username;
		this.bankno = bankno;
		this.money = money;
		this.pws = pws;
	}
	@Override
	public String toString() {
		return "RechargeDetailReq [uid=" + uid + ", pass=" + pass + ", username=" + username + ", bankno=" + bankno
				+ ", money=" + money + ", pws=" + pws + "]";
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBankno() {
		return bankno;
	}
	public void setBankno(String bankno) {
		this.bankno = bankno;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getPws() {
		return pws;
	}
	public void setPws(String pws) {
		this.pws = pws;
	}
}
