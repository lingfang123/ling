package com.yzf.controller;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yzf.pojo.BankCard;
import com.yzf.pojo.BankCardMn;
import com.yzf.pojo.MerchantUser;
import com.yzf.pojo.User;
import com.yzf.req.BindingBankCardReq;
import com.yzf.resp.BindingBankCardResp;
import com.yzf.service.BankCardMnService;
import com.yzf.service.BankCardService;
import com.yzf.service.MerchantUserService;
import com.yzf.service.UserService;
import com.yzf.state.StatusCode;

@Controller
public class BankCardMnController {
	@Resource(name="bankCardMnServiceImpl")
	private BankCardMnService bankCardMnService;
	@Resource(name="merchantUserServiceImpl")
	private MerchantUserService merchantUserService;
	@Resource(name="userServiceImpl")
	private UserService userService;
	@Resource(name="bankCardServiceImpl")
	private BankCardService bankCardService;
	@RequestMapping("bankmnlist")
	public String bankCardMnFindAll(Integer page, Integer rows,Model model){
		page=1;
		rows=10;
		Page<BankCardMn> list = bankCardMnService.getPage(page, rows);
		model.addAttribute("list", list);
		return "list/bankmn";
	}
	@RequestMapping("verifybank")
	@ResponseBody
	public void verifyBankCardMn(HttpServletRequest request,HttpServletResponse response) {
		//返回给合作平台的数据
		BindingBankCardResp bcf = new BindingBankCardResp();
		String ip = request.getRemoteHost();
		System.out.println(ip);
		try {
			//获取接收的报文
			BufferedReader reader=request.getReader();
			
			String line="";
			
			StringBuffer inputString = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				inputString.append(line);
			}
			//jackJson    
			ObjectMapper o=new ObjectMapper();
			//合作平台返回给易支付的数据
			BindingBankCardReq bc = new BindingBankCardReq();
			//易支付接收数据
			bc=o.readValue(inputString.toString(), BindingBankCardReq.class);
			System.out.println("接收的报文为= "+bc);
			
			String username = bc.getUid();
			String password = bc.getPass();
			MerchantUser mcu = merchantUserService.getMerchantUser(username, password);
			if(mcu==null) {
				//没有找到合作的公司
				bcf.setCode(StatusCode.YZF_KH_DEFEATED);
				bcf.setContext("No corresponding user was found");
				return;
			}
			
			//模拟用户在银行的银行卡
			BankCardMn bm = new BankCardMn();
			bm.setName(bc.getName());
			bm.setPhone(bc.getPhone());
			bm.setBankcardno(bc.getBankcardno());
			bm.setSfbankcardno(bc.getSfbankcardno());
			//模拟查看用户在银行是否有该银行卡
			BankCardMn bank = bankCardMnService.getBankCardMn(bm);
			if(bank==null) {
				//用户银行卡不存在
				bcf.setCode(StatusCode.YZF_YHPD_DEFEATED);
				bcf.setContext("User card does not exist");
				return;
			}
			User user = userService.getUser(bc.getBankcardno());
			if(user==null) {
				//用户不存在
				bcf.setCode(StatusCode.YZF_USER_BCZ);
				bcf.setContext("Users don't exist");
				return;
			}
			BankCard userbank = new BankCard();
			userbank.setUserid(user.getId());
			userbank.setBankcardno(bc.getBankcardno());
			userbank.setType(bank.getType());
			userbank.setCreatetime(new Date());
			userbank.setStruts(1);
			bankCardService.userAddBankCard(userbank);
			//---------------------易支付工作完成----------------------------
			//---------------------易支付响应合作公司-------------------------
			bcf.setBankcardno(bc.getBankcardno());
			bcf.setCustid(mcu.getId());
		} catch (Exception e) {
			//出错了
			bcf.setCode(StatusCode.YZF_BK_WIN);
			bcf.setContext("To successfully");
			e.printStackTrace();
		}finally {
			//实现响应返回数据给合作公司
			try {
	           ObjectMapper m = new ObjectMapper();
	           //设置要响应的数据
	           String sendStr = m.writeValueAsString(bcf);  
		       // 设置发送报文的格式  
		       response.setContentType("text/json");  
		       response.setCharacterEncoding("UTF-8");  
		       
		       PrintWriter out = response.getWriter();  
		       out.println(sendStr);  
		       out.flush();  
		       out.close(); 	
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
