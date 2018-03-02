package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
@SuppressWarnings("serial")
@TableName("t_mark_info")
public class MarkInfo implements Serializable{
	/**
	 * 发标表 t_mark_info
	 */
	@TableId("id")
	private  Integer id; 				// 主键
	@TableField("userid")
	private  Integer userid; 			// 用户id(用户表 t_user)
	@TableField("applyforid")
	private  Integer applyforid; 		// 贷款申请表id(借款申请表 t_loans_applyfor)
	@TableField("headline")
	private  String headline; 			// 标的标题
	@TableField("money")
	private  double money; 				// 借款金额
	@TableField("markid")
	private  Integer markid; 			// 借款类型(某某标)
	@TableField("countmoney")
	private  double countmoney; 			// 已筹金额
	@TableField("accrual")
	private  double accrual;				//标的投资利率（在申请表通过时计算添加）
	@TableField("refundtypeid")
	private Integer refundtypeid;		// 借款人还款类型表id
	@TableField("paymentMode")
	private  Integer paymentMode; 		// 还款方式(1 按月等额本息还款 2 按先息后本还款)
	@TableField("investmin")
	private  double investmin; 			// 最小投资金额（默认0）
	@TableField("investmax")
	private  double investmax; 			// 最大投资金额（默认是借款金额）
	@TableField("borrowtime")
	private  String borrowtime; 		// 借款期限（借多少个月）
	@TableField("purpose")
	private  String purpose; 			// 借款用途
	@TableField("deadline")
	private  Date deadline; 			// 筹款期限-竞标结束时间（在这个时间点前要完成）
	@TableField("starttime")
	private  Date starttime;			// 竞标开始时间
	@TableField("refundstart")
	private  String refundstart; 		// 还款开始时间（标完成的下一个月开始）
	@TableField("moneyaccrual")
	private  double moneyaccrual; 		// 已还利息费用（借款人还了多少利息）
	@TableField("moneybenjin")
	private  double moneybenjin;  		// 已还本金（借款人还了多少本金）
	@TableField("overduestatus")
	private  Integer overduestatus; 	// 是否逾期（0.逾期，1.未愈期）
	@TableField("projectrating")
	private  String projectrating; 		// 项目评级
	@TableField("vcopinion")
	private  String vcopinion;			// 风投意见
	@TableField("vcopiniondj")
	private  Integer vcopiniondj; 		// 风险等级
	@TableField("count")
	private  Integer count; 			// 投资人数
	@TableField("struts")
	private  Integer struts; 			// 状态(0:未开始1:竞标中2:流标3:满额4:已交付5:还款中6:已完成)
	//备用字段
	@TableField("backup1")
	private  String backup1; 			// 备用字段1
	@TableField("backup2")
	private  String backup2; 			// 备用字段2
	public MarkInfo() {
		super();
	}
	
	public MarkInfo(Integer id, Integer userid, Integer applyforid, String headline, double money, Integer markid,
			double countmoney, double accrual, Integer refundtypeid, Integer paymentMode, double investmin,
			double investmax, String borrowtime, String purpose, Date deadline, Date starttime, String refundstart,
			double moneyaccrual, double moneybenjin, Integer overduestatus, String projectrating, String vcopinion,
			Integer vcopiniondj, Integer count, Integer struts, String backup1, String backup2) {
		super();
		this.id = id;
		this.userid = userid;
		this.applyforid = applyforid;
		this.headline = headline;
		this.money = money;
		this.markid = markid;
		this.countmoney = countmoney;
		this.accrual = accrual;
		this.refundtypeid = refundtypeid;
		this.paymentMode = paymentMode;
		this.investmin = investmin;
		this.investmax = investmax;
		this.borrowtime = borrowtime;
		this.purpose = purpose;
		this.deadline = deadline;
		this.starttime = starttime;
		this.refundstart = refundstart;
		this.moneyaccrual = moneyaccrual;
		this.moneybenjin = moneybenjin;
		this.overduestatus = overduestatus;
		this.projectrating = projectrating;
		this.vcopinion = vcopinion;
		this.vcopiniondj = vcopiniondj;
		this.count = count;
		this.struts = struts;
		this.backup1 = backup1;
		this.backup2 = backup2;
	}

	@Override
	public String toString() {
		return "MarkInfo [id=" + id + ", userid=" + userid + ", applyforid=" + applyforid + ", headline=" + headline
				+ ", money=" + money + ", markid=" + markid + ", countmoney=" + countmoney + ", accrual=" + accrual
				+ ", refundtypeid=" + refundtypeid + ", paymentMode=" + paymentMode + ", investmin=" + investmin
				+ ", investmax=" + investmax + ", borrowtime=" + borrowtime + ", purpose=" + purpose + ", deadline="
				+ deadline + ", starttime=" + starttime + ", refundstart=" + refundstart + ", moneyaccrual="
				+ moneyaccrual + ", moneybenjin=" + moneybenjin + ", overduestatus=" + overduestatus
				+ ", projectrating=" + projectrating + ", vcopinion=" + vcopinion + ", vcopiniondj=" + vcopiniondj
				+ ", count=" + count + ", struts=" + struts + ", backup1=" + backup1 + ", backup2=" + backup2 + "]";
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
	public Integer getApplyforid() {
		return applyforid;
	}
	public void setApplyforid(Integer applyforid) {
		this.applyforid = applyforid;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Integer getMarkid() {
		return markid;
	}
	public void setMarkid(Integer markid) {
		this.markid = markid;
	}
	public double getCountmoney() {
		return countmoney;
	}
	public void setCountmoney(double countmoney) {
		this.countmoney = countmoney;
	}
	public double getAccrual() {
		return accrual;
	}
	public void setAccrual(double accrual) {
		this.accrual = accrual;
	}
	public Integer getRefundtypeid() {
		return refundtypeid;
	}
	public void setRefundtypeid(Integer refundtypeid) {
		this.refundtypeid = refundtypeid;
	}
	public Integer getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(Integer paymentMode) {
		this.paymentMode = paymentMode;
	}
	public double getInvestmin() {
		return investmin;
	}
	public void setInvestmin(double investmin) {
		this.investmin = investmin;
	}
	public double getInvestmax() {
		return investmax;
	}
	public void setInvestmax(double investmax) {
		this.investmax = investmax;
	}
	public String getBorrowtime() {
		return borrowtime;
	}
	public void setBorrowtime(String borrowtime) {
		this.borrowtime = borrowtime;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public String getRefundstart() {
		return refundstart;
	}
	public void setRefundstart(String refundstart) {
		this.refundstart = refundstart;
	}
	public double getMoneyaccrual() {
		return moneyaccrual;
	}
	public void setMoneyaccrual(double moneyaccrual) {
		this.moneyaccrual = moneyaccrual;
	}
	public double getMoneybenjin() {
		return moneybenjin;
	}
	public void setMoneybenjin(double moneybenjin) {
		this.moneybenjin = moneybenjin;
	}
	public Integer getOverduestatus() {
		return overduestatus;
	}
	public void setOverduestatus(Integer overduestatus) {
		this.overduestatus = overduestatus;
	}
	public String getProjectrating() {
		return projectrating;
	}
	public void setProjectrating(String projectrating) {
		this.projectrating = projectrating;
	}
	public String getVcopinion() {
		return vcopinion;
	}
	public void setVcopinion(String vcopinion) {
		this.vcopinion = vcopinion;
	}
	public Integer getVcopiniondj() {
		return vcopiniondj;
	}
	public void setVcopiniondj(Integer vcopiniondj) {
		this.vcopiniondj = vcopiniondj;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getStruts() {
		return struts;
	}
	public void setStruts(Integer struts) {
		this.struts = struts;
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
	
}
