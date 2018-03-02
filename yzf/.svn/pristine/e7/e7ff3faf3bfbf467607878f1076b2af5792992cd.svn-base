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
@Table(name="t_recharge_detail")
@Entity
public class RechargeDetail implements Serializable{
	private Integer id;
	private Integer userid;
	private String type;
	private String bankno;
	private double money;
	private String paynumber;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date time;
	public RechargeDetail() {
		super();
	}
	public RechargeDetail(Integer id, Integer userid, String type, String bankno, double money, String paynumber,
			Date time) {
		super();
		this.id = id;
		this.userid = userid;
		this.type = type;
		this.bankno = bankno;
		this.money = money;
		this.paynumber = paynumber;
		this.time = time;
	}
	@Override
	public String toString() {
		return "RechargeDetail [id=" + id + ", userid=" + userid + ", type=" + type + ", bankno=" + bankno + ", money="
				+ money + ", paynumber=" + paynumber + ", time=" + time + "]";
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
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getPaynumber() {
		return paynumber;
	}
	public void setPaynumber(String paynumber) {
		this.paynumber = paynumber;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
