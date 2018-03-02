package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_law")
public class Law implements Serializable{

	/**
	 * 与法律有关
	 */
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//主键
	@TableField("style")
	private Integer style;//类型（法律政策 ；法律声明；资费说明）
	@TableField("name")
	private String name;//问题
	@TableField("rejoin")
	private String rejoin;//回答
	public Law() {}
	public Law(Integer id, Integer style, String name, String rejoin) {
		this.id = id;
		this.style = style;
		this.name = name;
		this.rejoin = rejoin;
	}
	@Override
	public String toString() {
		return "Law [id=" + id + ", style=" + style + ", name=" + name + ", rejoin=" + rejoin + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStyle() {
		return style;
	}
	public void setStyle(Integer style) {
		this.style = style;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRejoin() {
		return rejoin;
	}
	public void setRejoin(String rejoin) {
		this.rejoin = rejoin;
	}
}
