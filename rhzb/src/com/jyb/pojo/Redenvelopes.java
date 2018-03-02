package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_redenvelopes")
public class Redenvelopes implements Serializable {
	//用户红包表
	private static final long serialVersionUID = 1L;
	@TableField("id")//主键
	private Integer id;
	@TableField("userid")//用户id
	private Integer userid;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//收红包时间
	private Date harvesttime;
	@TableField("minmoney")//最少投标金额
	private double minmoney;
	@TableField("tjmoney")//可到多少金额
	private double tjmoney;
	@TableField("hbmoney")//红包金额
	private double hbmoney;
	@TableField("expiretime")//到期时间
	private Date expiretime;
	@TableField("struts")//状态
	private Integer struts;
	@TableField("daynumber")//到期天数
	private Integer daynumber;
	@TableField("remark")//备注
	private String remark;
	@TableField("bychar")//备用字段1
	private String bychar;
	@TableField("bystr")//备用字段2
	private String bystr;
	public Redenvelopes() {
		super();
	}
	public Redenvelopes(Integer id, Integer userid, Date harvesttime, double minmoney, double tjmoney, double hbmoney,
			Date expiretime, Integer struts, Integer daynumber, String remark, String bychar, String bystr) {
		super();
		this.id = id;
		this.userid = userid;
		this.harvesttime = harvesttime;
		this.minmoney = minmoney;
		this.tjmoney = tjmoney;
		this.hbmoney = hbmoney;
		this.expiretime = expiretime;
		this.struts = struts;
		this.daynumber = daynumber;
		this.remark = remark;
		this.bychar = bychar;
		this.bystr = bystr;
	}
	@Override
	public String toString() {
		return "Redenvelopes [id=" + id + ", userid=" + userid + ", harvesttime=" + harvesttime + ", minmoney="
				+ minmoney + ", tjmoney=" + tjmoney + ", hbmoney=" + hbmoney + ", expiretime=" + expiretime
				+ ", struts=" + struts + ", daynumber=" + daynumber + ", remark=" + remark + ", bychar=" + bychar
				+ ", bystr=" + bystr + "]";
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
	public Date getHarvesttime() {
		return harvesttime;
	}
	public void setHarvesttime(Date harvesttime) {
		this.harvesttime = harvesttime;
	}
	public double getMinmoney() {
		return minmoney;
	}
	public void setMinmoney(double minmoney) {
		this.minmoney = minmoney;
	}
	public double getTjmoney() {
		return tjmoney;
	}
	public void setTjmoney(double tjmoney) {
		this.tjmoney = tjmoney;
	}
	public double getHbmoney() {
		return hbmoney;
	}
	public void setHbmoney(double hbmoney) {
		this.hbmoney = hbmoney;
	}
	public Date getExpiretime() {
		return expiretime;
	}
	public void setExpiretime(Date expiretime) {
		this.expiretime = expiretime;
	}
	public Integer getStruts() {
		return struts;
	}
	public void setStruts(Integer struts) {
		this.struts = struts;
	}
	public Integer getDaynumber() {
		return daynumber;
	}
	public void setDaynumber(Integer daynumber) {
		this.daynumber = daynumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
