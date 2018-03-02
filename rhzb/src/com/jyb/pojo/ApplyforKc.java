package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_applyfor_kc")
public class ApplyforKc implements Serializable{

	/**
	 * 实地考察 t_applyfor_kc
	 */
	private static final long serialVersionUID = 1L;
	private Integer id; 							// 主键
	private String name; 							// 称呼
	private Integer applyforid; 					// 贷款申请表id
	private String phone; 							// 联系方式
	private Date time; 								// 时间
	private String email; 							// 邮箱
	private String address; 						// 详细地址
	private Integer struts; 						// 状态(0:未联系，1:已联系，2:考察中，3:已考察)
	//备用字段
	private String backup1; 						// 备用字段1
	private String backup2; 						// 备用字段2
	public ApplyforKc() {
		super();
	}
	public ApplyforKc(Integer id, String name, Integer applyforid, String phone, Date time, String email,
			String address, Integer struts, String backup1, String backup2) {
		super();
		this.id = id;
		this.name = name;
		this.applyforid = applyforid;
		this.phone = phone;
		this.time = time;
		this.email = email;
		this.address = address;
		this.struts = struts;
		this.backup1 = backup1;
		this.backup2 = backup2;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getApplyforid() {
		return applyforid;
	}
	public void setApplyforid(Integer applyforid) {
		this.applyforid = applyforid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getStruts() {
		return struts;
	}
	public void setStruts(Integer struts) {
		this.struts = struts;
	}
	public String getBackup1() {
		return backup1;
	}
	public void setBackup1(String backup1) {
		this.backup1 = backup1;
	}
	public String getBackup2() {
		return backup2;
	}
	public void setBackup2(String backup2) {
		this.backup2 = backup2;
	}
	@Override
	public String toString() {
		return "ApplyforKc [id=" + id + ", name=" + name + ", applyforid=" + applyforid + ", phone=" + phone + ", time="
				+ time + ", email=" + email + ", address=" + address + ", struts=" + struts + ", backup1=" + backup1
				+ ", backup2=" + backup2 + "]";
	}
	
	
}
