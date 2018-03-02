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
@Table(name="t_financial_details")
@Entity
public class FinancialDetails implements Serializable{
	private Integer id;
	private Integer userid;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date createtime;
	private double money;
	private Integer struts;
	private String explain;
	public FinancialDetails() {
		super();
	}
	public FinancialDetails(Integer id, Integer userid, Date createtime, double money, Integer struts, String explain) {
		super();
		this.id = id;
		this.userid = userid;
		this.createtime = createtime;
		this.money = money;
		this.struts = struts;
		this.explain = explain;
	}
	@Override
	public String toString() {
		return "FinancialDetails [id=" + id + ", userid=" + userid + ", createtime=" + createtime + ", money=" + money
				+ ", struts=" + struts + ", explain=" + explain + "]";
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
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Integer getStruts() {
		return struts;
	}
	public void setStruts(Integer struts) {
		this.struts = struts;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
}
