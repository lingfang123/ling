package com.yzf.controller;

import java.io.BufferedReader;
import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yzf.pojo.BankCardMn;
import com.yzf.pojo.MerchantUser;
import com.yzf.pojo.User;
import com.yzf.pojo.YZFMoney;
import com.yzf.pojo.YZFMoneyMx;
import com.yzf.req.WithdrawDepositReq;
import com.yzf.resp.WithdrawDepositResp;
import com.yzf.service.BankCardMnService;
import com.yzf.service.MerchantUserService;
import com.yzf.service.MoneyMxService;
import com.yzf.service.UserService;
import com.yzf.service.WithdrawDepositService;
import com.yzf.service.MoneyService;
import com.yzf.state.StatusCode;

@Controller
public class WithdrawDepositController {
	@Resource(name="withdrawDepositServiceImpl")
	private WithdrawDepositService withdrawDepositService;
	@Resource(name="merchantUserServiceImpl")
	private MerchantUserService merchantUserService;
	@Resource(name="bankCardMnServiceImpl")
	private BankCardMnService bankCardMnService;
	@Resource(name="userServiceImpl")
	private UserService userService;
	@Resource(name="moneyServiceImpl")
	private MoneyService moneyService;
	@Resource(name="moneyMxServiceImpl")
	private MoneyMxService moneyMxService;
	/**
	 * 合作方用户提现接口
	 * */
	public void addWithdrawDeposit(HttpServletRequest request,HttpServletResponse response) {
		//合作方请求传过来的数据
		WithdrawDepositReq wreq = new WithdrawDepositReq();
		//响应会合作方的数据
		WithdrawDepositResp wresp = new WithdrawDepositResp();
		String ip = request.getRemoteHost();
		System.out.println(ip);
		try {
			//获取接收的报文
			BufferedReader reader=request.getReader();
			
			String line="";
			//流读取
			StringBuffer inputString = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				inputString.append(line);
			}
			//jackJson
			ObjectMapper o=new ObjectMapper();
			//获取到合作方传过来的数据
			wreq = o.readValue(inputString.toString(), WithdrawDepositReq.class);
			System.out.println("接收的报文为= "+wreq);
			
			//判断是否存在该合作的公司
			String username = wreq.getUid();
			String password = wreq.getPass();
			MerchantUser mcu = merchantUserService.getMerchantUser(username, password);
			if(mcu==null) {
				//没有找到合作的公司
				wresp.setCode(StatusCode.YZF_KH_DEFEATED);
				wresp.setContext("No corresponding user was found");
				return;
			}
			//判断是否存在该用户的银行卡
			String bankno = wreq.getBankno();
			BankCardMn bankCardMn = new BankCardMn();
			bankCardMn = bankCardMnService.getByBankcardno(bankno);
			if(bankCardMn==null) {
				//银行卡不存在
				wresp.setCode(StatusCode.YZF_USER_BCZ);
				wresp.setContext("Bank CARDS do not exist");
				return;
			}
			//判断会否存合作方在易支付的用户
			User user = userService.getUser(wreq.getUname());
			if(user==null) {
				wresp.setCode(StatusCode.YZF_USER_BCZ);
				wresp.setContext("Users don't exist");
				return;
			}
			// 用户剩余金额  =  用户金额 - 提现金额 - 手续费
			//手续费计算 收取  0.1%
			BigDecimal b = new BigDecimal(wreq.getMoney()*0.001);
			double sxmoney = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			
			//易支付明细
			YZFMoneyMx moneyMx = new YZFMoneyMx();
			//把手续费转到 	易支付账户中
			YZFMoney ymoney = moneyService.getByid(1);
			//明细前
			moneyMx.setYzfqmoney(ymoney.getYzfmoney());
			ymoney.setYzfmoney(ymoney.getYzfmoney()+sxmoney);
			moneyService.save(ymoney);
			
			//公司明细表
			//明细后
			moneyMx.setYzfbmoney(ymoney.getYzfmoney());
			moneyMx.setYzfid(ymoney.getId());
			moneyMx.setState(1);
			moneyMx.setRm("手续费");
			moneyMx.setYzfbmoney(sxmoney);
			
			//响应手续费
			wresp.setSxmoney(sxmoney);
			//用户金额
			user.setMoney(user.getMoney()-wreq.getMoney()-sxmoney);
			userService.userRegister(user);
			
			bankCardMn.setMoney(wreq.getMoney());
			
		}catch (Exception e) {
			
		} finally {
			
		}
	}
}
