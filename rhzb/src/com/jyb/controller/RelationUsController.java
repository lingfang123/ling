package com.jyb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jyb.pojo.RelationUs;
import com.jyb.service.RelationUsService;

@Controller
@RequestMapping("relationUs")
public class RelationUsController {
	@Resource(name="relationUsServiceImpl")
	private RelationUsService relationUsService;
	//查询所有的联系我们
	@RequestMapping("openRelation")
	public String openRelationPage(Model model){
		List<RelationUs> listRelationUss = relationUsService.list();
		model.addAttribute("listRelationUss", listRelationUss);
		return "/frontpage/relationUs";
	}
}
