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
@Table(name="t_bankcard")
@Entity
public class BankCardMn implements Serializable{
	private Integer id;
	private Integer type;
	private String bankcardno;
	private String name;
	private String sfbankcardno;
	private String phone;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date createtime;
	private double money;
	public BankCardMn() {
		super();
	}
	public BankCardMn(Integer id, Integer type, String bankcardno, String name, String sfbankcardno, String phone,
			Date createtime, double money) {
		super();
		this.id = id;
		this.type = type;
		this.bankcardno = bankcardno;
		this.name = name;
		this.sfbankcardno = sfbankcardno;
		this.phone = phone;
		this.createtime = createtime;
		this.money = money;
	}
	@Override
	public String toString() {
		return "BankCardMn [id=" + id + ", type=" + type + ", bankcardno=" + bankcardno + ", name=" + name
				+ ", sfbankcardno=" + sfbankcardno + ", phone=" + phone + ", createtime=" + createtime + ", money="
				+ money + "]";
	}
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getBankcardno() {
		return bankcardno;
	}
	public void setBankcardno(String bankcardno) {
		this.bankcardno = bankcardno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSfbankcardno() {
		return sfbankcardno;
	}
	public void setSfbankcardno(String sfbankcardno) {
		this.sfbankcardno = sfbankcardno;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
}
