package com.jyb.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
public class Province implements Serializable{
	//省份表t_province
	private static final long serialVersionUID = 1L;
	@TableId("p_id")
	private Integer pid;//省份id
	@TableField("provinceName")
	private String provinceName;//省份名字
	@Override
	public String toString() {
		return "Province [pid=" + pid + ", provinceName=" + provinceName + "]";
	}
	public Province() {}
	public Province(Integer pid, String provinceName) {
		super();
		this.pid = pid;
		this.provinceName = provinceName;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
