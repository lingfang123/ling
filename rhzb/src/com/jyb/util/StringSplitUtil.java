package com.jyb.util;

public class StringSplitUtil {
/**
 * 字符串的切割
 * */
	//手机号
	public static String phoneCut(String str) {
		//获取切割的字符串
		int leng=str.length();
		String phoneStr=str.substring(0,3)+"****"+str.substring(leng-4,leng-0);
		return phoneStr;
	}
	public static String Numbercut(String number) {
		int leng=number.length();
		String s1=number.substring(0, 6);
		String s2=number.substring(6,10);
		String s3=number.substring(10,14);
		String s4=number.substring(14,18);
		return "";
	}
	//邮箱
	public static String emailCut(String str) {
		//获取切割的字符串
		int leng=str.length();
	    int beginIndex = str.indexOf("@");
	    String emailStr=str.substring(0,3)+"****"+str.substring(beginIndex,leng-0);
		return emailStr;
	}
	public static String StringBankCard(String userString) {
		//获取切割的字符串
		int leng=userString.length();
		String str = userString.substring(leng-3,leng+1);
		return str;
	}
	
	
	public String StringNum(String str) {
		//  运营报告是用来切割时间的
		int leng=str.length();
		String numStr = str.substring(0,4)+"-"+str.substring(leng-2,leng-0);
		return numStr;
	}
}

