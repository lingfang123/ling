package com.jyb.req;

public class UserIncomeReq {
	/**
	 * 合作方用户收入
	 * uid 合作人
	 * pass 密码
	 * 
	 * uname 在易支付的虚拟账号
	 * money 金额
	 * */
	private String uid;
	private String pass;
	//还款人在易支付的虚拟账号
	private String uname1;
	//收款人在易支付的虚拟账号
	private String uname2;
	private double money;
	public UserIncomeReq() {
		super();
	}
	public UserIncomeReq(String uid, String pass, String uname1, String uname2, double money) {
		super();
		this.uid = uid;
		this.pass = pass;
		this.uname1 = uname1;
		this.uname2 = uname2;
		this.money = money;
	}
	@Override
	public String toString() {
		return "UserIncomeReq [uid=" + uid + ", pass=" + pass + ", uname1=" + uname1 + ", uname2=" + uname2 + ", money="
				+ money + "]";
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
	public String getUname1() {
		return uname1;
	}
	public void setUname1(String uname1) {
		this.uname1 = uname1;
	}
	public String getUname2() {
		return uname2;
	}
	public void setUname2(String uname2) {
		this.uname2 = uname2;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
}
