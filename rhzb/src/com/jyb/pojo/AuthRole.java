package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("t_auth_role")
public class AuthRole implements Serializable{
	/**
	 * 权限表
	 */
	private static final long serialVersionUID = 1L;
	@TableId("r_id")
	private Integer rid; //主键
	@TableField("r_name")
	private String rname;//权限名称
	@TableField("create_time")
	private  String createtime;//创建时间
	@TableField("modelid")
	private String modelid;//拥有的权限
	@TableField("status")	
	private Integer status;//角色状态(1启用2禁用)
	@TableField("remark")
	private String remark;//描述
	public AuthRole() {}
	public AuthRole(Integer rid, String rname, String createtime, String modelid, Integer status, String remark) {
		this.rid = rid;
		this.rname = rname;
		this.createtime = createtime;
		this.modelid = modelid;
		this.status = status;
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "AuthRole [rid=" + rid + ", rname=" + rname + ", createtime=" + createtime + ", modelid=" + modelid
				+ ", status=" + status + ", remark=" + remark + "]";
	}
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getModelid() {
		return modelid;
	}
	public void setModelid(String modelid) {
		this.modelid = modelid;
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
}
