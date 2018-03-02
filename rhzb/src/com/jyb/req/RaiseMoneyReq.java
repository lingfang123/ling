package com.jyb.req;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RaiseMoneyReq implements Serializable{
	//合作方投标需要生成筹集资金记录
	/**
	 * 判断合作方
	 * uid 合作人
	 * pass 密码
	 * 
	 * 信息
	 * username 用户在易支付绑定的存管账户
	 * cjmoney	筹集的金额
	 * djnumber 冻结编号
	 * */
	private String uid;
	private String pass;
	
	private String username;
	private double cjmoney;
	private String djnumber;
	public RaiseMoneyReq() {
		super();
	}
	public RaiseMoneyReq(String uid, String pass, String username, double cjmoney) {
		super();
		this.uid = uid;
		this.pass = pass;
		this.username = username;
		this.cjmoney = cjmoney;
	}
	@Override
	public String toString() {
		return "RaiseMoneyReq [uid=" + uid + ", pass=" + pass + ", username=" + username + ", cjmoney=" + cjmoney + "]";
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
	public double getCjmoney() {
		return cjmoney;
	}
	public void setCjmoney(double cjmoney) {
		this.cjmoney = cjmoney;
	}
	public String getDjnumber() {
		return djnumber;
	}
	public void setDjnumber(String djnumber) {
		this.djnumber = djnumber;
	}
}
