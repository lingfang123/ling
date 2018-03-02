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
@Table(name="authuser")
@Entity
public class AuthUser implements Serializable{
	private Integer id;//管理员id
	private String username;//登入名
	private String password;//密码
	private Integer sex;//性别
	private Integer age;//年龄
	private String name;//真实姓名
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	private Date rxtime;//入职时间
	private String phone;//手机号码
	private String email;//邮箱
	private Integer state;//是否在职 1在职，2，离职
	private Integer status;//状态 1 在线 2离线
	private Integer rid;//角色
	public AuthUser() {
		super();
	}
	public AuthUser(Integer id, String username, String password, Integer sex, Integer age, String name, Date rxtime,
			String phone, String email, Integer state, Integer status, Integer rid) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.age = age;
		this.name = name;
		this.rxtime = rxtime;
		this.phone = phone;
		this.email = email;
		this.state = state;
		this.status = status;
		this.rid = rid;
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
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getRxtime() {
		return rxtime;
	}
	public void setRxtime(Date rxtime) {
		this.rxtime = rxtime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
}