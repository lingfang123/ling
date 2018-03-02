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
@Table(name="t_order")
@Entity
public class Order implements Serializable{ 
	private Integer id;
	private Integer userid;
	private String ordernumber;
	private float money;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date ordertime;
	private Integer status;
	public Order() {
		super();
	}
	public Order(Integer id, Integer userid, String ordernumber, float money, Date ordertime, Integer status) {
		super();
		this.id = id;
		this.userid = userid;
		this.ordernumber = ordernumber;
		this.money = money;
		this.ordertime = ordertime;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userid=" + userid + ", ordernumber=" + ordernumber + ", money=" + money
				+ ", ordertime=" + ordertime + ", status=" + status + "]";
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
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
