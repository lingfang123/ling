package com.jyb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jyb.pojo.Recruit;
import com.jyb.service.RecruitService;

@Controller
@RequestMapping("recruit")
public class RecruitController {
	@Resource(name="recruitServiceImpl")
	private RecruitService recruitService;
	
	@RequestMapping("openrecruit")
	public String openrecruitPage(Model model){
		List<Recruit> listrecruits = recruitService.list();
		model.addAttribute("listrecruits", listrecruits);
		return "/frontpage/recruit";
	}
}
