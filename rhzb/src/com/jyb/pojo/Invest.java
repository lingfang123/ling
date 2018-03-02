package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_invest")
public class Invest implements Serializable{

	/**
	 * 投资记录表 t_invest
	 */
	private static final long serialVersionUID = 1L;
	private  Integer id; 			// 主键
	private  Integer userid; 		// 用户id(用户表 t_user)
	private  Integer tmarkid; 		// 标的id(发标表 t_mark_info)
	private  Integer markid; 		// 标的类型(标型表 t_mark)
	private  Date refundtime; 		// 计息时间
	private  double markmoney; 		// 投资金额
	private  double overduemoney; 	// 预期收益
	private  String borrowtime; 	// 借款期限（借多少个月）
	private  Date bidtime; 			// 投标时间
	private  Integer status; 		// 状态(1:竞标中2:流标3:竞标成功4:还款中5:已完成）
	private Integer hbid;			//红包id
	private double hbmoney;			//红包抵扣金额
	//备用字段
	private  String backup1; 		// 备用字段1
	private  String backup2; 		// 备用字段2
	//虚拟字段
	private String title;
	private String username;
	public Invest() {
		super();
	}
	public Invest(Integer id, Integer userid, Integer tmarkid, Integer markid, Date refundtime, double markmoney,
			double overduemoney, String borrowtime, Date bidtime, Integer status, String backup1, String backup2) {
		super();
		this.id = id;
		this.userid = userid;
		this.tmarkid = tmarkid;
		this.markid = markid;
		this.refundtime = refundtime;
		this.markmoney = markmoney;
		this.overduemoney = overduemoney;
		this.borrowtime = borrowtime;
		this.bidtime = bidtime;
		this.status = status;
		this.backup1 = backup1;
		this.backup2 = backup2;
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
	public Integer getMarkid() {
		return markid;
	}
	public void setMarkid(Integer markid) {
		this.markid = markid;
	}
	public Date getRefundtime() {
		return refundtime;
	}
	public void setRefundtime(Date refundtime) {
		this.refundtime = refundtime;
	}
	public double getMarkmoney() {
		return markmoney;
	}
	public void setMarkmoney(double markmoney) {
		this.markmoney = markmoney;
	}
	public double getOverduemoney() {
		return overduemoney;
	}
	public void setOverduemoney(double overduemoney) {
		this.overduemoney = overduemoney;
	}
	public String getBorrowtime() {
		return borrowtime;
	}
	public void setBorrowtime(String borrowtime) {
		this.borrowtime = borrowtime;
	}
	public Date getBidtime() {
		return bidtime;
	}
	public void setBidtime(Date bidtime) {
		this.bidtime = bidtime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Invest [id=" + id + ", userid=" + userid + ", tmarkid=" + tmarkid + ", markid=" + markid
				+ ", refundtime=" + refundtime + ", markmoney=" + markmoney + ", overduemoney=" + overduemoney
				+ ", borrowtime=" + borrowtime + ", bidtime=" + bidtime + ", status=" + status + ", backup1=" + backup1
				+ ", backup2=" + backup2 + "]";
	}
	public Integer getHbid() {
		return hbid;
	}
	public void setHbid(Integer hbid) {
		this.hbid = hbid;
	}
	public double getHbmoney() {
		return hbmoney;
	}
	public void setHbmoney(double hbmoney) {
		this.hbmoney = hbmoney;
	}
}
