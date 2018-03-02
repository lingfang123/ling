package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class User implements Serializable{
	//用户表(t_user)
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//用户id
	
	@TableField("username")
	private String username;//用户名
	
	@TableField("password")
	private String password;//密码
	
	@TableField("nickname")
	private String nickname;//昵称
	
	@TableField("userimg")
	private String userimg;//头像
	
	@TableField("sex")
	private Integer sex;//性别 (0女1男)
	
	@TableField("age")
	private Integer age;//年龄
	
	@TableField("provinceID")
	private Integer provinceID;//省份id
	
	@TableField("cityID")
	private Integer cityID;//城市id
	
	@TableField("districtID")
	private Integer districtID;//地区id
	
	@TableField("phone")
	private String phone;//手机号
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;//注册时间
	
	@TableField("moneyid")
	private Integer moneyid;//用户钱包id
	
	@TableField("creditid")
	private Integer creditid;//用户信用id
	
	@TableField("vipid")
	private Integer vipid;//用户vip id
	
	@TableField("referrer")
	private String referrer;//推荐人
	
	@TableField("referrerm")
	private String referrerm;//推荐码
	
	@TableField("status")
	private Integer status;//状态
	
	@TableField("loginNumber")
	private Integer loginNumber;//登陆次数
	
	@TableField("lastIp")
	private String lastIp;//最后登陆时的ip
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date lastTime;//最后登陆的时间
	
	@TableField("areaIp")
	private String areaIp;//IP地址所属区域
	
	@TableField("birthday")
	private String birthday;	//生日
	
	//虚拟字段
	private String newPwd;		//新密码
	private String address;		//地址
	private String phoneYC;		//隐藏后的手机号
	
	private String pidName;		//省份名
	private String cidName;		//城市名
	private String didName;		//地区名
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String username, String password, String nickname, String userimg, Integer sex, Integer age,
			Integer provinceID, Integer cityID, Integer districtID, String phone, Date createTime, Integer moneyid,
			Integer creditid, Integer vipid, String referrer, String referrerm, Integer status, Integer loginNumber,
			String lastIp, Date lastTime, String areaIp, String birthday, String newPwd, String address, String phoneYC,
			String pidName, String cidName, String didName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.userimg = userimg;
		this.sex = sex;
		this.age = age;
		this.provinceID = provinceID;
		this.cityID = cityID;
		this.districtID = districtID;
		this.phone = phone;
		this.createTime = createTime;
		this.moneyid = moneyid;
		this.creditid = creditid;
		this.vipid = vipid;
		this.referrer = referrer;
		this.referrerm = referrerm;
		this.status = status;
		this.loginNumber = loginNumber;
		this.lastIp = lastIp;
		this.lastTime = lastTime;
		this.areaIp = areaIp;
		this.birthday = birthday;
		this.newPwd = newPwd;
		this.address = address;
		this.phoneYC = phoneYC;
		this.pidName = pidName;
		this.cidName = cidName;
		this.didName = didName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", userimg=" + userimg + ", sex=" + sex + ", age=" + age + ", provinceID=" + provinceID + ", cityID="
				+ cityID + ", districtID=" + districtID + ", phone=" + phone + ", createTime=" + createTime
				+ ", moneyid=" + moneyid + ", creditid=" + creditid + ", vipid=" + vipid + ", referrer=" + referrer
				+ ", referrerm=" + referrerm + ", status=" + status + ", loginNumber=" + loginNumber + ", lastIp="
				+ lastIp + ", lastTime=" + lastTime + ", areaIp=" + areaIp + ", birthday=" + birthday + ", newPwd="
				+ newPwd + ", address=" + address + ", phoneYC=" + phoneYC + ", pidName=" + pidName + ", cidName="
				+ cidName + ", didName=" + didName + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getUserimg() {
		return userimg;
	}
	public void setUserimg(String userimg) {
		this.userimg = userimg;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getMoneyid() {
		return moneyid;
	}
	public void setMoneyid(Integer moneyid) {
		this.moneyid = moneyid;
	}
	public Integer getCreditid() {
		return creditid;
	}
	public void setCreditid(Integer creditid) {
		this.creditid = creditid;
	}
	public Integer getVipid() {
		return vipid;
	}
	public void setVipid(Integer vipid) {
		this.vipid = vipid;
	}
	public String getReferrer() {
		return referrer;
	}
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}
	public String getReferrerm() {
		return referrerm;
	}
	public void setReferrerm(String referrerm) {
		this.referrerm = referrerm;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getLoginNumber() {
		return loginNumber;
	}
	public void setLoginNumber(Integer loginNumber) {
		this.loginNumber = loginNumber;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public String getAreaIp() {
		return areaIp;
	}
	public void setAreaIp(String areaIp) {
		this.areaIp = areaIp;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneYC() {
		return phoneYC;
	}
	public void setPhoneYC(String phoneYC) {
		this.phoneYC = phoneYC;
	}
	public String getPidName() {
		return pidName;
	}
	public void setPidName(String pidName) {
		this.pidName = pidName;
	}
	public String getCidName() {
		return cidName;
	}
	public void setCidName(String cidName) {
		this.cidName = cidName;
	}
	public String getDidName() {
		return didName;
	}
	public void setDidName(String didName) {
		this.didName = didName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}