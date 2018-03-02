package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class FinanceCompanydetail implements Serializable{
	//公司账户明细t_finance_companydetail
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//主键id
	@TableField("incomeType")
	private Integer incomeType;//类型
	@TableField("transMoney")
	private double transMoney;//操作金额
	@TableField("useableMoney")
	private double useableMoney;//可用余额
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//明细时间
	private Date operateTime;//操作时间
	@TableField("remark")
	private String remark;//说明
	
	public FinanceCompanydetail() {
	}
	public FinanceCompanydetail(Integer id, Integer incomeType, double transMoney, double useableMoney, Date operateTime,
			String remark) {
		super();
		this.id = id;
		this.incomeType = incomeType;
		this.transMoney = transMoney;
		this.useableMoney = useableMoney;
		this.operateTime = operateTime;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "FinanceCompanydetail [id=" + id + ", incomeType=" + incomeType + ", transMoney=" + transMoney
				+ ", useableMoney=" + useableMoney + ", operateTime=" + operateTime + ", remark=" + remark + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIncomeType() {
		return incomeType;
	}
	public void setIncomeType(Integer incomeType) {
		this.incomeType = incomeType;
	}
	public double getTransMoney() {
		return transMoney;
	}
	public void setTransMoney(double transMoney) {
		this.transMoney = transMoney;
	}
	public double getUseableMoney() {
		return useableMoney;
	}
	public void setUseableMoney(double useableMoney) {
		this.useableMoney = useableMoney;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
