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
@Table(name="t_merchant_user")
@Entity
public class MerchantUser implements Serializable{
	private Integer id;
	private String username;
	private String password;
	private String name;
	private String siteurl;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createtime;
	private double money;
	private double djmoney;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hztime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date jstime;
	public MerchantUser() {
		super();
	}
	public MerchantUser(Integer id, String username, String password, String name, String siteurl, Date createtime,
			double money, double djmoney) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.siteurl = siteurl;
		this.createtime = createtime;
		this.money = money;
		this.djmoney = djmoney;
	}
	@Override
	public String toString() {
		return "MerchantUser [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", siteurl=" + siteurl + ", createtime=" + createtime + ", money=" + money + ", djmoney=" + djmoney
				+ "]";
	}
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getSiteurl() {
		return siteurl;
	}
	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
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
	public double getDjmoney() {
		return djmoney;
	}
	public void setDjmoney(double djmoney) {
		this.djmoney = djmoney;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getHztime() {
		return hztime;
	}
	public void setHztime(Date hztime) {
		this.hztime = hztime;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getJstime() {
		return jstime;
	}
	public void setJstime(Date jstime) {
		this.jstime = jstime;
	}
}
