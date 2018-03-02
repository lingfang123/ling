package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
@TableName(" t_invitation")
public class Invitation implements Serializable{
	//邀请表
	private static final long serialVersionUID = 1L;
	@TableField("id")//主键
	private Integer id;
	@TableField("userid")//用户id
	private Integer userid;
	@TableField("yquserid")//被邀请人id
	private Integer yquserid;
	@TableField("yqtime")//邀请时间
	private Date yqtime;
	@TableField("bychar")//备用字段1
	private String bychar;
	@TableField("bystr")//备用字段2
	private String bystr;
	public Invitation() {
		super();
	}
	public Invitation(Integer id, Integer userid, Integer yquserid, Date yqtime, String bychar, String bystr) {
		super();
		this.id = id;
		this.userid = userid;
		this.yquserid = yquserid;
		this.yqtime = yqtime;
		this.bychar = bychar;
		this.bystr = bystr;
	}
	@Override
	public String toString() {
		return "Invitation [id=" + id + ", userid=" + userid + ", yquserid=" + yquserid + ", yqtime=" + yqtime
				+ ", bychar=" + bychar + ", bystr=" + bystr + "]";
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
	public Integer getYquserid() {
		return yquserid;
	}
	public void setYquserid(Integer yquserid) {
		this.yquserid = yquserid;
	}
	public Date getYqtime() {
		return yqtime;
	}
	public void setYqtime(Date yqtime) {
		this.yqtime = yqtime;
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
