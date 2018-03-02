package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_user_brokerage")
public class Brokerage implements Serializable{
	//用户佣金明细表
	private static final long serialVersionUID = 1L;
	@TableField("id")//主键
	private Integer id;
	@TableField("userid")//用户id
	private Integer userid;
	@TableField("brokeragemoney")//佣金金额
	private float brokeragemoney;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//奖励时间
	private Date hqtime;
	@TableField("mark")//什么标获取的佣金
	private String mark;
	@TableField("remark")//备注
	private String remark;
	@TableField("bychar")//备用字段1
	private String bychar;
	@TableField("bystr")//备用字段2
	private String bystr;
	public Brokerage() {
		super();
	}
	public Brokerage(Integer id, Integer userid, float brokeragemoney, Date hqtime, String mark, String remark,
			String bychar, String bystr) {
		super();
		this.id = id;
		this.userid = userid;
		this.brokeragemoney = brokeragemoney;
		this.hqtime = hqtime;
		this.mark = mark;
		this.remark = remark;
		this.bychar = bychar;
		this.bystr = bystr;
	}
	@Override
	public String toString() {
		return "Brokerage [id=" + id + ", userid=" + userid + ", brokeragemoney=" + brokeragemoney + ", hqtime="
				+ hqtime + ", mark=" + mark + ", remark=" + remark + ", bychar=" + bychar + ", bystr=" + bystr + "]";
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
	public float getBrokeragemoney() {
		return brokeragemoney;
	}
	public void setBrokeragemoney(float brokeragemoney) {
		this.brokeragemoney = brokeragemoney;
	}
	public Date getHqtime() {
		return hqtime;
	}
	public void setHqtime(Date hqtime) {
		this.hqtime = hqtime;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
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
