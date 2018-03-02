package com.jyb.pojo;

public class Ip {
	private Integer id;
	private String ip;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Ip(Integer id, String ip) {
		super();
		this.id = id;
		this.ip = ip;
	}
	public Ip() {
		super();
	}
	@Override
	public String toString() {
		return "IP [id=" + id + ", ip=" + ip + "]";
	}
	
}
