package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class UserMoney implements Serializable{
	//用户资金表t_user_money
	private static final long serialVersionUID = 1L;
	
	@TableId("id")
	private Integer id;//id
	
	@TableField("userid")
	private Integer userid;//用户id
	
	@TableField("accountMoney")
	private double accountMoney;//账户余额
	
	@TableField("usableMoney")
	private double usableMoney;//可用余额
	
	@TableField("zqMoney")
	private double zqMoney;//平台为用户赚取的金额
	
	@TableField("freezeMoney")
	private double freezeMoney;//冻结金额
	
	@TableField("collectionMoney")
	private double collectionMoney;//待收金额
	
	@TableField("repayMoney")
	private double repayMoney;//待还金额

	public UserMoney() {}

	public UserMoney(Integer id, Integer userid, double accountMoney, double usableMoney, double zqMoney,
			double freezeMoney, double collectionMoney, double repayMoney) {
		super();
		this.id = id;
		this.userid = userid;
		this.accountMoney = accountMoney;
		this.usableMoney = usableMoney;
		this.zqMoney = zqMoney;
		this.freezeMoney = freezeMoney;
		this.collectionMoney = collectionMoney;
		this.repayMoney = repayMoney;
	}

	@Override
	public String toString() {
		return "UserMoney [id=" + id + ", userid=" + userid + ", accountMoney=" + accountMoney + ", usableMoney="
				+ usableMoney + ", zqMoney=" + zqMoney + ", freezeMoney=" + freezeMoney + ", collectionMoney="
				+ collectionMoney + ", repayMoney=" + repayMoney + "]";
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

	public double getAccountMoney() {
		return accountMoney;
	}

	public void setAccountMoney(double accountMoney) {
		this.accountMoney = accountMoney;
	}

	public double getUsableMoney() {
		return usableMoney;
	}

	public void setUsableMoney(double usableMoney) {
		this.usableMoney = usableMoney;
	}

	public double getZqMoney() {
		return zqMoney;
	}

	public void setZqMoney(double zqMoney) {
		this.zqMoney = zqMoney;
	}

	public double getFreezeMoney() {
		return freezeMoney;
	}

	public void setFreezeMoney(double freezeMoney) {
		this.freezeMoney = freezeMoney;
	}

	public double getCollectionMoney() {
		return collectionMoney;
	}

	public void setCollectionMoney(double collectionMoney) {
		this.collectionMoney = collectionMoney;
	}

	public double getRepayMoney() {
		return repayMoney;
	}

	public void setRepayMoney(double repayMoney) {
		this.repayMoney = repayMoney;
	}

	
}
