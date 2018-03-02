package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;

public class UserIntegral implements Serializable{
	//用户积分明细表
	private static final long serialVersionUID = 1L;
	@TableField("id")//主键
	private Integer id;
	@TableField("userid")//用户id
	private Integer userid;
	@TableField("credit")//信用表id
	private Integer credit;
	@TableField("changeintegral")//积分变动
	private Integer changeintegral;
	@TableField("changetype")//变动类型
	private String changetype;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//变动时间
	private Date integraltime;
	@TableField("bychar")//备用字段1
	private String bychar;
	@TableField("bystr")//备用字段2
	private String bystr;
	
	public UserIntegral() {
		super();
	}
	public UserIntegral(Integer id, Integer userid, Integer credit, Integer changeintegral, String changetype,
			Date integraltime, String bychar, String bystr) {
		super();
		this.id = id;
		this.userid = userid;
		this.credit = credit;
		this.changeintegral = changeintegral;
		this.changetype = changetype;
		this.integraltime = integraltime;
		this.bychar = bychar;
		this.bystr = bystr;
	}
	
	@Override
	public String toString() {
		return "Integral [id=" + id + ", userid=" + userid + ", credit=" + credit + ", changeintegral=" + changeintegral
				+ ", changetype=" + changetype + ", integraltime=" + integraltime + ", bychar=" + bychar + ", bystr="
				+ bystr + "]";
	}
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
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Integer getChangeintegral() {
		return changeintegral;
	}
	public void setChangeintegral(Integer changeintegral) {
		this.changeintegral = changeintegral;
	}
	public String getChangetype() {
		return changetype;
	}
	public void setChangetype(String changetype) {
		this.changetype = changetype;
	}
	public Date getIntegraltime() {
		return integraltime;
	}
	public void setIntegraltime(Date integraltime) {
		this.integraltime = integraltime;
	}
	public String getBychar() {
		return bychar;
	}
	public void setBychar(String bychar) {
		this.bychar = bychar;
	}
	public String getBystr() {
		return bystr;
	}
	public void setBystr(String bystr) {
		this.bystr = bystr;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
