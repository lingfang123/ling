package com.jyb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jyb.pojo.NewCompany;
import com.jyb.service.NewCompanyService;
import com.jyb.util.PageBean;

@Controller
@RequestMapping("newCompany")
public class NewCompanyController {
	@Resource(name="newCompanyServiceImpl")
	private NewCompanyService newCompanyService;
	
	@RequestMapping("openNew")
	public String openNewCompany(@RequestParam(value="currPage",defaultValue="1",required=false)Integer currPage,Model model){
		List<NewCompany> listNewCompanys = newCompanyService.list();
		PageBean<NewCompany> newCompanyInfos= newCompanyService.listAll(currPage);
		model.addAttribute("listNewCompanys", listNewCompanys);
		model.addAttribute("newCompanyInfos", newCompanyInfos);
		return "/frontpage/newCompany";
	}
	
	@RequestMapping("newById")
	public String newById(Integer id,Model model){
		NewCompany company=newCompanyService.getById(id);
		model.addAttribute("company", company);
		return "/frontpage/NewDetail";
	}
}
