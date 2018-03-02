package com.jyb.req;

public class NnFreezeReq {
	/**
	 * 解冻筹集金额---合作方需要传递的参数
	 * uid 合作人
	 * pass 密码
	 * 
	 * djnumber 冻结编号
	 * uname 合作方在易支付的账户
	 * */
	private String uid;
	private String pass;
	private String djnumber;
	private String uname;
	public NnFreezeReq() {
		super();
	}
	public NnFreezeReq(String uid, String pass, String djnumber, String uname) {
		super();
		this.uid = uid;
		this.pass = pass;
		this.djnumber = djnumber;
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "NnFreezeReq [uid=" + uid + ", pass=" + pass + ", djnumber=" + djnumber + ", uname=" + uname + "]";
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
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
}
