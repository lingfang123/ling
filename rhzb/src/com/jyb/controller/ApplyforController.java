package com.jyb.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyb.annotation.SystemControllerLog;
import com.jyb.pojo.Applyfor;
import com.jyb.pojo.User;
import com.jyb.service.ApplyforService;
import com.jyb.service.MarkService;

@Controller
public class ApplyforController {
	@Resource(name="applyforServiceImpl")
	private ApplyforService applyforService;
	@Resource(name="markServiceImpl")
	private MarkService markService;
	
	@RequestMapping("openapply")
	public String openApplyfor() {
		return "/frontpage/userLoan";
	}
	//用户添加贷款申请
	@SystemControllerLog(description="用户添加贷款申请")
	@RequestMapping("userapplyfor")
	@ResponseBody
	public String addAppley(Applyfor applyfor,HttpSession session) {
		User user = (User)session.getAttribute("user");
		applyfor.setUserid(user.getId());
		applyfor.setBystr(applyfor.getUname());
		applyfor.setApplyforTime(new Date());
		applyfor.setStruts(0);
		//借款标题headline
		applyfor.setHeadline(markService.getById(applyfor.getMarkid()).getMarkname());
		applyforService.add(applyfor);
		return "success";
	}
}