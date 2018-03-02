package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("t_shareholder")
public class Shareholder implements Serializable{

	/**
	 * 股东信息表
	 */
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//主键
	@TableField("name")
	private String name;//股东姓名
	@TableField("companyname")
	private String companyname;//股东背景
	@TableField("holdings")
	private Float holdings;//持股份额
	@TableField("cz_money")
	private Float cz_money;//出资金额
	public Shareholder() {}
	public Shareholder(Integer id, String name, String companyname, Float holdings, Float cz_money) {
		this.id = id;
		this.name = name;
		this.companyname = companyname;
		this.holdings = holdings;
		this.cz_money = cz_money;
	}
	@Override
	public String toString() {
		return "Shareholder [id=" + id + ", name=" + name + ", companyname=" + companyname + ", holdings=" + holdings
				+ ", cz_money=" + cz_money + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public Float getHoldings() {
		return holdings;
	}
	public void setHoldings(Float holdings) {
		this.holdings = holdings;
	}
	public Float getCz_money() {
		return cz_money;
	}
	public void setCz_money(Float cz_money) {
		this.cz_money = cz_money;
	}
}
