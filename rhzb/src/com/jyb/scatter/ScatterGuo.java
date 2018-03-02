package com.jyb.scatter;

public class ScatterGuo {
	private String name;
	private Integer value;
	public ScatterGuo() {
		super();
	}
	public ScatterGuo(String name, Integer value) {
		super();
		this.name = name;
		this.value = value;
	}
	@Override
	public String toString() {
		return "ScatterGuo [name=" + name + ", value=" + value + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
}
