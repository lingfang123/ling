package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class UserInfo implements Serializable{
	//用户安全信息表t_user_info
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//
	
	@TableField("userid")
	private Integer userid;//用户id
	
	@TableField("name")
	private String name;//真实姓名
	
	@TableField("namestatus")
	private Integer namestatus;//真实姓名认证状态（1.已认证,0.未认证,3.审核中，4.认证未通过)
	
	@TableField("check1")
	private Integer check1;//审核人(管理员id)
	
	@TableField("identityCard")
	private String identityCard;//身份证
	
	@TableField("cardstatus")
	private Integer cardstatus;//身份证认证状态（0.未认证，1.已认证，3.审核中，4.认证未通过）
	
	@TableField("check2")
	private Integer check2;//审核人（管理员id）
	
	@TableField("dealPassword")
	private String dealPassword;//交易密码
	
	@TableField("dealPassstatus")
	private Integer dealPassstatus;//状态（0.未设置，1.已设置）
	
	@TableField("email")
	private String email;//邮箱
	
	@TableField("emailstatus")
	private Integer emailstatus;//邮箱认证状态（1.已认证，0.未认证）
	
	@TableField("exitgencyname")
	private String exitgencyname;//紧急联系人姓名
	
	@TableField("exitgencyphone")
	private String exitgencyphone;//紧急联系人号码
	
	@TableField("exitgencystatus")
	private Integer exitgencystatus;//状态（1.已登记，0.未登记）
	
	@TableField("openAccount")
	private String openAccount;	//开户账号
	
	//虚拟字段
	private String newEmail;	//新邮箱
	private String newdealpwd;	//新的交易密码
	private String emailYC;		//隐藏的邮箱
	
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}

	public UserInfo(Integer id, Integer userid, String name, Integer namestatus, Integer check1, String identityCard,
			Integer cardstatus, Integer check2, String dealPassword, Integer dealPassstatus, String email,
			Integer emailstatus, String exitgencyname, String exitgencyphone, Integer exitgencystatus,
			String openAccount, String newEmail, String newdealpwd, String emailYC) {
		super();
		this.id = id;
		this.userid = userid;
		this.name = name;
		this.namestatus = namestatus;
		this.check1 = check1;
		this.identityCard = identityCard;
		this.cardstatus = cardstatus;
		this.check2 = check2;
		this.dealPassword = dealPassword;
		this.dealPassstatus = dealPassstatus;
		this.email = email;
		this.emailstatus = emailstatus;
		this.exitgencyname = exitgencyname;
		this.exitgencyphone = exitgencyphone;
		this.exitgencystatus = exitgencystatus;
		this.openAccount = openAccount;
		this.newEmail = newEmail;
		this.newdealpwd = newdealpwd;
		this.emailYC = emailYC;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userid=" + userid + ", name=" + name + ", namestatus=" + namestatus
				+ ", check1=" + check1 + ", identityCard=" + identityCard + ", cardstatus=" + cardstatus + ", check2="
				+ check2 + ", dealPassword=" + dealPassword + ", dealPassstatus=" + dealPassstatus + ", email=" + email
				+ ", emailstatus=" + emailstatus + ", exitgencyname=" + exitgencyname + ", exitgencyphone="
				+ exitgencyphone + ", exitgencystatus=" + exitgencystatus + ", openAccount=" + openAccount
				+ ", newEmail=" + newEmail + ", newdealpwd=" + newdealpwd + ", emailYC=" + emailYC + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNamestatus() {
		return namestatus;
	}

	public void setNamestatus(Integer namestatus) {
		this.namestatus = namestatus;
	}

	public Integer getCheck1() {
		return check1;
	}

	public void setCheck1(Integer check1) {
		this.check1 = check1;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public Integer getCardstatus() {
		return cardstatus;
	}

	public void setCardstatus(Integer cardstatus) {
		this.cardstatus = cardstatus;
	}

	public Integer getCheck2() {
		return check2;
	}

	public void setCheck2(Integer check2) {
		this.check2 = check2;
	}

	public String getDealPassword() {
		return dealPassword;
	}

	public void setDealPassword(String dealPassword) {
		this.dealPassword = dealPassword;
	}

	public Integer getDealPassstatus() {
		return dealPassstatus;
	}

	public void setDealPassstatus(Integer dealPassstatus) {
		this.dealPassstatus = dealPassstatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEmailstatus() {
		return emailstatus;
	}

	public void setEmailstatus(Integer emailstatus) {
		this.emailstatus = emailstatus;
	}

	public String getExitgencyname() {
		return exitgencyname;
	}

	public void setExitgencyname(String exitgencyname) {
		this.exitgencyname = exitgencyname;
	}

	public String getExitgencyphone() {
		return exitgencyphone;
	}

	public void setExitgencyphone(String exitgencyphone) {
		this.exitgencyphone = exitgencyphone;
	}

	public Integer getExitgencystatus() {
		return exitgencystatus;
	}

	public void setExitgencystatus(Integer exitgencystatus) {
		this.exitgencystatus = exitgencystatus;
	}

	public String getOpenAccount() {
		return openAccount;
	}

	public void setOpenAccount(String openAccount) {
		this.openAccount = openAccount;
	}

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public String getNewdealpwd() {
		return newdealpwd;
	}

	public void setNewdealpwd(String newdealpwd) {
		this.newdealpwd = newdealpwd;
	}

	public String getEmailYC() {
		return emailYC;
	}

	public void setEmailYC(String emailYC) {
		this.emailYC = emailYC;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
