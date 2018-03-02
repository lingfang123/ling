package com.jyb.req;

public class IncomeReq {
	/**
	 * 合作方资金增加
	 * uid 合作人
	 * pass 密码
	 * 
	 * money 金额
	 * uname 用户在易支付的虚拟账户
	 * */
	private String uidl;
	private String pass;
	private double money;
	private String uname;
	public IncomeReq() {
		super();
	}
	public IncomeReq(String uidl, String pass, double money, String uname) {
		super();
		this.uidl = uidl;
		this.pass = pass;
		this.money = money;
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "IncomeReq [uidl=" + uidl + ", pass=" + pass + ", money=" + money + ", uname=" + uname + "]";
	}
	public String getUidl() {
		return uidl;
	}
	public void setUidl(String uidl) {
		this.uidl = uidl;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
}
