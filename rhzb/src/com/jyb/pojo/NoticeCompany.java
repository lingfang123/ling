package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class NoticeCompany implements Serializable{
	//平台公告表t_notice_company
	private static final long serialVersionUID = 1L;
	@TableId("n_id")
	private Integer nid;//主键id
	@TableField("newsname")
	private String newsname;//标题
	@TableField("url")
	private String url;//链接
	@TableField("content")
	private String content;//内容
	@TableField("type")
	private Integer type;//类型（0新闻1公告）
	@TableField("createtime")
	private String createtime;//创建时间
	@TableField("status")
	private Integer status;//状态
	@TableField("empid")
	private String empid;//发布人
	@Override
	public String toString() {
		return "NoticeCompany [nid=" + nid + ", newsname=" + newsname + ", url=" + url + ", content=" + content
				+ ", type=" + type + ", createtime=" + createtime + ", status=" + status + ", empid=" + empid + "]";
	}
	public NoticeCompany() {}
	public NoticeCompany(Integer nid, String newsname, String url, String content, Integer type, String createtime,
			Integer status, String empid) {
		this.nid = nid;
		this.newsname = newsname;
		this.url = url;
		this.content = content;
		this.type = type;
		this.createtime = createtime;
		this.status = status;
		this.empid = empid;
	}
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getNewsname() {
		return newsname;
	}
	public void setNewsname(String newsname) {
		this.newsname = newsname;
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
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
