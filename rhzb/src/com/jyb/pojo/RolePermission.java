package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("t_role_permission")
public class RolePermission implements Serializable{
	/**
	 * 权限资源中间表
	 */
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//主键
	@TableField("role")
	private Integer role;//权限id
	@TableField("permissionid")
	private Integer permissionid;//资源id
	public RolePermission() {}
	public RolePermission(Integer id, Integer role, Integer permissionid) {
		this.id = id;
		this.role = role;
		this.permissionid = permissionid;
	}
	@Override
	public String toString() {
		return "RolePermission [id=" + id + ", role=" + role + ", permissionid=" + permissionid + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public Integer getPermissionid() {
		return permissionid;
	}
	public void setPermissionid(Integer permissionid) {
		this.permissionid = permissionid;
	}
}
