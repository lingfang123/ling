package com.yzf.test;

import java.math.BigDecimal;

public class UserText {
	public static void main(String[] args) {
		double lumoney = 0.001;
		double money = 118;
		BigDecimal b = new BigDecimal(money*lumoney);
		double sxmoney = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(sxmoney);
	}
}
