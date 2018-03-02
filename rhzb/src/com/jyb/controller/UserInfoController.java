package com.jyb.controller;

import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.google.gson.Gson;
import com.jyb.annotation.SystemControllerLog;
import com.jyb.http.HttpUtil;
import com.jyb.pojo.Ip;
import com.jyb.pojo.User;
import com.jyb.pojo.UserInfo;
import com.jyb.req.UserRegisterReq;
import com.jyb.resp.UserRegisterResp;
import com.jyb.service.IpService;
import com.jyb.service.UserInfoService;
import com.jyb.util.StringSplitUtil;

/**
 * 用户安全信息添加，修改
 * */
@Controller
@RequestMapping("userinfo")
public class UserInfoController {
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoService;
	@Resource(name="ipServiceImpl")
	private IpService ipService;
	//开通第三方(更新)
	@SystemControllerLog(description="开通第三方(更新)")
	@RequestMapping("payThree")
	@ResponseBody
	public String payThree(UserInfo userInfo,String phone,HttpSession session) {
		//获取session中的userinfo
		UserInfo info=(UserInfo) session.getAttribute("userInfo");
		
		UserInfo ui=new UserInfo();
		ui.setId(info.getId());
		ui.setUserid(info.getUserid());		//修改是用userid
		System.out.println(ui.getUserid());
		
		//创建发送bean的对象
		UserRegisterReq registerReq = new UserRegisterReq();
		registerReq.setUid("zyd7850");
		registerReq.setPass("ling");
		registerReq.setName(userInfo.getName());
		registerReq.setCardNo(userInfo.getIdentityCard());
		registerReq.setPaypass(userInfo.getDealPassword());
		registerReq.setPhone(phone);
		List<Ip> ip = ipService.list();
		Ip I1 = ip.get(0);

		HttpUtil<UserRegisterReq> http = new HttpUtil<>();
		try {
			String httpurl = "http://"+I1.getIp()+":8080/yzf/adduser.do";
			String msg=	(String) http.httpRequest(registerReq,httpurl);
			
		  Gson gson = new Gson();  
		  UserRegisterResp userRegisterResp=gson.fromJson(msg, UserRegisterResp.class);
		  
		  if(userRegisterResp.getCode()==100) {
			  //返回数据成功
			  	ui.setOpenAccount(userRegisterResp.getUname());		//账户名
			  	
			    ui.setName(userInfo.getName());
				ui.setNamestatus(1);
				ui.setIdentityCard(userInfo.getIdentityCard());
				ui.setCardstatus(1);
				
				userInfoService.update(ui);
				
				
				//把更改的值在session里进行移除添加
				info.setOpenAccount(userRegisterResp.getUname());
				info.setName(userInfo.getName());
				info.setNamestatus(ui.getNamestatus());
				info.setIdentityCard(ui.getIdentityCard());
				info.setCardstatus(ui.getCardstatus());
				
				session.removeAttribute("userInfo");
				session.setAttribute("userInfo", info);
			  return "success";
		  }else {
			  return "nosuccess";
		  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	//安全信息的新增，修改
	@SystemControllerLog(description="安全信息的新增，修改")
	@RequestMapping("saveUserinfo")
	@ResponseBody
	public String saveUserinfo(UserInfo userInfo,HttpSession session) throws UnsupportedEncodingException, UnknownHostException{
		//获取session里的user
		User user=(User) session.getAttribute("user");
		
		//根据userid查询userinfo对象,一般来说info不会为空，注册时设置了userid
		UserInfo info=userInfoService.getByuserid(user.getId());
		
		userInfo.setUserid(info.getUserid());
		if(info!=null) {
			//真实姓名
			if(userInfo.getName()!=null&&!userInfo.getName().equals("")) {
				userInfo.setName(userInfo.getName());
				userInfo.setNamestatus(3);
				if(info.getName()==null||info.getName().equals("")) {
					userInfoService.add(userInfo);
				}else{
					userInfoService.update(userInfo);
				}
			}
			//身份证
			if(userInfo.getIdentityCard()!=null&&!userInfo.getIdentityCard().equals("")) {
				userInfo.setIdentityCard(userInfo.getIdentityCard());
				userInfo.setCardstatus(3);
				if(info.getIdentityCard()==null||info.getIdentityCard().equals("")) {
					userInfoService.add(userInfo);
				}else {
					userInfoService.update(userInfo);
				}
			}
			//交易密码
			if(userInfo.getDealPassword()!=null&&!userInfo.getDealPassword().equals("")) {
				//对输入的原密码新密码进行加密
				Object oldpwd = new SimpleHash("MD5",userInfo.getDealPassword(), ByteSource.Util.bytes(user.getUsername()), 10);	
				//根据数据库有无数据，回掉函数
				if(info.getDealPassword()==null||info.getDealPassword().equals("")) {
					userInfo.setDealPassword(oldpwd.toString());
					userInfo.setDealPassstatus(1);
					
					userInfoService.update(userInfo);
					
					//把值设置进一个完整的对象
					info.setDealPassword(oldpwd.toString());
					info.setDealPassstatus(1);
					
					session.removeAttribute("userInfo");
					session.setAttribute("userInfo", info);
					return "success";
				}else {
					//判断输入的交易密码是否和数据库相同
					if(info.getDealPassword().equals(oldpwd.toString())) {
						//对输入的新密码进行加密
						Object newpwd = new SimpleHash("MD5",userInfo.getNewdealpwd(), ByteSource.Util.bytes(user.getUsername()), 10);	
						userInfo.setDealPassword(newpwd.toString());
						userInfo.setDealPassstatus(1);
						
						userInfoService.update(userInfo);
						
						//把值设置进一个完整的对象
						info.setDealPassword(newpwd.toString());
						info.setDealPassstatus(1);
						
						session.removeAttribute("userInfo");
						session.setAttribute("userInfo", info);
						return "success";
					}else {
						//输入密码与原密码不同
						return "nosuccess";
					}
				}
			}
			//邮箱
			if(userInfo.getEmail()!=null&&!userInfo.getEmail().equals("")) {
				
				userInfo.setEmail(userInfo.getEmail());
				userInfo.setEmailstatus(1);
				userInfoService.update(userInfo);
				
				//更新之后，把session移除，把值射入数据库查出对象，再添加
				session.removeAttribute("userInfo");
				
				StringSplitUtil splitUtil=new StringSplitUtil();
				info.setEmail(userInfo.getEmail());
				info.setEmailYC(splitUtil.emailCut(userInfo.getEmail()));
				info.setEmailstatus(userInfo.getEmailstatus());
				session.setAttribute("userInfo", info);
				return "success";
			}
			//紧急联系人姓名
			if(userInfo.getExitgencyname()!=null&&!userInfo.getExitgencyname().equals("")) {
				if(userInfo.getExitgencyphone()!=null&&!userInfo.getExitgencyphone().equals("")) {
					
						userInfo.setExitgencyname(userInfo.getExitgencyname());
						userInfo.setExitgencyphone(userInfo.getExitgencyphone());
						userInfo.setExitgencystatus(1);
						userInfoService.update(userInfo);
						
						//更新之后，把session移除，把值射入数据库查出对象，再添加
						session.removeAttribute("userInfo");
						
						info.setExitgencyname(userInfo.getExitgencyname());
						info.setExitgencyphone(userInfo.getExitgencyphone());
						info.setExitgencystatus(userInfo.getExitgencystatus());
						session.setAttribute("userInfo", info);
						return "success";
				}
			}	
			
		}
		return "/frontpage/personal";
	}
}
