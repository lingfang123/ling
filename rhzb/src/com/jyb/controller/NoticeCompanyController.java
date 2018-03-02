package com.jyb.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jyb.pojo.NoticeCompany;
import com.jyb.service.NoticeCompanyService;
import com.jyb.util.PageBean;

@Controller
@RequestMapping("noticeCompany")
public class NoticeCompanyController {
	@Resource(name="noticeCompanyServiceImpl")
	private NoticeCompanyService noticeCompanyService;
	@RequestMapping("openNotice")
	public String openNoticeCompany(@RequestParam(value="currPage",defaultValue="1",required=false)Integer currentPage,Model model){
		List<NoticeCompany> listNoticeCompanys = noticeCompanyService.list();
		PageBean<NoticeCompany> noticeCompanyInfos =noticeCompanyService.listAll(currentPage);
		model.addAttribute("listNoticeCompanys", listNoticeCompanys);
		model.addAttribute("noticeCompanyInfos", noticeCompanyInfos);
		return "/frontpage/noticeCompany";
	}
	
	@RequestMapping("noticeById")
	public String noticeById(Integer id,Model model) {
		NoticeCompany noticeCompany=noticeCompanyService.getById(id);
		model.addAttribute("noticeCompany", noticeCompany);
		return "/frontpage/noticeDetail";
	}
}
