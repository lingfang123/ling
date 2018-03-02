package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("t_information")
public class Information implements Serializable{

	/**
	 * 组织信息表
	 */
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//主键
	@TableField("companyname")
	private String companyname;//公司全称
	@TableField("abbreviation")
	private String abbreviation;//公司简称
	@TableField("creditnumber")
	private String creditnumber;//统一社会信用代码
	@TableField("zc_fund")
	private Float zcfund;//注册资金
	@TableField("sj_fund")
	private Float sjfund;//实缴注册资金
	@TableField("zc_address")
	private String zcaddress;//注册地址
	@TableField("manage_address")
	private String manageaddress;//经营地址
	@TableField("createtime")
	private String createtime;//成立时间
	@TableField("manage_deadline")
	private String managedeadline;//经营期限
	@TableField("status")
	private Integer status;//经营状态
	@TableField("legal_person")
	private String legalperson;//法人代表
	@TableField("scope")
	private String scope;//经营范围
	public Information() {}
	public Information(Integer id, String companyname, String abbreviation, String creditnumber, Float zcfund,
			Float sjfund, String zcaddress, String manageaddress, String createtime, String managedeadline,
			Integer status, String legalperson, String scope) {
		this.id = id;
		this.companyname = companyname;
		this.abbreviation = abbreviation;
		this.creditnumber = creditnumber;
		this.zcfund = zcfund;
		this.sjfund = sjfund;
		this.zcaddress = zcaddress;
		this.manageaddress = manageaddress;
		this.createtime = createtime;
		this.managedeadline = managedeadline;
		this.status = status;
		this.legalperson = legalperson;
		this.scope = scope;
	}
	@Override
	public String toString() {
		return "Information [id=" + id + ", companyname=" + companyname + ", abbreviation=" + abbreviation
				+ ", creditnumber=" + creditnumber + ", zcfund=" + zcfund + ", sjfund=" + sjfund + ", zcaddress="
				+ zcaddress + ", manageaddress=" + manageaddress + ", createtime=" + createtime + ", managedeadline="
				+ managedeadline + ", status=" + status + ", legalperson=" + legalperson + ", scope=" + scope + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getCreditnumber() {
		return creditnumber;
	}
	public void setCreditnumber(String creditnumber) {
		this.creditnumber = creditnumber;
	}
	public Float getZcfund() {
		return zcfund;
	}
	public void setZcfund(Float zcfund) {
		this.zcfund = zcfund;
	}
	public Float getSjfund() {
		return sjfund;
	}
	public void setSjfund(Float sjfund) {
		this.sjfund = sjfund;
	}
	public String getZcaddress() {
		return zcaddress;
	}
	public void setZcaddress(String zcaddress) {
		this.zcaddress = zcaddress;
	}
	public String getManageaddress() {
		return manageaddress;
	}
	public void setManageaddress(String manageaddress) {
		this.manageaddress = manageaddress;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getManagedeadline() {
		return managedeadline;
	}
	public void setManagedeadline(String managedeadline) {
		this.managedeadline = managedeadline;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getLegalperson() {
		return legalperson;
	}
	public void setLegalperson(String legalperson) {
		this.legalperson = legalperson;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
}
