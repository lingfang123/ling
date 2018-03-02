package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("t_company")
public class Company implements Serializable{

	/**
	 * 公司简介表
	 */
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//主键
	@TableField("hendname")
	private String hendname;//标题
	@TableField("context")
	private String context;//简介
	public Company() {}
	public Company(Integer id, String hendname, String context) {
		this.id = id;
		this.hendname = hendname;
		this.context = context;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHendname() {
		return hendname;
	}
	public void setHendname(String hendname) {
		this.hendname = hendname;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", hendname=" + hendname + ", context=" + context + "]";
	}
}
