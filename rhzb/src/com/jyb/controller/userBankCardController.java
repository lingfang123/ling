package com.jyb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.jyb.annotation.SystemControllerLog;
import com.jyb.http.HttpUtil;
import com.jyb.pojo.Ip;
import com.jyb.pojo.User;
import com.jyb.pojo.UserBankcard;
import com.jyb.pojo.UserInfo;
import com.jyb.req.BindingBankCardReq;
import com.jyb.req.UserRegisterReq;
import com.jyb.resp.BindingBankCardResp;
import com.jyb.resp.UserRegisterResp;
import com.jyb.service.IpService;
import com.jyb.service.UserBankcardService;
import com.jyb.service.UserInfoService;
import com.jyb.service.UserService;
import com.jyb.sms.CodeSMS;
import com.jyb.util.GetBank;
import com.jyb.util.IdcardValidator;

// 这是 银行卡 Conreoller
@Controller
@RequestMapping("bankCard")
public class userBankCardController {
	// 用户
	@Resource(name="userServiceImpl")
	private UserService userService;
	// 银行卡
	@Resource(name="userBankcardServiceImpl")
	private UserBankcardService userBankcardService;
	@Resource(name="userInfoServiceImpl")
	private UserInfoService userInfoService;
	@Resource(name="ipServiceImpl")
	private IpService ipService;

	// 查看银行卡页面
	@SystemControllerLog(description="查看银行卡页面")
	@RequestMapping("selectMyBankCard")
	public  String selectMyBankCard(HttpSession session,Model model,@ModelAttribute("userid") Integer userid) {
		User user = (User) session.getAttribute("user");
		//List<UserBankcard>  listBank = userBankcardService.list();
		
		List<UserBankcard> listBank = userBankcardService.findBank(userid);
				
		model.addAttribute("listBank", listBank);
		return "/frontpage/userBankCard";
	}
	
	// 打开添加银行卡页面
	@SystemControllerLog(description="打开添加银行卡页面")
	@RequestMapping("openAbankCard")
	public  String openAbankCard() {
		return "/frontpage/userOpenAbankCard";
	}
	
	// 用户添加银行卡
	@SystemControllerLog(description="用户添加银行卡")
	@RequestMapping("addBankCard")
	public String addBankCard(UserBankcard userBankCard,@ModelAttribute("userid") Integer userid) {
		GetBank getBank = new GetBank();
		// 通过银行卡号获取到银行名称
		String bankName = getBank.getname(userBankCard.getBankcardno());
		
		userBankCard.setImages("jsp/frontpage/images/"+bankName+".png");
		
		
		userBankCard.setBindingtime(new Date());
		userBankCard.setPlacebank(bankName);
		userBankCard.setStatus(1);
		
		User u = userService.getById(userid);
		UserInfo userInfo = userInfoService.getByuserid(userid);
		BindingBankCardReq bindingBankCardReq = new BindingBankCardReq();
		bindingBankCardReq.setBankcardno(userBankCard.getBankcardno());
		bindingBankCardReq.setUid("zyd7850");
		bindingBankCardReq.setPass("ling");
		bindingBankCardReq.setName(userInfo.getOpenAccount());
		bindingBankCardReq.setSfbankcardno(userBankCard.getReserved2());
		bindingBankCardReq.setPhone(u.getPhone());
		List<Ip> ip = ipService.list();
		Ip I1 = ip.get(0);

		HttpUtil<BindingBankCardReq> http = new HttpUtil<>();
		try {
			String httpurl = "http://"+I1.getIp()+":8080/yzf/verifybank.do";
			String msg=	 (String) http.httpRequest(bindingBankCardReq,httpurl);
		
		    Gson gson = new Gson();  
		    BindingBankCardResp bindingBankCardResp=gson.fromJson(msg, BindingBankCardResp.class);
		    System.out.println(bindingBankCardResp);
		    if(bindingBankCardResp.getCode()==300) {
				userBankcardService.add(userBankCard);
				System.out.println("绑卡成功");
				return "redirect:/bankCard/selectMyBankCard";
		    }
		    if(bindingBankCardResp.getCode()==201) {
		    	System.out.println("用户在银行不存在该银行卡");
		    	return "redirect:/bankCard/selectMyBankCard";
		    }
		    if(bindingBankCardResp.getCode()==105) {
		    	System.out.println("用户判断是否存在");
		    	return "redirect:/bankCard/selectMyBankCard";
		    }
		    if(bindingBankCardResp.getCode()==101) {
		    	System.out.println("没有找到合作的公司");
		    	return "redirect:/bankCard/selectMyBankCard";
		    }

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/bankCard/selectMyBankCard";
	}
	
	// check 检查的意思         检查用户身份证是否符合规定
	@ResponseBody
	@RequestMapping("checkUserIDCard")
	public String checkUserIDCard(@RequestParam("reserved2") String reserved2) {
		IdcardValidator IdCard = new IdcardValidator();
		if(IdCard.is18Idcard(reserved2)) {
			return "false";
		}
		return "true";
	}
	
	// 检验 银行卡是否正确	
	@ResponseBody
	@RequestMapping("checkUserBankCard")
	public String checkUserBankCard(@RequestParam("bankcardno") String bankcardno) {
		GetBank getBank = new GetBank();
		if(getBank.checkBankCard(bankcardno)) {
			return "false";
		}
		return "true";
	}
	
	// 检验 银行卡是否已经存在
	@ResponseBody
	@RequestMapping("checkBankCard")
	public String checkBankCard(@RequestParam("bankcardno") String bankcardno) {
		List<UserBankcard> list = new ArrayList<>();
		list = userBankcardService.findUserBank(bankcardno);
		if(list.size()==0) {
			return "false";
		}
		return "true";
	}
	
	// 打开添加银行卡页面
	@RequestMapping("openIndex2")
	public  String openIndex2() {
		return "/frontpage/index2";
	}
	
	// 依据 id 删除银行卡
	@SystemControllerLog(description="依据 id 删除银行卡")
	@RequestMapping("deleteUserBankCard")
	public String deleteUserBankCard(@RequestParam("id") Integer id,@ModelAttribute("userid") Integer userid) {
		userBankcardService.delete(id);
		return "redirect:/bankCard/selectMyBankCard";
	}
	
	// 银行卡验证码
	@RequestMapping("checkUserBankCode")
	@ResponseBody
	public Map<String,Object> checkUserBankCode(@RequestParam("phone") String phone) throws HttpException, IOException{
		Map<String, Object> result = new HashMap<>();
		Integer random = (int)((Math.random()*9+1)*100000);
		String context = "您好，您绑定银行卡的验证码为："+random+",请及时认证！为了保证您账户的安全，请勿将此验证码告知他人【众易贷】";
		CodeSMS codeSMS = new CodeSMS();
		codeSMS.code(phone, context);
		
		System.out.println(random);
		result.put("success", random);
		return result;
	}
	
}
