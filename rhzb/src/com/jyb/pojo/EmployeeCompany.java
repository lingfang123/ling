package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class EmployeeCompany implements Serializable{
	//员工表t_employee_company
	private static final long serialVersionUID = 1L;
	@TableId("emp_id")
	private Integer empid;//主键id
	@TableField("loginname")
	private String loginname;//登陆名
	@TableField("password")
	private String password;//登陆密码
	@TableField("nickname")
	private String nickname;//昵称
	@TableField("employeeImg")
	private String employeeImg;//头像
	@TableField("empname")
	private String empname;//真是姓名
	@TableField("identityCard")
	private String identityCard;//身份证号
	@TableField("empimg")
	private String empimg;//在职照片
	@TableField("sex")
	private Integer sex;//性别
	@TableField("age")
	private Integer age;//年龄
	@TableField("qq")
	private String qq;//qq号
	@TableField("phone")
	private String phone;//手机号码
	@TableField("email")
	private String email;//邮箱
	@TableField("roleid")
	private Integer roleid;//权限
	@TableField("worktime")
	private String worktime;//创建时间
	@TableField("status")
	private Integer status;//状态(1在职,2离职)
	@TableField("remark")
	private String remark;//备注
	@TableField("lastip")
	private String lastip;//最后登陆ip
	@TableField("lasttime")
	private String lasttime;//最后登陆时间
	@Override
	public String toString() {
		return "EmployeeCompany [empid=" + empid + ", loginname=" + loginname + ", password=" + password + ", nickname="
				+ nickname + ", employeeImg=" + employeeImg + ", empname=" + empname + ", identityCard=" + identityCard
				+ ", empimg=" + empimg + ", sex=" + sex + ", age=" + age + ", qq=" + qq + ", phone=" + phone
				+ ", email=" + email + ", roleid=" + roleid + ", worktime=" + worktime + ", status=" + status
				+ ", remark=" + remark + ", lastip=" + lastip + ", lasttime=" + lasttime + "]";
	}
	public EmployeeCompany() {}
	public EmployeeCompany(Integer empid, String loginname, String password, String nickname, String employeeImg,
			String empname, String identityCard, String empimg, Integer sex, Integer age, String qq, String phone,
			String email, Integer roleid, String worktime, Integer status, String remark, String lastip,
			String lasttime) {
		super();
		this.loginname = loginname;
		this.password = password;
		this.nickname = nickname;
		this.employeeImg = employeeImg;
		this.empname = empname;
		this.identityCard = identityCard;
		this.empimg = empimg;
		this.sex = sex;
		this.age = age;
		this.qq = qq;
		this.phone = phone;
		this.email = email;
		this.roleid = roleid;
		this.worktime = worktime;
		this.status = status;
		this.remark = remark;
		this.lastip = lastip;
		this.lasttime = lasttime;
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmployeeImg() {
		return employeeImg;
	}
	public void setEmployeeImg(String employeeImg) {
		this.employeeImg = employeeImg;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getIdentityCard() {
		return identityCard;
	}
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}
	public String getEmpimg() {
		return empimg;
	}
	public void setEmpimg(String empimg) {
		this.empimg = empimg;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getWorktime() {
		return worktime;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLastip() {
		return lastip;
	}
	public void setLastip(String lastip) {
		this.lastip = lastip;
	}
	public String getLasttime() {
		return lasttime;
	}
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
