package com.jyb.util;

public class Some {
	public static void main(String[] args) {
		System.out.println(conversion(10002, null));
		System.out.println(conversion(1000, null));
		System.out.println(conversion(1000201, null));
		System.out.println(conversion(1000201, 2));
	}

	/**
	 * java转换数字以万为单位
	 * 
	 * @param num
	 *            要转化的数字
	 * @param digit
	 *            保留的位数 可传null
	 * @return
	 */
	public static Object conversion(int num, Integer digit) {
		if (num < 10000) {
			return num;
		}
		String unit = "万";
		double newNum = num / 10000.0;
		if (digit != null) {
			String numStr = String.format("%." + digit + "f", newNum);
			return numStr + unit;
		}
		return newNum + unit;
	}
}