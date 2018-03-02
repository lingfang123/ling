package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_relation_us")
public class RelationUs implements Serializable{

	/**
	 * 联系我们
	 */
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//主键
	@TableField("gs_site")
	private String gssite;//公司地址
	@TableField("gs_number")
	private String gsnumber;//公司电话
	@TableField("dawk_number")
	private String dawknumber;//邮政编码
	@TableField("servicenumber")
	private String servicenumber;//客服电话
	@TableField("email")
	private String email;//客服邮箱
	@TableField("servetime")
	private String servetime;//客服服务时间
	@TableField("hz_email")
	private String hzemail;//商务合作邮箱
	@TableField("hz_name")
	private String hzname;//商务合作联系人
	@TableField("mt_email")
	private String mtemail;//媒体采访联系邮箱
	@TableField("mt_name")
	private String mtname;//媒体采访联系人
	@TableField("recruit_email")
	private String recruitemail;//招聘邮箱
	@TableField("recruit_name")
	private String recruitname;//招聘联系人姓名
	@TableField("company_coord")
	private String companycoord;//公司坐标
	public RelationUs() {}
	public RelationUs(Integer id, String gssite, String gsnumber, String dawknumber, String servicenumber, String email,
			String servetime, String hzemail, String hzname, String mtemail, String mtname, String recruitemail,
			String recruitname, String companycoord) {
		this.id = id;
		this.gssite = gssite;
		this.gsnumber = gsnumber;
		this.dawknumber = dawknumber;
		this.servicenumber = servicenumber;
		this.email = email;
		this.servetime = servetime;
		this.hzemail = hzemail;
		this.hzname = hzname;
		this.mtemail = mtemail;
		this.mtname = mtname;
		this.recruitemail = recruitemail;
		this.recruitname = recruitname;
		this.companycoord = companycoord;
	}
	@Override
	public String toString() {
		return "RelationUs [id=" + id + ", gssite=" + gssite + ", gsnumber=" + gsnumber + ", dawknumber=" + dawknumber
				+ ", servicenumber=" + servicenumber + ", email=" + email + ", servetime=" + servetime + ", hzemail="
				+ hzemail + ", hzname=" + hzname + ", mtemail=" + mtemail + ", mtname=" + mtname + ", recruitemail="
				+ recruitemail + ", recruitname=" + recruitname + ", companycoord=" + companycoord + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGssite() {
		return gssite;
	}
	public void setGssite(String gssite) {
		this.gssite = gssite;
	}
	public String getGsnumber() {
		return gsnumber;
	}
	public void setGsnumber(String gsnumber) {
		this.gsnumber = gsnumber;
	}
	public String getDawknumber() {
		return dawknumber;
	}
	public void setDawknumber(String dawknumber) {
		this.dawknumber = dawknumber;
	}
	public String getServicenumber() {
		return servicenumber;
	}
	public void setServicenumber(String servicenumber) {
		this.servicenumber = servicenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getServetime() {
		return servetime;
	}
	public void setServetime(String servetime) {
		this.servetime = servetime;
	}
	public String getHzemail() {
		return hzemail;
	}
	public void setHzemail(String hzemail) {
		this.hzemail = hzemail;
	}
	public String getHzname() {
		return hzname;
	}
	public void setHzname(String hzname) {
		this.hzname = hzname;
	}
	public String getMtemail() {
		return mtemail;
	}
	public void setMtemail(String mtemail) {
		this.mtemail = mtemail;
	}
	public String getMtname() {
		return mtname;
	}
	public void setMtname(String mtname) {
		this.mtname = mtname;
	}
	public String getRecruitemail() {
		return recruitemail;
	}
	public void setRecruitemail(String recruitemail) {
		this.recruitemail = recruitemail;
	}
	public String getRecruitname() {
		return recruitname;
	}
	public void setRecruitname(String recruitname) {
		this.recruitname = recruitname;
	}
	public String getCompanycoord() {
		return companycoord;
	}
	public void setCompanycoord(String companycoord) {
		this.companycoord = companycoord;
	}
}
