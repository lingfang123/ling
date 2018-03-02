package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;

public class UserVip implements Serializable{
	//用户VIP表 t_user_vip
	private static final long serialVersionUID = 1L;
	@TableField("id")//主键
	private Integer id;
	@TableField("userid")//用户id
	private Integer userid;
	@TableField("vipdj")//VIP等级
	private Integer vipdj;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//生成时间
	private Date viptime;
	@TableField("remark")//说明
	private String remark;
	@TableField("bychar")//备用字段1
	private String bychar;
	@TableField("bystr")//备用字段2
	private String bystr;
	
	public UserVip() {
		super();
	}
	public UserVip(Integer id, Integer userid, Integer vipdj, Date viptime, String remark, String bychar,
			String bystr) {
		super();
		this.id = id;
		this.userid = userid;
		this.vipdj = vipdj;
		this.viptime = viptime;
		this.remark = remark;
		this.bychar = bychar;
		this.bystr = bystr;
	}
	@Override
	public String toString() {
		return "Uservip [id=" + id + ", userid=" + userid + ", vipdj=" + vipdj + ", viptime=" + viptime + ", remark="
				+ remark + ", bychar=" + bychar + ", bystr=" + bystr + "]";
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
	public Integer getVipdj() {
		return vipdj;
	}
	public void setVipdj(Integer vipdj) {
		this.vipdj = vipdj;
	}
	public Date getViptime() {
		return viptime;
	}
	public void setViptime(Date viptime) {
		this.viptime = viptime;
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
