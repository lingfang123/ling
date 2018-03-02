package com.jyb.controller;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jyb.annotation.SystemControllerLog;
import com.jyb.pojo.Dates;
import com.jyb.pojo.Mark;
import com.jyb.pojo.MarkInfo;
import com.jyb.pojo.NewCompany;
import com.jyb.pojo.NoticeCompany;
import com.jyb.service.DateService;
import com.jyb.service.MarkInfoService;
import com.jyb.service.MarkService;
import com.jyb.service.NewCompanyService;
import com.jyb.service.NoticeCompanyService;
import com.jyb.service.RefundRecordService;
import com.jyb.service.UserMoneyService;
import com.jyb.service.UserService;

@Controller
@RequestMapping("index")
public class IndexController {
	
	@Resource(name="dateServiceImpl")
	private DateService dateService;
	
	@Resource(name="noticeCompanyServiceImpl")
	private NoticeCompanyService noticeCompanyService;
	
	@Resource(name="newCompanyServiceImpl")
	private NewCompanyService newCompanyService;
	
	@Resource(name="markServiceImpl")
	private MarkService markService;
	
	@Resource(name="markInfoServiceImpl")
	private MarkInfoService markInfoService;
	
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@Resource(name="refundRecordServiceImpl")
	private RefundRecordService refundRecordService;
	
	@Resource(name="userMoneyServiceImpl")
	private UserMoneyService userMoneyService;
	
	@RequestMapping("register")
	public String test() {
		return "/frontpage/register";
	}
	
	//admin管理页面（ /jsp/admin/** ）
	@SystemControllerLog(description="admin管理页面")
	@RequestMapping("admin")
	public String admin() {
		return "/admin/index";
	}
	
	//用户后台管理页面（ /jsp/bgpage/** ）
	@SystemControllerLog(description="用户后台管理页面")
	@RequestMapping("bgpage")
	public String bgpage() {
		return "/bgpage/index";
	}
	
	//网站前台页面（ /jsp/frontpage/** ）
	@SystemControllerLog(description="网站前台页面")
	@RequestMapping("frontpage")
	public String frontpage(Model model) {
		//轮播图
		List<Dates> listD=dateService.list();
		model.addAttribute("listD", listD);
		//公告
		List<NoticeCompany> listN=noticeCompanyService.list();
		model.addAttribute("listN", listN);
		//新闻
		List<NewCompany> listNew=newCompanyService.listNewInfo(1);
		model.addAttribute("listNew",listNew);
		//资讯
		List<NewCompany> listInfo=newCompanyService.listNewInfo(2);
		model.addAttribute("listinfo", listInfo);
		//查询标型
		List<Mark> listMark = markService.list();
		model.addAttribute("listMark", listMark);
		//根据标型查询List
		for(int i=0;i<listMark.size();i++) {
			if(i==0) {
				List<MarkInfo> listMarkInfo1 = markInfoService.listByMarkid(listMark.get(i).getId());
				model.addAttribute("listMarkInfo"+i, listMarkInfo1);
			}else if(i==1) {
				List<MarkInfo> listMarkInfo2 = markInfoService.listByMarkid(listMark.get(i).getId());
				model.addAttribute("listMarkInfo"+i, listMarkInfo2);
			}
		}
		//查询注册人数
		Integer userCount =userService.userCount();
		model.addAttribute("userCount", userCount);
		//查询平台已筹金额
		DecimalFormat df = new DecimalFormat("0.00");
		Double sumMoney = markInfoService.sumMoney();
		model.addAttribute("sumMoney", df.format(sumMoney/10000));
		//平台已还本息
		double sumPrincipal = refundRecordService.sumPrincipal(1);
		model.addAttribute("sumPrincipal", df.format(sumPrincipal/10000));
		//平台为用户赚取金额
		double sumZqmoney = userMoneyService.sumZqmoney();
		model.addAttribute("sumZqmoney", df.format(sumZqmoney/10000));
		
		return "/frontpage/index";
	}
	
	//跳转帮助中心
	@SystemControllerLog(description="跳转帮助中心")
	@RequestMapping("help")
	public String help() {
		return "/frontpage/help";
	}
	
	//跳转我要投资页面
	@SystemControllerLog(description="跳转我要投资页面")
	@RequestMapping("addInvest")
	public String addInvest() {
		return "/frontpage/addInvest";
	}
	
	//跳转关于我们页面
	@SystemControllerLog(description="跳转关于我们页面")
	@RequestMapping("companyInfo")
	public String companyInfo() {
		return "/frontpage/companyInfo";
	}
	
	//跳转关于团队管理
	@SystemControllerLog(description="跳转关于团队管理")
	@RequestMapping("team")
	public String team() {
		return "/frontpage/team";
	}
	
	
}
