package com.jyb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jyb.annotation.SystemControllerLog;
import com.jyb.pojo.HelpCenter;
import com.jyb.service.HelpCenterService;

@Controller
@RequestMapping("helpCenter")
public class HelpCenterController{
	@Resource(name="helpCenterServiceImpl")
	private HelpCenterService helpCenterService;
	//查询所有的帮助资料
	@SystemControllerLog(description="查询所有的帮助资料")
	@RequestMapping("openHelpPage")
	public String openHelpPage(Model model){
		List<HelpCenter> listHelpCenters = helpCenterService.list();
		model.addAttribute("listHelpCenters", listHelpCenters);
		return "/frontpage/help";
	}
}
