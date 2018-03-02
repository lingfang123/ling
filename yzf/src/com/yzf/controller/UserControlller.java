package com.yzf.controller;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yzf.pojo.MerchantUser;
import com.yzf.pojo.User;
import com.yzf.req.UserRegisterReq;
import com.yzf.resp.UserRegisterResp;
import com.yzf.service.MerchantUserService;
import com.yzf.service.UserService;
import com.yzf.state.StatusCode;

@Controller
public class UserControlller {
	@Resource(name="userServiceImpl")
	private UserService userService;
	@Resource(name="merchantUserServiceImpl")
	private MerchantUserService merchantUserService;
	//private 
	//合作公司在易支付注册虚拟账户
	@RequestMapping("adduser")
	public void userRegister(HttpServletRequest request,HttpServletResponse response) {
		//合作公司请求传过来的数据
		UserRegisterReq ur = new UserRegisterReq();
		//易支付响应返回的数据
		UserRegisterResp urs = new UserRegisterResp();
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
			//请求过来的数据
			ur=o.readValue(inputString.toString(), UserRegisterReq.class);
			System.out.println("接收的报文为= "+ur);
			
			//判断是否存在该合作的公司
			String username = ur.getUid();
			String password = ur.getPass();
			MerchantUser mcu = merchantUserService.getMerchantUser(username, password);
			if(mcu==null) {
				//没有找到合作的公司
				urs.setCode(StatusCode.YZF_KH_DEFEATED);
				urs.setContext("No corresponding user was found");
				return;
			}
			Random ne=new Random();//实例化一个random的对象ne
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sfm =new SimpleDateFormat("hhmmss");
			Date date=new Date();
	        int x=ne.nextInt(899999)+100000;
	        //合作公司 id+时分秒+随机数6+年月日
	        //生成虚拟账户 例如 125754749308201801031
	        String str = mcu.getId() + sfm.format(date) + x + sdf.format(date);
	        
	        //给合作人的用户设置开户信息
	        User user = new User();
	        //合作人id
	        user.setP2pid(mcu.getId());
	        user.setUsername(str);
	        user.setPaypass(ur.getPaypass());
	        user.setPhone(ur.getPhone());
	        user.setCardNo(ur.getCardNo());
			user.setCreatetime(new Date());
			user.setMoney(0.00);
			user.setAccountfrozen(0.00);
			//添加合作公司的用户的虚拟支付账户
			userService.userRegister(user);
			//-----------------------易支付工作完成-----------------------------
			//-----------------------进行响应---------------------------------
			urs.setCode(StatusCode.YZF_KH_WIN);
			urs.setContext("Successful opening an account");
			urs.setUname(user.getUsername());
			urs.setCustid(mcu.getId());
			
		} catch (Exception e) {
			urs.setCode(StatusCode.YZF_KH_ABNORMAL);
			urs.setContext("Abnormal opening an account");
			e.printStackTrace();
		}finally {
			try {
	           ObjectMapper m = new ObjectMapper();  
	           String sendStr = m.writeValueAsString(urs);  
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
