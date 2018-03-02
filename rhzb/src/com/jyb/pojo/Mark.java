package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_mark")
public class Mark implements Serializable {
	//标型表
	private static final long serialVersionUID = 1L;
	@TableField("id")//主键
	private Integer id;
	@TableField("markname")//标的名称
	private String markname;
	@TableField("remark")//说明
	private String remark;
	@TableField("bychar")//备用字段1
	private String bychar;
	@TableField("bystr")//备用字段2
	private String bystr;
	public Mark() {
		super();
	}
	public Mark(Integer id, String markname, String remark, String bychar, String bystr) {
		super();
		this.id = id;
		this.markname = markname;
		this.remark = remark;
		this.bychar = bychar;
		this.bystr = bystr;
	}
	@Override
	public String toString() {
		return "Mark [id=" + id + ", markname=" + markname + ", remark=" + remark + ", bychar=" + bychar + ", bystr="
				+ bystr + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMarkname() {
		return markname;
	}
	public void setMarkname(String markname) {
		this.markname = markname;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	
}
