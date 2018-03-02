package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_loans_applyfor")
public class Applyfor implements Serializable{
	//借款申请表
	private static final long serialVersionUID = 1L;
	
	@TableField("id")//主键
	private Integer id;
	@TableField("userid")//用户id
	private Integer userid;
	@TableField("markid")//借款类型
	private Integer markid;
	@TableField("headline")//借款标题
	private String headline;
	@TableField("purpose")//借款用途
	private String purpose;
	@TableField("applyformoney")//借款金额
	private double applyformoney;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//申请时间
	private Date applyforTime;
	@TableField("borrowtime")//贷款时间（1-24个月）
	private Integer borrowtime;
	@TableField("deadline")//借款期限（-投标的最后日期）
	private String deadline;
	@TableField("nhrate")//年化利率
	private double nhrate;
	@TableField("paymentMode")//还款方式
	private Integer paymentMode;
	@TableField("repaymoney")//需还利息
	private double repaymoney;
	@TableField("managemoney")//管理费用
	private double managemoney;
	@TableField("struts")//审核表
	private Integer struts;
	@TableField("check")//审核人
	private Integer check;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//审核时间
	private Date sktime;
	@TableField("bychar")//备用字段1
	private String bychar;
	@TableField("bystr")//备用字段2
	private String bystr;
	private String uname;
	public Applyfor() {
		super();
	}
	public Applyfor(Integer id, Integer userid, Integer markid, String headline, String purpose, double applyformoney,
			Date applyforTime, Integer borrowtime, String deadline, double nhrate, Integer paymentMode, double repaymoney,
			double managemoney, Integer struts, Integer check, Date sktime, String bychar, String bystr) {
		super();
		this.id = id;
		this.userid = userid;
		this.markid = markid;
		this.headline = headline;
		this.purpose = purpose;
		this.applyformoney = applyformoney;
		this.applyforTime = applyforTime;
		this.borrowtime = borrowtime;
		this.deadline = deadline;
		this.nhrate = nhrate;
		this.paymentMode = paymentMode;
		this.repaymoney = repaymoney;
		this.managemoney = managemoney;
		this.struts = struts;
		this.check = check;
		this.sktime = sktime;
		this.bychar = bychar;
		this.bystr = bystr;
	}
	@Override
	public String toString() {
		return "Applyfor [id=" + id + ", userid=" + userid + ", markid=" + markid + ", headline=" + headline
				+ ", purpose=" + purpose + ", applyformoney=" + applyformoney + ", applyforTime=" + applyforTime
				+ ", borrowtime=" + borrowtime + ", deadline=" + deadline + ", nhrate=" + nhrate + ", paymentMode="
				+ paymentMode + ", repaymoney=" + repaymoney + ", managemoney=" + managemoney + ", struts=" + struts
				+ ", check=" + check + ", sktime=" + sktime + ", bychar=" + bychar + ", bystr=" + bystr + "]";
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
	public Integer getMarkid() {
		return markid;
	}
	public void setMarkid(Integer markid) {
		this.markid = markid;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public double getApplyformoney() {
		return applyformoney;
	}
	public void setApplyformoney(double applyformoney) {
		this.applyformoney = applyformoney;
	}
	public Date getApplyforTime() {
		return applyforTime;
	}
	public void setApplyforTime(Date applyforTime) {
		this.applyforTime = applyforTime;
	}
	public Integer getBorrowtime() {
		return borrowtime;
	}
	public void setBorrowtime(Integer borrowtime) {
		this.borrowtime = borrowtime;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public double getNhrate() {
		return nhrate;
	}
	public void setNhrate(double nhrate) {
		this.nhrate = nhrate;
	}
	public Integer getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(Integer paymentMode) {
		this.paymentMode = paymentMode;
	}
	public double getRepaymoney() {
		return repaymoney;
	}
	public void setRepaymoney(double repaymoney) {
		this.repaymoney = repaymoney;
	}
	public double getManagemoney() {
		return managemoney;
	}
	public void setManagemoney(double managemoney) {
		this.managemoney = managemoney;
	}
	public Integer getStruts() {
		return struts;
	}
	public void setStruts(Integer struts) {
		this.struts = struts;
	}
	public Integer getCheck() {
		return check;
	}
	public void setCheck(Integer check) {
		this.check = check;
	}
	public Date getSktime() {
		return sktime;
	}
	public void setSktime(Date sktime) {
		this.sktime = sktime;
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
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
}
