package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_redinfo")
public class RedInfo implements Serializable{
	//红包明细
	private static final long serialVersionUID = 1L;
	@TableId("id")//主键
	private Integer id;
	@TableField("userid")//用户id
	private Integer userid;
	@TableField("redid")//用户红包id
	private Integer redid;
	@TableField("markid")//投标id
	private Integer markid;
	@TableField("redname")//红包名称
	private String redname;
	@TableField("markname")//投标名称
	private String markname;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//使用日期
	private Date redtime;
	@TableField("bychar")//备用字段1
	private String bychar;
	@TableField("bystr")//备用字段2
	private String bystr;
	public RedInfo() {
		super();
	}
	public RedInfo(Integer id, Integer userid, Integer redid, Integer markid, String redname, String markname,
			Date redtime, String bychar, String bystr) {
		super();
		this.id = id;
		this.userid = userid;
		this.redid = redid;
		this.markid = markid;
		this.redname = redname;
		this.markname = markname;
		this.redtime = redtime;
		this.bychar = bychar;
		this.bystr = bystr;
	}
	@Override
	public String toString() {
		return "RedInfo [id=" + id + ", userid=" + userid + ", redid=" + redid + ", markid=" + markid + ", redname="
				+ redname + ", markname=" + markname + ", redtime=" + redtime + ", bychar=" + bychar + ", bystr="
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
	public Integer getRedid() {
		return redid;
	}
	public void setRedid(Integer redid) {
		this.redid = redid;
	}
	public Integer getMarkid() {
		return markid;
	}
	public void setMarkid(Integer markid) {
		this.markid = markid;
	}
	public String getRedname() {
		return redname;
	}
	public void setRedname(String redname) {
		this.redname = redname;
	}
	public String getMarkname() {
		return markname;
	}
	public void setMarkname(String markname) {
		this.markname = markname;
	}
	public Date getRedtime() {
		return redtime;
	}
	public void setRedtime(Date redtime) {
		this.redtime = redtime;
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
