package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_fund_detail")
public class Detail implements Serializable{
	//用户资金明细表
	private static final long serialVersionUID = 1L;
	@TableField("id")//主键
	private Integer id;
	@TableField("userid")//用户id
	private Integer userid;
	@TableField("money")//明细金额
	private double money;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//明细时间
	private Date dateiltime;
	@TableField("struts")//状态
	private Integer struts;
	@TableField("remark")//备注
	private String remark;
	@TableField("bychar")//备用字段1
	private double bychar;
	@TableField("bystr")//备用字段2
	private String bystr;
	
	public Detail() {
		super();
	}
	public Detail(Integer id, Integer userid, double money, Date dateiltime, Integer struts, String remark,
			double bychar, String bystr) {
		super();
		this.id = id;
		this.userid = userid;
		this.money = money;
		this.dateiltime = dateiltime;
		this.struts = struts;
		this.remark = remark;
		this.bychar = bychar;
		this.bystr = bystr;
	}
	@Override
	public String toString() {
		return "Detail [id=" + id + ", userid=" + userid + ", money=" + money + ", dateiltime=" + dateiltime
				+ ", struts=" + struts + ", remark=" + remark + ", bychar=" + bychar + ", bystr=" + bystr + "]";
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
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Date getDateiltime() {
		return dateiltime;
	}
	public void setDateiltime(Date dateiltime) {
		this.dateiltime = dateiltime;
	}
	public Integer getStruts() {
		return struts;
	}
	public void setStruts(Integer struts) {
		this.struts = struts;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public double getBychar() {
		return bychar;
	}
	public void setBychar(double bychar) {
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
