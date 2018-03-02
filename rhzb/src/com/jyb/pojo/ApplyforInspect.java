package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_applyfor_inspect")
public class ApplyforInspect implements Serializable{

	/**
	 * 贷款申请(实地考察标)信息表 t_applyfor_inspect
	 */
	private static final long serialVersionUID = 1L;
	private  Integer id; 				// 主键
	private  Integer applyforid; 		// 贷款申请表id(借款申请表 t_loans_applyfor)
	private  String swname; 			// 实物名称
	private  String swpinpai; 			// 品牌
	private  Date kctime; 				// 考察时间
	private  String inspectimg1; 		// 考察图片1
	private  String inspectimg2; 		// 考察图片2
	private  String inspectimg3;		// 考察图片3
	private  String inspectimg4; 		// 考察图片4
	private  String inspectimg5; 		// 考察图片5
	private  Integer struts; 			// 状态(1:有效，0:无效)
	//备用字段
	private  String backup1; 			// 备用字段1
	private  String backup2;			// 备用字段2
	public ApplyforInspect() {
		super();
	}
	public ApplyforInspect(Integer id, Integer applyforid, String swname, String swpinpai, Date kctime,
			String inspectimg1, String inspectimg2, String inspectimg3, String inspectimg4, String inspectimg5,
			Integer struts, String backup1, String backup2) {
		super();
		this.id = id;
		this.applyforid = applyforid;
		this.swname = swname;
		this.swpinpai = swpinpai;
		this.kctime = kctime;
		this.inspectimg1 = inspectimg1;
		this.inspectimg2 = inspectimg2;
		this.inspectimg3 = inspectimg3;
		this.inspectimg4 = inspectimg4;
		this.inspectimg5 = inspectimg5;
		this.struts = struts;
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
	public String getSwname() {
		return swname;
	}
	public void setSwname(String swname) {
		this.swname = swname;
	}
	public String getSwpinpai() {
		return swpinpai;
	}
	public void setSwpinpai(String swpinpai) {
		this.swpinpai = swpinpai;
	}
	public Date getKctime() {
		return kctime;
	}
	public void setKctime(Date kctime) {
		this.kctime = kctime;
	}
	public String getInspectimg1() {
		return inspectimg1;
	}
	public void setInspectimg1(String inspectimg1) {
		this.inspectimg1 = inspectimg1;
	}
	public String getInspectimg2() {
		return inspectimg2;
	}
	public void setInspectimg2(String inspectimg2) {
		this.inspectimg2 = inspectimg2;
	}
	public String getInspectimg3() {
		return inspectimg3;
	}
	public void setInspectimg3(String inspectimg3) {
		this.inspectimg3 = inspectimg3;
	}
	public String getInspectimg4() {
		return inspectimg4;
	}
	public void setInspectimg4(String inspectimg4) {
		this.inspectimg4 = inspectimg4;
	}
	public String getInspectimg5() {
		return inspectimg5;
	}
	public void setInspectimg5(String inspectimg5) {
		this.inspectimg5 = inspectimg5;
	}
	public Integer getStruts() {
		return struts;
	}
	public void setStruts(Integer struts) {
		this.struts = struts;
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
		return "ApplyforInspect [id=" + id + ", applyforid=" + applyforid + ", swname=" + swname + ", swpinpai="
				+ swpinpai + ", kctime=" + kctime + ", inspectimg1=" + inspectimg1 + ", inspectimg2=" + inspectimg2
				+ ", inspectimg3=" + inspectimg3 + ", inspectimg4=" + inspectimg4 + ", inspectimg5=" + inspectimg5
				+ ", struts=" + struts + ", backup1=" + backup1 + ", backup2=" + backup2 + "]";
	}
	
	
}
