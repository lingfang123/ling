package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class UserRecharge implements Serializable{
		//用户充值表 t_user_recharge
		private static final long serialVersionUID = 1L;
		@TableId("id")
		private Integer id;			//主键id
		
		@TableField("userid")
		private Integer userid;		//用户id
		
		@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
		private Date cztime;		//充值时间
		
		@TableField("rechargeType")
		private Integer rechargeType;	//充值类型
		
		@TableField("bankName")
		private String bankName;		//银行名称
		
		@TableField("bankcardno")
		private String bankcardno;		//银行卡号
	
		@TableField("billcode")
		private String billcode;		//订单号
		
		@TableField("paynumber")
		private String paynumber;		//流水账单号
		
		@TableField("rechargeMoney")
		private Double rechargeMoney;		//充值金额
		
		@TableField("ipAddress")
		private String ipAddress;		//充值ip
		
		@TableField("areaIp")
		private String areaIp;		//所在城市
		private String bankno;
		
		public UserRecharge() {
			// TODO Auto-generated constructor stub
		}

		public UserRecharge(Integer id, Integer userid, Date cztime, Integer rechargeType, String bankName,
				String bankcardno, String billcode, String paynumber, Double rechargeMoney, String ipAddress,
				String areaIp) {
			super();
			this.id = id;
			this.userid = userid;
			this.cztime = cztime;
			this.rechargeType = rechargeType;
			this.bankName = bankName;
			this.bankcardno = bankcardno;
			this.billcode = billcode;
			this.paynumber = paynumber;
			this.rechargeMoney = rechargeMoney;
			this.ipAddress = ipAddress;
			this.areaIp = areaIp;
		}

		@Override
		public String toString() {
			return "UserRecharge [id=" + id + ", userid=" + userid + ", cztime=" + cztime + ", rechargeType="
					+ rechargeType + ", bankName=" + bankName + ", bankcardno=" + bankcardno + ", billcode=" + billcode
					+ ", paynumber=" + paynumber + ", rechargeMoney=" + rechargeMoney + ", ipAddress=" + ipAddress
					+ ", areaIp=" + areaIp + "]";
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

		public Date getCztime() {
			return cztime;
		}

		public void setCztime(Date cztime) {
			this.cztime = cztime;
		}

		public Integer getRechargeType() {
			return rechargeType;
		}

		public void setRechargeType(Integer rechargeType) {
			this.rechargeType = rechargeType;
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

		public String getBillcode() {
			return billcode;
		}

		public void setBillcode(String billcode) {
			this.billcode = billcode;
		}

		public String getPaynumber() {
			return paynumber;
		}

		public void setPaynumber(String paynumber) {
			this.paynumber = paynumber;
		}

		public Double getRechargeMoney() {
			return rechargeMoney;
		}

		public void setRechargeMoney(Double rechargeMoney) {
			this.rechargeMoney = rechargeMoney;
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
