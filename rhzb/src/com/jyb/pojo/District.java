package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
public class District implements Serializable{
	//地区表t_district
	private static final long serialVersionUID = 1L;
	@TableId("d_id")
	private Integer did;//地区id
	@TableField("districtName")
	private String districtName;//地区名称
	@TableField("cityID")
	private Integer cityID;//城市id
	@Override
	public String toString() {
		return "District [did=" + did + ", districtName=" + districtName + ", cityID=" + cityID + "]";
	}
	public District() {}
	public District(Integer did, String districtName, Integer cityID) {
		this.did = did;
		this.districtName = districtName;
		this.cityID = cityID;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	public Integer getCityID() {
		return cityID;
	}
	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
