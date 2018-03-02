package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class Manage implements Serializable{
	//运营信息t_manage
	private static final long serialVersionUID = 1L;
	@TableId("m_id")
	private Integer mid;//主键
	@TableField("m_TransactionAmount")
	private float mTransactionAmount;//累计交易金额
	@TableField("m_sumTransactionNum")
	private Integer msumTransactionNum;//累计交易总笔数
	@TableField("m_yesterdayAmount")
	private float myesterdayAmount;//昨日累计总额
	@TableField("m_borrowMoney")
	private Integer mborrowMoney;//累计借款人数
	@TableField("m_borrowLoan")
	private Integer mborrowLoan;//累计借出人数
	@TableField("m_debitAndCredit")
	private float mdebitAndCredit;//累计借贷总额
	@TableField("m_updateTime")
	private String mupdateTime;//更新时间
	@Override
	public String toString() {
		return "Manage [mid=" + mid + ", mTransactionAmount=" + mTransactionAmount + ", msumTransactionNum="
				+ msumTransactionNum + ", myesterdayAmount=" + myesterdayAmount + ", mborrowMoney=" + mborrowMoney
				+ ", mborrowLoan=" + mborrowLoan + ", mdebitAndCredit=" + mdebitAndCredit + ", mupdateTime="
				+ mupdateTime + "]";
	}
	public Manage() {}
	public Manage(Integer mid, float mTransactionAmount, Integer msumTransactionNum, float myesterdayAmount,
			Integer mborrowMoney, Integer mborrowLoan, float mdebitAndCredit, String mupdateTime) {
		this.mid = mid;
		this.mTransactionAmount = mTransactionAmount;
		this.msumTransactionNum = msumTransactionNum;
		this.myesterdayAmount = myesterdayAmount;
		this.mborrowMoney = mborrowMoney;
		this.mborrowLoan = mborrowLoan;
		this.mdebitAndCredit = mdebitAndCredit;
		this.mupdateTime = mupdateTime;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public float getmTransactionAmount() {
		return mTransactionAmount;
	}
	public void setmTransactionAmount(float mTransactionAmount) {
		this.mTransactionAmount = mTransactionAmount;
	}
	public Integer getMsumTransactionNum() {
		return msumTransactionNum;
	}
	public void setMsumTransactionNum(Integer msumTransactionNum) {
		this.msumTransactionNum = msumTransactionNum;
	}
	public float getMyesterdayAmount() {
		return myesterdayAmount;
	}
	public void setMyesterdayAmount(float myesterdayAmount) {
		this.myesterdayAmount = myesterdayAmount;
	}
	public Integer getMborrowMoney() {
		return mborrowMoney;
	}
	public void setMborrowMoney(Integer mborrowMoney) {
		this.mborrowMoney = mborrowMoney;
	}
	public Integer getMborrowLoan() {
		return mborrowLoan;
	}
	public void setMborrowLoan(Integer mborrowLoan) {
		this.mborrowLoan = mborrowLoan;
	}
	public float getMdebitAndCredit() {
		return mdebitAndCredit;
	}
	public void setMdebitAndCredit(float mdebitAndCredit) {
		this.mdebitAndCredit = mdebitAndCredit;
	}
	public String getMupdateTime() {
		return mupdateTime;
	}
	public void setMupdateTime(String mupdateTime) {
		this.mupdateTime = mupdateTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
