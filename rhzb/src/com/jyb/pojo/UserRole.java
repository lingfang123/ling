package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("t_user_role")
public class UserRole implements Serializable{

	/**
	 * 用户权限中间表
	 */
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//主键
	@TableField("userid")
	private Integer userid;//用户id
	@TableField("roleid")
	private Integer roleid;//权限id
	public UserRole() {}
	public UserRole(Integer id, Integer userid, Integer roleid) {
		this.id = id;
		this.userid = userid;
		this.roleid = roleid;
	}
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", userid=" + userid + ", roleid=" + roleid + "]";
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
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
}
