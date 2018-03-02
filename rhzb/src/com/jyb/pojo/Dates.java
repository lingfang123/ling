package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class Dates implements Serializable{
	//平台数据表t_date
	private static final long serialVersionUID = 1L;
	@TableId("d_id")
	private Integer did;//主键id
	@TableField("d_name")
	private String dname;//标题
	@TableField("d_img")
	private String dimg;//图片
	@TableField("type")
	private Integer type;//类型（0轮播图，1.友情链接）
	@TableField("createtime")
	private String createtime;//创建时间
	@TableField("status")
	private Integer status;//状态（0无效1有效）
	@TableField("empid")
	private String empid;//发布人
	@Override
	public String toString() {
		return "Date [did=" + did + ", dname=" + dname + ", dimg=" + dimg + ", type=" + type + ", createtime="
				+ createtime + ", status=" + status + ", empid=" + empid + "]";
	}
	public Dates() {}
	public Dates(Integer did, String dname, String dimg, Integer type, String createtime, Integer status, String empid) {
		this.did = did;
		this.dname = dname;
		this.dimg = dimg;
		this.type = type;
		this.createtime = createtime;
		this.status = status;
		this.empid = empid;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDimg() {
		return dimg;
	}
	public void setDimg(String dimg) {
		this.dimg = dimg;
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
