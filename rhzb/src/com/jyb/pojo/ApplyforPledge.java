package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_applyfor_pledge")
public class ApplyforPledge implements Serializable{

	/**
	 * 抵押物品表 t_applyfor_pledge
	 */
	private static final long serialVersionUID = 1L;
	private  Integer id; 				// 主键
	private  Integer applyforid; 		// 贷款申请表id(借款申请表 t_loans_applyfor)
	private  String goodname; 			// 抵押物品名称
	private  String imgurl; 			// 抵押物名称
	private  String detail; 			// 物品详细描述
	@TableField("verify_status")
	private  Integer verifystatus; 		// 核实状态(0:未核实1:已核实)
	private  Date hstime; 				// 时间
	//备用字段
	private String backup1 ; 			// 备用字段1
	private String backup2 ;			// 备用字段2
	public ApplyforPledge() {
		super();
	}
	public ApplyforPledge(Integer id, Integer applyforid, String goodname, String imgurl, String detail,
			Integer verifystatus, Date hstime, String backup1, String backup2) {
		super();
		this.id = id;
		this.applyforid = applyforid;
		this.goodname = goodname;
		this.imgurl = imgurl;
		this.detail = detail;
		this.verifystatus = verifystatus;
		this.hstime = hstime;
		this.backup1 = backup1;
		this.backup2 = backup2;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getApplyforid() {
		return applyforid;
	}
	public void setApplyforid(Integer applyforid) {
		this.applyforid = applyforid;
	}
	public String getGoodname() {
		return goodname;
	}
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Integer getVerifystatus() {
		return verifystatus;
	}
	public void setVerifystatus(Integer verifystatus) {
		this.verifystatus = verifystatus;
	}
	public Date getHstime() {
		return hstime;
	}
	public void setHstime(Date hstime) {
		this.hstime = hstime;
	}
	public String getBackup1() {
		return backup1;
	}
	public void setBackup1(String backup1) {
		this.backup1 = backup1;
	}
	public String getBackup2() {
		return backup2;
	}
	public void setBackup2(String backup2) {
		this.backup2 = backup2;
	}
	@Override
	public String toString() {
		return "ApplyforPledge [id=" + id + ", applyforid=" + applyforid + ", goodname=" + goodname + ", imgurl="
				+ imgurl + ", detail=" + detail + ", verifystatus=" + verifystatus + ", hstime=" + hstime + ", backup1="
				+ backup1 + ", backup2=" + backup2 + "]";
	}
	
}
