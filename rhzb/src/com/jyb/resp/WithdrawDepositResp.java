package com.jyb.resp;

public class WithdrawDepositResp {
	/**
	 * @version WithdrawDepositResp 易支付返回给合作方的信息
	 * @param code 应答码
	 * @param context 返回内容更
	 * 
	 * @param custid 客户号
	 * @param txmoney 提现金额
	 * @param sxmoney //提现手续费
	 * 
	 * */
	private Integer code;
	private String context;
	
	private Integer custid;
	private double txmoney;
	private double sxmoney;
	public WithdrawDepositResp() {
		super();
	}
	public WithdrawDepositResp(Integer code, String context, Integer custid, double txmoney, double sxmoney) {
		super();
		this.code = code;
		this.context = context;
		this.custid = custid;
		this.txmoney = txmoney;
		this.sxmoney = sxmoney;
	}
	@Override
	public String toString() {
		return "WithdrawDepositResp [code=" + code + ", context=" + context + ", custid=" + custid + ", txmoney="
				+ txmoney + ", sxmoney=" + sxmoney + "]";
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
	public Integer getCustid() {
		return custid;
	}
	public void setCustid(Integer custid) {
		this.custid = custid;
	}
	public double getTxmoney() {
		return txmoney;
	}
	public void setTxmoney(double txmoney) {
		this.txmoney = txmoney;
	}
	public double getSxmoney() {
		return sxmoney;
	}
	public void setSxmoney(double sxmoney) {
		this.sxmoney = sxmoney;
	}
}
