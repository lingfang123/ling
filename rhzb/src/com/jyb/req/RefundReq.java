package com.jyb.req;

public class RefundReq {
	//合作方流标 退钱
	/**
	 * uid 合作人
	 * pass 密码
	 * 
	 * djnumber 筹集流水号
	 * */
	//合作方用户名密码
	private String uid;
	private String pass;
	//筹款单号
	private String djnumber;
	public RefundReq() {
		super();
	}
	public RefundReq(String uid, String pass, String djnumber) {
		super();
		this.uid = uid;
		this.pass = pass;
		this.djnumber = djnumber;
	}
	@Override
	public String toString() {
		return "RefundReq [uid=" + uid + ", pass=" + pass + ", djnumber=" + djnumber + "]";
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
	public String getDjnumber() {
		return djnumber;
	}
	public void setDjnumber(String djnumber) {
		this.djnumber = djnumber;
	}
}
