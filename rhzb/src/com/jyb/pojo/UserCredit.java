package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;

public class UserCredit implements Serializable{
	//用户信用表
	private static final long serialVersionUID = 1L;
	@TableField("id")//主键
	private Integer id;
	@TableField("userid")//用户id
	private Integer userid;
	@TableField("integral")//用户积分
	private Integer integral;
	@TableField("lineOfCredit")//信用额度
	private float lineOfCredit;
	@TableField("jknumber")//借款笔数
	private Integer jknumber;
	@TableField("yqnumber")//逾期笔数
	private Integer yqnumber;
	@TableField("bychar")//备用字段1
	private String bychar;
	@TableField("bystr")//备用字段2
	private String bystr;
	
	@Override
	public String toString() {
		return "Credit [id=" + id + ", userid=" + userid + ", integral=" + integral + ", lineOfCredit=" + lineOfCredit
				+ ", jknumber=" + jknumber + ", yqnumber=" + yqnumber + ", bychar=" + bychar + ", bystr=" + bystr + "]";
	}
	public UserCredit() {
		super();
	}
	public UserCredit(Integer id, Integer userid, Integer integral, float lineOfCredit, Integer jknumber, Integer yqnumber,
			String bychar, String bystr) {
		super();
		this.id = id;
		this.userid = userid;
		this.integral = integral;
		this.lineOfCredit = lineOfCredit;
		this.jknumber = jknumber;
		this.yqnumber = yqnumber;
		this.bychar = bychar;
		this.bystr = bystr;
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
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public float getLineOfCredit() {
		return lineOfCredit;
	}
	public void setLineOfCredit(float lineOfCredit) {
		this.lineOfCredit = lineOfCredit;
	}
	public Integer getJknumber() {
		return jknumber;
	}
	public void setJknumber(Integer jknumber) {
		this.jknumber = jknumber;
	}
	public Integer getYqnumber() {
		return yqnumber;
	}
	public void setYqnumber(Integer yqnumber) {
		this.yqnumber = yqnumber;
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
