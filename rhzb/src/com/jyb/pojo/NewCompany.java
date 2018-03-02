package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_new_company")
public class NewCompany implements Serializable{
//新闻
	private static final long serialVersionUID = 1L;
	
	@TableField("new_id")//主键
	private Integer newid;
	@TableField("newtitle")//新闻标题
	private String newtitle;
	@TableField("newimage")//新闻图片
	private String newimage;
	@TableField("url")//URL地址
	private String url;
	@TableField("content")//新闻内容
	private String content;
	@TableField("type")//类型(网站新闻1行业新闻2媒体新闻3)
	private Integer type;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//创建时间
	private Date createtime;
	@TableField("status")//状态(有效1无效0)
	private Integer status;
	@TableField("empid")//发布人id
	private Integer empid;
	@TableField("bychar")//备用字段1
	private String bychar;
	@TableField("bystr")//备用字段2
	private String bystr;
	
	//
	private EmployeeCompany employeeCompany;
	
	public NewCompany() {
		super();
	}

	public NewCompany(Integer newid, String newtitle, String newimage, String url, String content, Integer type,
			Date createtime, Integer status, Integer empid, String bychar, String bystr,
			EmployeeCompany employeeCompany) {
		super();
		this.newid = newid;
		this.newtitle = newtitle;
		this.newimage = newimage;
		this.url = url;
		this.content = content;
		this.type = type;
		this.createtime = createtime;
		this.status = status;
		this.empid = empid;
		this.bychar = bychar;
		this.bystr = bystr;
		this.employeeCompany = employeeCompany;
	}

	@Override
	public String toString() {
		return "NewCompany [newid=" + newid + ", newtitle=" + newtitle + ", newimage=" + newimage + ", url=" + url
				+ ", content=" + content + ", type=" + type + ", createtime=" + createtime + ", status=" + status
				+ ", empid=" + empid + ", bychar=" + bychar + ", bystr=" + bystr + ", employeeCompany="
				+ employeeCompany + "]";
	}

	public Integer getNewid() {
		return newid;
	}

	public void setNewid(Integer newid) {
		this.newid = newid;
	}

	public String getNewtitle() {
		return newtitle;
	}

	public void setNewtitle(String newtitle) {
		this.newtitle = newtitle;
	}

	public String getNewimage() {
		return newimage;
	}

	public void setNewimage(String newimage) {
		this.newimage = newimage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
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

	public EmployeeCompany getEmployeeCompany() {
		return employeeCompany;
	}

	public void setEmployeeCompany(EmployeeCompany employeeCompany) {
		this.employeeCompany = employeeCompany;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
