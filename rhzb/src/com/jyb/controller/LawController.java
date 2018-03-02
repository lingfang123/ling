package com.jyb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jyb.pojo.Law;
import com.jyb.service.LawService;

@Controller
@RequestMapping("law")
public class LawController {
	@Resource(name="lawServiceImpl")
	private LawService lawService;
	//法律
	@RequestMapping("openlawPage")
	public String openlawPage(Model model,Integer style){
		List<Law> listlaws = lawService.listLaw(style);
		model.addAttribute("listlaws", listlaws);
		if(style==1) {
			return"/frontpage/policy";//法律政策
		}else if(style==2) {
			return"/frontpage/legal";//法律声明
		}else {
			return "/frontpage/postage";//资费
		}
	}
}
