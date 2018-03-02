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
@Table(name="raisemoney")
@Entity
public class RaiseMoney implements Serializable{
	private Integer id;//主键
	private Integer userid;//用户id
	private String djnumber;//筹集编号
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date cjtime;//时间
	private double cjmoney;//筹集金额
	private double zcmoney;//已筹集金额
	private Integer status;//状态(1.筹集中，2.筹集成功，3.筹集失败)
	public RaiseMoney() {
		super();
	}
	public RaiseMoney(Integer id, Integer userid, String djnumber, Date cjtime, double cjmoney, double zcmoney,
			Integer status) {
		super();
		this.id = id;
		this.userid = userid;
		this.djnumber = djnumber;
		this.cjtime = cjtime;
		this.cjmoney = cjmoney;
		this.zcmoney = zcmoney;
		this.status = status;
	}
	@Override
	public String toString() {
		return "RaiseMoney [id=" + id + ", userid=" + userid + ", djnumber=" + djnumber + ", cjtime=" + cjtime
				+ ", cjmoney=" + cjmoney + ", zcmoney=" + zcmoney + ", status=" + status + "]";
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
	public String getDjnumber() {
		return djnumber;
	}
	public void setDjnumber(String djnumber) {
		this.djnumber = djnumber;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCjtime() {
		return cjtime;
	}
	public void setCjtime(Date cjtime) {
		this.cjtime = cjtime;
	}
	public double getCjmoney() {
		return cjmoney;
	}
	public void setCjmoney(double cjmoney) {
		this.cjmoney = cjmoney;
	}
	public double getZcmoney() {
		return zcmoney;
	}
	public void setZcmoney(double zcmoney) {
		this.zcmoney = zcmoney;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
