package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;

public class Vipchange implements Serializable{
	//vip变动表
	private static final long serialVersionUID = 1L;
	@TableField("id")//主键
	private Integer id;
	@TableField("userid")//用户id
	private Integer userid;
	@TableField("vipid")//用户vip表
	private Integer vipid;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//变动时间
	private Date changetiem;
	@TableField("ydjvip")//原等级
	private Integer ydjvip;
	@TableField("bdjvip")//变动级别
	private Integer bdjvip;
	@TableField("bychar")//备用字段1
	private String bychar;
	@TableField("bystr")//备用字段2
	private String bystr;
	
	public Vipchange() {
		super();
	}
	public Vipchange(Integer id, Integer userid, Integer vipid, Date changetiem, Integer ydjvip, Integer bdjvip,
			String bychar, String bystr) {
		super();
		this.id = id;
		this.userid = userid;
		this.vipid = vipid;
		this.changetiem = changetiem;
		this.ydjvip = ydjvip;
		this.bdjvip = bdjvip;
		this.bychar = bychar;
		this.bystr = bystr;
	}
	@Override
	public String toString() {
		return "Vipchange [id=" + id + ", userid=" + userid + ", vipid=" + vipid + ", changetiem=" + changetiem
				+ ", ydjvip=" + ydjvip + ", bdjvip=" + bdjvip + ", bychar=" + bychar + ", bystr=" + bystr + "]";
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
	public Integer getVipid() {
		return vipid;
	}
	public void setVipid(Integer vipid) {
		this.vipid = vipid;
	}
	public Date getChangetiem() {
		return changetiem;
	}
	public void setChangetiem(Date changetiem) {
		this.changetiem = changetiem;
	}
	public Integer getYdjvip() {
		return ydjvip;
	}
	public void setYdjvip(Integer ydjvip) {
		this.ydjvip = ydjvip;
	}
	public Integer getBdjvip() {
		return bdjvip;
	}
	public void setBdjvip(Integer bdjvip) {
		this.bdjvip = bdjvip;
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
