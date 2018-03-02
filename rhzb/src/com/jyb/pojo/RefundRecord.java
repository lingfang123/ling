package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_refund_record")
public class RefundRecord implements Serializable{

	/**
	 * 还款记录表 t_refund_record
	 */
	private static final long serialVersionUID = 1L;
	private  Integer id; 				// 主键
	private  Integer userid; 			// 用户id(用户表 t_user)
	private  Integer tmarkid; 			// 标的id(发标表 t_mark_info)
	private  Date refundtime; 			// 还款时间
	private  double hkmoney; 			// 还款金额
	private  double principal; 			// 还款本金
	private  double Integererests; 		// 还款利息
	private  Integer overduestatus; 	// 是否逾期（0.逾期，1.未逾期）
	private  Integer overduedays; 		// 逾期天数
	private  double overduemoney; 		// 逾期费用
	private  Integer status; 			// 状态（0.代还款，1.已还款，2.已过期）
	private  String remark; 			// 对该条记录添加一定的相关信息
	//备用字段
	private  String backup1; 			// 备用字段1
	private  String backup2; 			// 备用字段2
	
	private String markname;
	public RefundRecord() {
		super();
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
	public Integer getTmarkid() {
		return tmarkid;
	}
	public void setTmarkid(Integer tmarkid) {
		this.tmarkid = tmarkid;
	}
	public Date getRefundtime() {
		return refundtime;
	}
	public void setRefundtime(Date refundtime) {
		this.refundtime = refundtime;
	}
	public double getHkmoney() {
		return hkmoney;
	}
	public void setHkmoney(double hkmoney) {
		this.hkmoney = hkmoney;
	}
	public double getPrincipal() {
		return principal;
	}
	public void setPrincipal(double principal) {
		this.principal = principal;
	}
	public double getIntegererests() {
		return Integererests;
	}
	public void setIntegererests(double integererests) {
		Integererests = integererests;
	}
	public Integer getOverduestatus() {
		return overduestatus;
	}
	public void setOverduestatus(Integer overduestatus) {
		this.overduestatus = overduestatus;
	}
	public Integer getOverduedays() {
		return overduedays;
	}
	public void setOverduedays(Integer overduedays) {
		this.overduedays = overduedays;
	}
	public double getOverduemoney() {
		return overduemoney;
	}
	public void setOverduemoney(double overduemoney) {
		this.overduemoney = overduemoney;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getBackup1() {
		return backup1;
	}
	public void setBackup1(String backup1) {
		this.backup1 = backup1;
	}
	public String getBackup2() {
		return backup2;
	}
	public void setBackup2(String backup2) {
		this.backup2 = backup2;
	}
	public String getMarkname() {
		return markname;
	}
	public void setMarkname(String markname) {
		this.markname = markname;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "RefundRecord [id=" + id + ", userid=" + userid + ", tmarkid=" + tmarkid + ", refundtime=" + refundtime
				+ ", hkmoney=" + hkmoney + ", principal=" + principal + ", Integererests=" + Integererests
				+ ", overduestatus=" + overduestatus + ", overduedays=" + overduedays + ", overduemoney=" + overduemoney
				+ ", status=" + status + ", remark=" + remark + ", backup1=" + backup1 + ", backup2=" + backup2
				+ ", markname=" + markname + "]";
	}
	public RefundRecord(Integer id, Integer userid, Integer tmarkid, Date refundtime, double hkmoney, double principal,
			double integererests, Integer overduestatus, Integer overduedays, double overduemoney, Integer status,
			String remark, String backup1, String backup2, String markname) {
		super();
		this.id = id;
		this.userid = userid;
		this.tmarkid = tmarkid;
		this.refundtime = refundtime;
		this.hkmoney = hkmoney;
		this.principal = principal;
		Integererests = integererests;
		this.overduestatus = overduestatus;
		this.overduedays = overduedays;
		this.overduemoney = overduemoney;
		this.status = status;
		this.remark = remark;
		this.backup1 = backup1;
		this.backup2 = backup2;
		this.markname = markname;
	}
	
}
