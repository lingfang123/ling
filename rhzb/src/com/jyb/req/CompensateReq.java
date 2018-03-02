package com.jyb.req;

public class CompensateReq {
	/**
	 * 合作方垫付下单  如：红包、优惠券 等  各种抵扣 由合作方垫付
	 * 请求易支付需要的数据
	 * uid 合作人
	 * pass 密码
	 * 
	 * money 金额
	 * djnumber 冻结号
	 * */
	private String uid;
	private String pass;
	
	private double money;
	private String djnumber;
	public CompensateReq() {
		super();
	}
	public CompensateReq(String uid, String pass, double money, String djnumber) {
		super();
		this.uid = uid;
		this.pass = pass;
		this.money = money;
		this.djnumber = djnumber;
	}
	@Override
	public String toString() {
		return "CompensateReq [uid=" + uid + ", pass=" + pass + ", money=" + money + ", djnumber=" + djnumber + "]";
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
