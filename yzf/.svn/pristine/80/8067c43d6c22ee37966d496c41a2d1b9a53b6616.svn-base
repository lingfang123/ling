package com.yzf.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yzf.pojo.BankCardMn;
import com.yzf.pojo.FinancialDetails;
import com.yzf.pojo.MerchantUser;
import com.yzf.pojo.RechargeDetail;
import com.yzf.pojo.User;
import com.yzf.req.RechargeDetailReq;
import com.yzf.resp.RechargeDetailResp;
import com.yzf.service.BankCardMnService;
import com.yzf.service.FinancialDetailsService;
import com.yzf.service.MerchantUserService;
import com.yzf.service.RechargeDetailService;
import com.yzf.service.UserService;
import com.yzf.state.StatusCode;
import com.yzf.util.UUIDHexGenerator;

@Controller
public class RechargeDetailController {
	@Resource(name="rechargeDetailServiceImpl")
	private RechargeDetailService rechargeDetailService;
	@Resource(name="merchantUserServiceImpl")
	private MerchantUserService merchantUserService;
	@Resource(name="bankCardMnServiceImpl")
	private BankCardMnService bankCardMnService;
	@Resource(name="userServiceImpl")
	private UserService userService;
	@Resource(name="financialDetailsServiceImpl")
	private FinancialDetailsService financialDetailsService;
	/**
	 * 充值接口
	 * */
	public void addRechargeDetail(HttpServletRequest request,HttpServletResponse response) throws IOException {
		RechargeDetailResp rdresp = new RechargeDetailResp();
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
			//合作方用户充值传过来的数据
			RechargeDetailReq rdreq = new RechargeDetailReq();
			rdreq=o.readValue(inputString.toString(), RechargeDetailReq.class);
			System.out.println("接收的报文为= "+rdreq);
			
			//判断是否存在该合作的公司
			String username = rdreq.getUid();
			String password = rdreq.getPass();
			MerchantUser mcu = merchantUserService.getMerchantUser(username, password);
			if(mcu==null) {
				//没有找到合作的公司
				rdresp.setCode(StatusCode.YZF_KH_DEFEATED);
				rdresp.setContext("No corresponding user was found");
				return;
			}
			
			//判断是否存在该用户的银行卡
			String bankno = rdreq.getBankno();
			BankCardMn bankCardMn = new BankCardMn();
			bankCardMn = bankCardMnService.getByBankcardno(bankno);
			if(bankCardMn==null) {
				//银行卡不存在
				rdresp.setCode(StatusCode.YZF_USER_BCZ);
				rdresp.setContext("Bank CARDS do not exist");
				return;
			}
			
			//判断银行卡是否有那么多钱
			if(rdreq.getMoney()>bankCardMn.getMoney()) {
				//银行卡不足
				rdresp.setCode(StatusCode.YZF_CZ_BZ);
				rdresp.setContext("Insufficient bank card balance");
				return;
			}
			
			//判断会否存合作方在易支付的用户
			User user = userService.getUser(rdreq.getUsername());
			if(user==null) {
				rdresp.setCode(StatusCode.YZF_USER_BCZ);
				rdresp.setContext("Users don't exist");
				return;
			}
			
			//用户金额增加
			user.setMoney(user.getMoney()+bankCardMn.getMoney());
			userService.userRegister(user);
			
			//银行卡资金减少
			bankCardMn.setMoney(bankCardMn.getMoney()-rdreq.getMoney());
			bankCardMnService.save(bankCardMn);
			
			//生成流水号
			UUIDHexGenerator uuid = new UUIDHexGenerator();
			
			//向合作方的用户添加充值记录表
			RechargeDetail rechargeDetail = new RechargeDetail();
			rechargeDetail.setUserid(user.getId());
			rechargeDetail.setPaynumber(uuid.UUIDNumber());
			rechargeDetail.setType("1");
			rechargeDetail.setBankno(bankCardMn.getBankcardno());
			rechargeDetail.setTime(new Date());
			rechargeDetail.setMoney(rdreq.getMoney());
			rechargeDetailService.addRecharge(rechargeDetail);
			
			//向合作方用户资金明细表添加记录
			FinancialDetails financialDetails = new FinancialDetails();
			financialDetails.setUserid(user.getId());
			financialDetails.setMoney(rechargeDetail.getMoney());
			financialDetails.setCreatetime(new Date());
			//充值
			financialDetails.setStruts(1);
			//流水号
			financialDetails.setExplain(rechargeDetail.getPaynumber());
			
			
			//----------------------------易支付工作完成-----------------------
			//----------------------------易支付响应数据给合作方-------------------
			rdresp.setCode(StatusCode.YZF_CZ_WIN);
			rdresp.setContext("Top-up success");
			rdresp.setCustid(mcu.getId());
			rdresp.setMoney(user.getMoney());
			rdresp.setLsnumber(rechargeDetail.getPaynumber());
			
			
		}catch (Exception e) {
			rdresp.setCode(StatusCode.YZF_CZ_ABNORMAL);
			e.printStackTrace();
		}finally {
			//回传数据
			ObjectMapper m = new ObjectMapper();  
			String sendStr = m.writeValueAsString(rdresp);  
			// 设置发送报文的格式  
			response.setContentType("text/json");  
			response.setCharacterEncoding("UTF-8");
	   
			PrintWriter out = response.getWriter();  
			out.println(sendStr);  
			out.flush();  
			out.close();
		}
	}
}
