package com.jyb.arithmetic;

import java.math.BigDecimal;

/**
 * 先息后本算法
 * */
public class InterestAfterPrincipal {
	
	//应还本息总额
	public static double getPrincipalAndInterest(double invest, double yearRate, int totalmonth) {
		double monthRate = yearRate / 12/100;
		BigDecimal perMonthInterest = new BigDecimal(monthRate)
				.multiply(new BigDecimal(invest)).setScale(2, BigDecimal.ROUND_DOWN)
				.multiply(new BigDecimal(totalmonth)).setScale(2, BigDecimal.ROUND_DOWN).add(new BigDecimal(invest));
		perMonthInterest.setScale(2, BigDecimal.ROUND_DOWN);
		return perMonthInterest.doubleValue();
	}
	//需许利息
	public static double getSumMonthlyInterest(double invest, double yearRate, int totalmonth) {
		double monthRate = yearRate / 12/100;
		BigDecimal perMonthInterest = new BigDecimal(monthRate).setScale(2, BigDecimal.ROUND_DOWN)
				.multiply(new BigDecimal(invest)).setScale(2, BigDecimal.ROUND_DOWN)
				.multiply(new BigDecimal(totalmonth)).setScale(2, BigDecimal.ROUND_DOWN);
		return perMonthInterest.doubleValue();
	}
	//需许利息
	public static double getMonthlyInterest(double invest, double yearRate, int totalmonth) {
		double monthRate = yearRate / 12/100;
		BigDecimal perMonthInterest = new BigDecimal(monthRate).setScale(2, BigDecimal.ROUND_DOWN)
				.multiply(new BigDecimal(invest)).setScale(2, BigDecimal.ROUND_DOWN);
		return perMonthInterest.doubleValue();
	}
	public static void main(String[] args) {
		System.out.println("本息"+InterestAfterPrincipal.getPrincipalAndInterest(10000, 12,12));
		System.out.println("总利息"+InterestAfterPrincipal.getSumMonthlyInterest(10000, 12,12));
		System.out.println("总利息"+InterestAfterPrincipal.getMonthlyInterest(10000, 12,12));
	}
}