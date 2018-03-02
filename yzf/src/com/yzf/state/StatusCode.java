package com.yzf.state;

public interface StatusCode {
	/**
	 *	用这个接口来保存所有的常量 
	 *  这样做的目的是增加程序的可读性
	 **/
	//开户
	public static final int YZF_KH_WIN = 100;//开通易支付虚拟账户成功
	public static final int YZF_KH_DEFEATED = 101;//开通易支付虚拟账户失败
	public static final int YZF_KH_ABNORMAL = 102;//开通易支付虚拟账户异常
	public static final int YZF_USER_CZ = 104;//已存在
	public static final int YZF_USER_BCZ = 105;//不存在
	//模拟银行
	public static final int YZF_YHPD_WIN = 200;//用户在银行存在该银行卡
	public static final int YZF_YHPD_DEFEATED = 201;//用户在银行不存在该银行卡
	public static final int YZF_YHPD_ABNORMAL = 202;//用户判断银行是否存在出现异常
	//绑定银行卡
	public static final int YZF_BK_WIN = 300;//绑卡成功
	public static final int YZF_BK_DEFEATED = 301;//用户绑卡失败
	public static final int YZF_BK_ABNORMAL = 302;//绑卡异常
	//用户充值
	public static final int YZF_CZ_BZ = 400;//用户在银行卡的余额不足
	public static final int YZF_CZ_WIN = 401;//用户充值成功
	public static final int YZF_CZ_DEFEATED = 402;//用户充值失败
	public static final int YZF_CZ_ABNORMAL = 403;//充值异常
	//提现
	public static final int YZF_TX_WIN = 500;//用户提现成功
	public static final int YZF_TX_DEFEATED = 501;//用户提现失败
	public static final int YZF_TX_BZ = 502;//用户账户余额不足
	public static final int YZF_TX_ABNORMAL = 503;//用户提现出现异常
	//筹款
	public static final int YZF_TB_WIN = 600;//易支付为用户生成筹款记录成功
	public static final int YZF_TB_DEFEATED = 601;//易支付为用户生成筹款记录失败
	public static final int YZF_TB_ABNORMAL = 603;//易支付为用户生成筹款异常
	public static final int YZF_TB_CKZ = 604;//冻结中
	public static final int YZF_TB_SFZ = 605;//解冻
	public static final int YZF_TB_TH = 606;//退还
	//订单
	public static final int YZF_XD_WIN = 700;//下单成功;
	public static final int YZF_XD_DEFEATED = 701;//下单失败
	public static final int YZF_XD_ABNORMAL = 702;//下单异常
}
