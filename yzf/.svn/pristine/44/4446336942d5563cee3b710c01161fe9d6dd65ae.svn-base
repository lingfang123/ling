package com.yzf.pojo;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Cacheable
@Table(name="yzfmoney")
@Entity
public class YZFMoney implements Serializable{
	/**
	 * 易支付账户
	 * */
	private Integer id;
	private double yzfname;
	private double yzfmoney;
	private double yzfdjmoney;
	public YZFMoney() {
		super();
	}
	public YZFMoney(Integer id, double yzfname, double yzfmoney, double yzfdjmoney) {
		super();
		this.id = id;
		this.yzfname = yzfname;
		this.yzfmoney = yzfmoney;
		this.yzfdjmoney = yzfdjmoney;
	}
	@Override
	public String toString() {
		return "YZFMoney [id=" + id + ", yzfname=" + yzfname + ", yzfmoney=" + yzfmoney + ", yzfdjmoney=" + yzfdjmoney
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
	public double getYzfname() {
		return yzfname;
	}
	public void setYzfname(double yzfname) {
		this.yzfname = yzfname;
	}
	public double getYzfmoney() {
		return yzfmoney;
	}
	public void setYzfmoney(double yzfmoney) {
		this.yzfmoney = yzfmoney;
	}
	public double getYzfdjmoney() {
		return yzfdjmoney;
	}
	public void setYzfdjmoney(double yzfdjmoney) {
		this.yzfdjmoney = yzfdjmoney;
	}
}

