package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableName;
@TableName("t_applyfor_credit")
public class ApplyforCredit implements Serializable{

	/**
	 * 贷款申请(信用标)信息表 t_applyfor_credit
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id; 				//主键
	private Integer applyforid; 		//贷款申请表id(借款申请表 t_loans_applyfor)
	//家庭信息
	private Integer marriage; 			//婚姻状况(0:已婚，1:未婚，2:离异)
	private Integer children;			//有无子女(0:无子女，1:有子女)
	private String directname; 			//直系亲属姓名
	private String directrelation; 		//直系关系
	private String directphone; 		//直系手机号码
	private String qtname;				//其他联系人姓名
	private String qtphone;				//其他联系人手机号码
	//工作信息
	private String professionzt; 		//职业状态
	private String unitsname; 			//单位名称
	private String postname; 			//职位
	private float monthlyincome; 		//月收入
	private String email; 				//工作邮箱
	private Integer provinceID; 		//工作省份
	private Integer cityID; 			//工作城市
	private Integer districtID; 		//县/区
	private String address; 			//公司地址
	//资产信息
	private Integer possesshouse; 		//是否有房(0:无房，1:有房)
	private Integer loanshouse; 		//有无房贷(0:无房贷，1:有房贷)
	private Integer possesscar; 		//是否有车(0:无车，1:有车)
	private Integer loanscar; 			//有无车贷(0:无车贷，1:有车贷)
	//资料上传
	//必须上传
	private String identitycardimg; 	//身份证照片
	private String employeecardimg; 	//工作证照片
	private String incomecardimg; 		//收入证明照片
	//可选上传
	private String houseimg;			//房产证照片
	private String carimg; 				//购车证照片
	private String educationimg; 		//学历证照片
	//备用字段
	private String backup1; 			//备用字段1
	private String backup2; 			//备用字段2
	
	public ApplyforCredit() {
		super();
	}
	public ApplyforCredit(Integer id, Integer applyforid, Integer marriage, Integer children, String directname,
			String directrelation, String directphone, String qtname, String qtphone, String professionzt,
			String unitsname, String postname, float monthlyincome, String email, Integer provinceID, Integer cityID,
			Integer districtID, String address, Integer possesshouse, Integer loanshouse, Integer possesscar,
			Integer loanscar, String identitycardimg, String employeecardimg, String incomecardimg, String houseimg,
			String carimg, String educationimg, String backup1, String backup2) {
		super();
		this.id = id;
		this.applyforid = applyforid;
		this.marriage = marriage;
		this.children = children;
		this.directname = directname;
		this.directrelation = directrelation;
		this.directphone = directphone;
		this.qtname = qtname;
		this.qtphone = qtphone;
		this.professionzt = professionzt;
		this.unitsname = unitsname;
		this.postname = postname;
		this.monthlyincome = monthlyincome;
		this.email = email;
		this.provinceID = provinceID;
		this.cityID = cityID;
		this.districtID = districtID;
		this.address = address;
		this.possesshouse = possesshouse;
		this.loanshouse = loanshouse;
		this.possesscar = possesscar;
		this.loanscar = loanscar;
		this.identitycardimg = identitycardimg;
		this.employeecardimg = employeecardimg;
		this.incomecardimg = incomecardimg;
		this.houseimg = houseimg;
		this.carimg = carimg;
		this.educationimg = educationimg;
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
	public Integer getMarriage() {
		return marriage;
	}
	public void setMarriage(Integer marriage) {
		this.marriage = marriage;
	}
	public Integer getChildren() {
		return children;
	}
	public void setChildren(Integer children) {
		this.children = children;
	}
	public String getDirectname() {
		return directname;
	}
	public void setDirectname(String directname) {
		this.directname = directname;
	}
	public String getDirectrelation() {
		return directrelation;
	}
	public void setDirectrelation(String directrelation) {
		this.directrelation = directrelation;
	}
	public String getDirectphone() {
		return directphone;
	}
	public void setDirectphone(String directphone) {
		this.directphone = directphone;
	}
	public String getQtname() {
		return qtname;
	}
	public void setQtname(String qtname) {
		this.qtname = qtname;
	}
	public String getQtphone() {
		return qtphone;
	}
	public void setQtphone(String qtphone) {
		this.qtphone = qtphone;
	}
	public String getProfessionzt() {
		return professionzt;
	}
	public void setProfessionzt(String professionzt) {
		this.professionzt = professionzt;
	}
	public String getUnitsname() {
		return unitsname;
	}
	public void setUnitsname(String unitsname) {
		this.unitsname = unitsname;
	}
	public String getPostname() {
		return postname;
	}
	public void setPostname(String postname) {
		this.postname = postname;
	}
	public float getMonthlyincome() {
		return monthlyincome;
	}
	public void setMonthlyincome(float monthlyincome) {
		this.monthlyincome = monthlyincome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getProvinceID() {
		return provinceID;
	}
	public void setProvinceID(Integer provinceID) {
		this.provinceID = provinceID;
	}
	public Integer getCityID() {
		return cityID;
	}
	public void setCityID(Integer cityID) {
		this.cityID = cityID;
	}
	public Integer getDistrictID() {
		return districtID;
	}
	public void setDistrictID(Integer districtID) {
		this.districtID = districtID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPossesshouse() {
		return possesshouse;
	}
	public void setPossesshouse(Integer possesshouse) {
		this.possesshouse = possesshouse;
	}
	public Integer getLoanshouse() {
		return loanshouse;
	}
	public void setLoanshouse(Integer loanshouse) {
		this.loanshouse = loanshouse;
	}
	public Integer getPossesscar() {
		return possesscar;
	}
	public void setPossesscar(Integer possesscar) {
		this.possesscar = possesscar;
	}
	public Integer getLoanscar() {
		return loanscar;
	}
	public void setLoanscar(Integer loanscar) {
		this.loanscar = loanscar;
	}
	public String getIdentitycardimg() {
		return identitycardimg;
	}
	public void setIdentitycardimg(String identitycardimg) {
		this.identitycardimg = identitycardimg;
	}
	public String getEmployeecardimg() {
		return employeecardimg;
	}
	public void setEmployeecardimg(String employeecardimg) {
		this.employeecardimg = employeecardimg;
	}
	public String getIncomecardimg() {
		return incomecardimg;
	}
	public void setIncomecardimg(String incomecardimg) {
		this.incomecardimg = incomecardimg;
	}
	public String getHouseimg() {
		return houseimg;
	}
	public void setHouseimg(String houseimg) {
		this.houseimg = houseimg;
	}
	public String getCarimg() {
		return carimg;
	}
	public void setCarimg(String carimg) {
		this.carimg = carimg;
	}
	public String getEducationimg() {
		return educationimg;
	}
	public void setEducationimg(String educationimg) {
		this.educationimg = educationimg;
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
		return "ApplyforCredit [id=" + id + ", applyforid=" + applyforid + ", marriage=" + marriage + ", children="
				+ children + ", directname=" + directname + ", directrelation=" + directrelation + ", directphone="
				+ directphone + ", qtname=" + qtname + ", qtphone=" + qtphone + ", professionzt=" + professionzt
				+ ", unitsname=" + unitsname + ", postname=" + postname + ", monthlyincome=" + monthlyincome
				+ ", email=" + email + ", provinceID=" + provinceID + ", cityID=" + cityID + ", districtID="
				+ districtID + ", address=" + address + ", possesshouse=" + possesshouse + ", loanshouse=" + loanshouse
				+ ", possesscar=" + possesscar + ", loanscar=" + loanscar + ", identitycardimg=" + identitycardimg
				+ ", employeecardimg=" + employeecardimg + ", incomecardimg=" + incomecardimg + ", houseimg=" + houseimg
				+ ", carimg=" + carimg + ", educationimg=" + educationimg + ", backup1=" + backup1 + ", backup2="
				+ backup2 + "]";
	}
	
	
}
