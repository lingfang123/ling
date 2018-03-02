package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("t_company_zj")
public class CompanyZj implements Serializable{

	/**
	 * 公司证件表
	 */
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//主键
	@TableField("company_img")
	private String companyimg;//证件图片
	public CompanyZj() {}
	public CompanyZj(Integer id, String companyimg) {
		super();
		this.id = id;
		this.companyimg = companyimg;
	}
	@Override
	public String toString() {
		return "CompanyZj [id=" + id + ", companyimg=" + companyimg + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompanyimg() {
		return companyimg;
	}
	public void setCompanyimg(String companyimg) {
		this.companyimg = companyimg;
	}
}
