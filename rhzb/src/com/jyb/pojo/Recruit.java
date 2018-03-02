package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_recruit")
public class Recruit implements Serializable{
	/**
	 * 招贤纳士
	 */
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//主键
	@TableField("headline")
	private String headline;//标题
	@TableField("rejoin")
	private String rejoin;//回答
	@Override
	public String toString() {
		return "Recruit [id=" + id + ", headline=" + headline + ", rejoin=" + rejoin + "]";
	}
	public Recruit() {}
	public Recruit(Integer id, String headline, String rejoin) {
		this.id = id;
		this.headline = headline;
		this.rejoin = rejoin;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getRejoin() {
		return rejoin;
	}
	public void setRejoin(String rejoin) {
		this.rejoin = rejoin;
	}
}
