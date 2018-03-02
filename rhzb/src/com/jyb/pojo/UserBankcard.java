package com.jyb.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
public class UserBankcard implements Serializable{
	//银行卡t_user_bankcard
	private static final long serialVersionUID = 1L;
	@TableId("id")
	private Integer id;//银行卡id主键
	
	@TableField("userid")
	private Integer userid;//用户id
	
	@TableField("bankcardno")
	private String bankcardno;//银行卡号
	
	@TableField("placebank")
	private String placebank;//所属银行
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date bindingtime;//绑卡时间
	
	@TableField("status")
	private Integer status;//状态
	
	@TableField("reserved1")
	private String reserved1;	// 真实姓名
	@TableField("reserved2")
	private String reserved2;	//  用户身份证
	
	@TableField("images")
	private String images;		// 银行图标
	@TableField("reserved3")
	private String reserved3;	// 预留字段2
	
	public UserBankcard() {
		// TODO Auto-generated constructor stub
	}

	public UserBankcard(Integer id, Integer userid, String bankcardno, String placebank, Date bindingtime,
			Integer status, String reserved1, String reserved2, String images, String reserved3) {
		super();
		this.id = id;
		this.userid = userid;
		this.bankcardno = bankcardno;
		this.placebank = placebank;
		this.bindingtime = bindingtime;
		this.status = status;
		this.reserved1 = reserved1;
		this.reserved2 = reserved2;
		this.images = images;
		this.reserved3 = reserved3;
	}

	@Override
	public String toString() {
		return "UserBankcard [id=" + id + ", userid=" + userid + ", bankcardno=" + bankcardno + ", placebank="
				+ placebank + ", bindingtime=" + bindingtime + ", status=" + status + ", reserved1=" + reserved1
				+ ", reserved2=" + reserved2 + ", images=" + images + ", reserved3=" + reserved3 + "]";
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

	public String getBankcardno() {
		return bankcardno;
	}

	public void setBankcardno(String bankcardno) {
		this.bankcardno = bankcardno;
	}

	public String getPlacebank() {
		return placebank;
	}

	public void setPlacebank(String placebank) {
		this.placebank = placebank;
	}

	public Date getBindingtime() {
		return bindingtime;
	}

	public void setBindingtime(Date bindingtime) {
		this.bindingtime = bindingtime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getReserved1() {
		return reserved1;
	}


	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}

	public String getReserved2() {
		return reserved2;
	}


	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}
	
	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getReserved3() {
		return reserved3;
	}

	public void setReserved3(String reserved3) {
		this.reserved3 = reserved3;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
