package com.jyb.req;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrderReq implements Serializable{
	//合作方需要传递的参数  下单
	/**
	 * uid 合作人
	 * pass 密码
	 * 
	 * uname 合作方在易支付的虚拟账户
	 * money 合作方需要投标的金额
	 * djnumber 投标的标在易支付的冻结号
	 * */
	private String uid;
	private String pass;
	
	private String uname;
	private double money;
	private String djnumber;
	public OrderReq() {
		super();
	}
	public OrderReq(String uid, String pass, String uname, double money, String djnumber) {
		super();
		this.uid = uid;
		this.pass = pass;
		this.uname = uname;
		this.money = money;
		this.djnumber = djnumber;
	}
	@Override
	public String toString() {
		return "OrderReq [uid=" + uid + ", pass=" + pass + ", uname=" + uname + ", money=" + money + ", djnumber="
				+ djnumber + "]";
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
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getDjnumber() {
		return djnumber;
	}
	public void setDjnumber(String djnumber) {
		this.djnumber = djnumber;
	}
}
