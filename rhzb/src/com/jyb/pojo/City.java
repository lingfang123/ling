package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class City implements Serializable{
	//城市表t_city
	private static final long serialVersionUID = 1L;
	@TableId("c_id")
	private Integer cid;//城市id主键
	@TableField("cityName")
	private String cityName;//城市名称
	@TableField("provinceID")
	private Integer provinceID;//省份id
	@Override
	public String toString() {
		return "City [cid=" + cid + ", cityName=" + cityName + ", provinceID=" + provinceID + "]";
	}
	public City() {}
	public City(Integer cid, String cityName, Integer provinceID) {
		this.cid = cid;
		this.cityName = cityName;
		this.provinceID = provinceID;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Integer getProvinceID() {
		return provinceID;
	}
	public void setProvinceID(Integer provinceID) {
		this.provinceID = provinceID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
