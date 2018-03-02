package com.yzf.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@SuppressWarnings("serial")
@Cacheable
@Table(name="t_user")
@Entity
public class User implements Serializable{
	private Integer id;
	private Integer p2pid;
	private String username;
	private String password;
	private String name;
	private String cardno;
	private String phone;
	private String paypass;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date createtime;
	private double money;
	private double accountfrozen;
	public User() {
		super();
	}
	public User(Integer id, Integer p2pid, String username, String password, String name, String cardno, String paypass,
			Date createtime, double money, double accountfrozen) {
		super();
		this.id = id;
		this.p2pid = p2pid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.cardno = cardno;
		this.paypass = paypass;
		this.createtime = createtime;
		this.money = money;
		this.accountfrozen = accountfrozen;
	}
	public String toString() {
		return "User [id=" + id + ", p2pid=" + p2pid + ", username=" + username + ", password=" + password + ", name="
				+ name + ", cardno=" + cardno + ", paypass=" + paypass + ", createtime=" + createtime + ", money="
				+ money + ", accountfrozen=" + accountfrozen + "]";
	}
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getP2pid() {
		return p2pid;
	}
	public void setP2pid(Integer p2pid) {
		this.p2pid = p2pid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@JoinColumn(name="cardNo")
	public String getCardNo() {
		return cardno;
	}
	public void setCardNo(String cardno) {
		this.cardno = cardno;
	}
	public String getPaypass() {
		return paypass;
	}
	public void setPaypass(String paypass) {
		this.paypass = paypass;
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
	public double getAccountfrozen() {
		return accountfrozen;
	}
	public void setAccountfrozen(double accountfrozen) {
		this.accountfrozen = accountfrozen;
	}
}
