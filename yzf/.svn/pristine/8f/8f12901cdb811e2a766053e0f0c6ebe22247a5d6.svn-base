package com.yzf.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@SuppressWarnings("serial")
@Cacheable
@Table(name="t_withdraw_deposit")
@Entity
public class WithdrawDeposit implements Serializable{
	private Integer id;
	private Integer userid;
	private Integer paynumber;
	private float txmoney;
	private Date txtime;
	private String type;
	private String bankno;
	private float sxmoney;
	private Integer struts;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date dztime;
	private float dzmoney;
	public WithdrawDeposit() {
		super();
	}
	public WithdrawDeposit(Integer id, Integer userid, Integer paynumber, float txmoney, Date txtime, String type,
			String bankno, float sxmoney, Integer struts, Date dztime, float dzmoney) {
		super();
		this.id = id;
		this.userid = userid;
		this.paynumber = paynumber;
		this.txmoney = txmoney;
		this.txtime = txtime;
		this.type = type;
		this.bankno = bankno;
		this.sxmoney = sxmoney;
		this.struts = struts;
		this.dztime = dztime;
		this.dzmoney = dzmoney;
	}
	@Override
	public String toString() {
		return "WithdrawDeposit [id=" + id + ", userid=" + userid + ", paynumber=" + paynumber + ", txmoney=" + txmoney
				+ ", txtime=" + txtime + ", type=" + type + ", bankno=" + bankno + ", sxmoney=" + sxmoney + ", struts="
				+ struts + ", dztime=" + dztime + ", dzmoney=" + dzmoney + "]";
	}
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getPaynumber() {
		return paynumber;
	}
	public void setPaynumber(Integer paynumber) {
		this.paynumber = paynumber;
	}
	public float getTxmoney() {
		return txmoney;
	}
	public void setTxmoney(float txmoney) {
		this.txmoney = txmoney;
	}
	public Date getTxtime() {
		return txtime;
	}
	public void setTxtime(Date txtime) {
		this.txtime = txtime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBankno() {
		return bankno;
	}
	public void setBankno(String bankno) {
		this.bankno = bankno;
	}
	public float getSxmoney() {
		return sxmoney;
	}
	public void setSxmoney(float sxmoney) {
		this.sxmoney = sxmoney;
	}
	public Integer getStruts() {
		return struts;
	}
	public void setStruts(Integer struts) {
		this.struts = struts;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDztime() {
		return dztime;
	}
	public void setDztime(Date dztime) {
		this.dztime = dztime;
	}
	public float getDzmoney() {
		return dzmoney;
	}
	public void setDzmoney(float dzmoney) {
		this.dzmoney = dzmoney;
	}
}
