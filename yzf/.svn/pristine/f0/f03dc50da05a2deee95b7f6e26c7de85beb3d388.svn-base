package com.yzf.pojo;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@SuppressWarnings("serial")
@Cacheable
@Table(name="t_bank_type")
@Entity
public class BankType implements Serializable{
	private Integer id;
	private String bankname;
	private String explain;
	public BankType() {
		super();
	}
	public BankType(Integer id, String bankname, String explain) {
		super();
		this.id = id;
		this.bankname = bankname;
		this.explain = explain;
	}
	@Override
	public String toString() {
		return "BankType [id=" + id + ", bankname=" + bankname + ", explain=" + explain + "]";
	}
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
}