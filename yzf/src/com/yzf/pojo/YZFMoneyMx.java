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
@Table(name="yzfmoneymx")
@Entity
public class YZFMoneyMx implements Serializable{
	private Integer id;
	private Integer yzfid;
	private double yzfqmoney;
	private double yzfbmoney;
	private double yzfhmoney;
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date mxtime;
	private Integer state;
	private	String rm;
	public YZFMoneyMx() {
		super();
	}
	public YZFMoneyMx(Integer id, Integer yzfid, double yzfqmoney, double yzfbmoney, double yzfhmoney, Date mxtime,
			Integer state, String rm) {
		super();
		this.id = id;
		this.yzfid = yzfid;
		this.yzfqmoney = yzfqmoney;
		this.yzfbmoney = yzfbmoney;
		this.yzfhmoney = yzfhmoney;
		this.mxtime = mxtime;
		this.state = state;
		this.rm = rm;
	}
	@Override
	public String toString() {
		return "YZFMoneyMx [id=" + id + ", yzfid=" + yzfid + ", yzfqmoney=" + yzfqmoney + ", yzfbmoney=" + yzfbmoney
				+ ", yzfhmoney=" + yzfhmoney + ", mxtime=" + mxtime + ", state=" + state + ", rm=" + rm + "]";
	}
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getYzfid() {
		return yzfid;
	}
	public void setYzfid(Integer yzfid) {
		this.yzfid = yzfid;
	}
	public double getYzfqmoney() {
		return yzfqmoney;
	}
	public void setYzfqmoney(double yzfqmoney) {
		this.yzfqmoney = yzfqmoney;
	}
	public double getYzfbmoney() {
		return yzfbmoney;
	}
	public void setYzfbmoney(double yzfbmoney) {
		this.yzfbmoney = yzfbmoney;
	}
	public double getYzfhmoney() {
		return yzfhmoney;
	}
	public void setYzfhmoney(double yzfhmoney) {
		this.yzfhmoney = yzfhmoney;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getMxtime() {
		return mxtime;
	}
	public void setMxtime(Date mxtime) {
		this.mxtime = mxtime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRm() {
		return rm;
	}
	public void setRm(String rm) {
		this.rm = rm;
	}
}
