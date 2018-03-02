package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_permission")
public class Permission implements Serializable{

	/**
	 * 树节点/按钮表
	 */
	private static final long serialVersionUID = 1L;
	@TableId("p_id")
	private Integer pid;//主键
	@TableField("p_name")
	private String pname;//资源名称
	@TableField("type")
	private Integer type;//资源类型：menubutton
	@TableField("url")
	private String url;//访问url地址
	@TableField("percode")
	private String percode;//权限代码字符串
	@TableField("parentid")
	private Integer parentid;//父结点id
	@TableField("available")
	private Integer available;//是否可用1：可用，0不可用
	public Permission() {}
	public Permission(Integer pid, String pname, Integer type, String url, String percode, Integer parentid,
			Integer available) {
		this.pid = pid;
		this.pname = pname;
		this.type = type;
		this.url = url;
		this.percode = percode;
		this.parentid = parentid;
		this.available = available;
	}
	@Override
	public String toString() {
		return "Permission [pid=" + pid + ", pname=" + pname + ", type=" + type + ", url=" + url + ", percode="
				+ percode + ", parentid=" + parentid + ", available=" + available + "]";
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPercode() {
		return percode;
	}
	public void setPercode(String percode) {
		this.percode = percode;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public Integer getAvailable() {
		return available;
	}
	public void setAvailable(Integer available) {
		this.available = available;
	}
}
