package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class UserWithdraw implements Serializable{
	//提现表t_user_withdraw
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//主键id
	
	@TableField("userid")
	private Integer userid;//提现用户id
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date withdrawTime;//提现时间
	
	@TableField("withdrawMoney")
	private Double withdrawMoney;//提现金额
	
	@TableField("poundage")
	private Double poundage;//手续费
	
	@TableField("bankName")
	private String bankName;//所属银行
	
	@TableField("bankcardno")
	private String bankcardno;//银行卡号
	
	@TableField("status")
	private Integer status;//提现状态
	
	@TableField("operatorId")
	private Integer operatorId;//审核人(管理员id)
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date arriveTime;//到账时间
	
	@TableField("arriveMoney")
	private Double arriveMoney;//到账金额
	
	@TableField("ipAddress")
	private String ipAddress;//提现ip地址
	
	@TableField("areaIp")
	private String areaIp;//提现城市
	private String bankno;
	public UserWithdraw() {
		// TODO Auto-generated constructor stub
	}

	public UserWithdraw(Integer id, Integer userid, Date withdrawTime, Double withdrawMoney, Double poundage,
			String bankName, String bankcardno, Integer status, Integer operatorId, Date arriveTime, Double arriveMoney,
			String ipAddress, String areaIp) {
		super();
		this.id = id;
		this.userid = userid;
		this.withdrawTime = withdrawTime;
		this.withdrawMoney = withdrawMoney;
		this.poundage = poundage;
		this.bankName = bankName;
		this.bankcardno = bankcardno;
		this.status = status;
		this.operatorId = operatorId;
		this.arriveTime = arriveTime;
		this.arriveMoney = arriveMoney;
		this.ipAddress = ipAddress;
		this.areaIp = areaIp;
	}

	@Override
	public String toString() {
		return "UserWithdraw [id=" + id + ", userid=" + userid + ", withdrawTime=" + withdrawTime + ", withdrawMoney="
				+ withdrawMoney + ", poundage=" + poundage + ", bankName=" + bankName + ", bankcardno=" + bankcardno
				+ ", status=" + status + ", operatorId=" + operatorId + ", arriveTime=" + arriveTime + ", arriveMoney="
				+ arriveMoney + ", ipAddress=" + ipAddress + ", areaIp=" + areaIp + "]";
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

	public Date getWithdrawTime() {
		return withdrawTime;
	}

	public void setWithdrawTime(Date withdrawTime) {
		this.withdrawTime = withdrawTime;
	}

	public Double getWithdrawMoney() {
		return withdrawMoney;
	}

	public void setWithdrawMoney(Double withdrawMoney) {
		this.withdrawMoney = withdrawMoney;
	}

	public Double getPoundage() {
		return poundage;
	}

	public void setPoundage(Double poundage) {
		this.poundage = poundage;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankcardno() {
		return bankcardno;
	}

	public void setBankcardno(String bankcardno) {
		this.bankcardno = bankcardno;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public Date getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}

	public Double getArriveMoney() {
		return arriveMoney;
	}

	public void setArriveMoney(Double arriveMoney) {
		this.arriveMoney = arriveMoney;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getAreaIp() {
		return areaIp;
	}

	public void setAreaIp(String areaIp) {
		this.areaIp = areaIp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getBankno() {
		return bankno;
	}
	public void setBankno(String bankno) {
		this.bankno = bankno;
	}
}
