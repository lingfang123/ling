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
@Table(name="t_bank_card")
@Entity
public class BankCard implements Serializable{
	private Integer id;
	private Integer userid;
	private Integer type;
	private String bankcardno;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date createtime;
	private Integer struts;
	public BankCard() {
		super();
	}
	public BankCard(Integer id, Integer userid, Integer type, String bankcardno, Date createtime, Integer struts) {
		super();
		this.id = id;
		this.userid = userid;
		this.type = type;
		this.bankcardno = bankcardno;
		this.createtime = createtime;
		this.struts = struts;
	}
	@Override
	public String toString() {
		return "BankCard [id=" + id + ", userid=" + userid + ", type=" + type + ", bankcardno=" + bankcardno
				+ ", createtime=" + createtime + ", struts=" + struts + "]";
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
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Integer getStruts() {
		return struts;
	}
	public void setStruts(Integer struts) {
		this.struts = struts;
	}
}