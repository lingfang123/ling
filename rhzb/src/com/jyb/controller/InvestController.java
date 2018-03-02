package com.jyb.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyb.annotation.SystemControllerLog;
import com.jyb.pojo.Invest;
import com.jyb.pojo.User;
import com.jyb.service.InvestService;
import com.jyb.util.PageBean;

@Controller
@RequestMapping("invest")
public class InvestController {
	//投资记录Controller
	@Resource(name="investServiceImpl")
	private InvestService investService;
	
	//打开页面
	@SystemControllerLog(description="打开页面")
	@RequestMapping("openInvestPage")
	public String openInvestPage(
			@RequestParam(value="curPage1",defaultValue="1",required=false)Integer curPage1,
			@RequestParam(value="curPage2",defaultValue="1",required=false)Integer curPage2,
			@RequestParam(value="curPage3",defaultValue="1",required=false)Integer curPage3,
			HttpSession session,Model model){
		User u = (User) session.getAttribute("user");
		Integer userid = u.getId();
		if(userid!=null) {
			//累计投资
			double allCorpus = investService.getAllCorpus(userid);
			model.addAttribute("allCorpus",allCorpus);
			//查询累计收益
			double allLucre = investService.getAllLucre(userid, 5);
			model.addAttribute("allLucre",allLucre);
			//查询待收本金
			double waitCorpus = investService.getWaitCorpus(userid, 5);
			model.addAttribute("waitCorpus",waitCorpus);
			//查询待收收益
			double waitLucre = investService.getWaitLucre(userid, 5);
			model.addAttribute("waitLucre", waitLucre);
			//查询用户的投标中记录(status=1)
			PageBean<Invest> invests1 = investService.listByUseridWithStatus(userid, 1,curPage1);
			model.addAttribute("investList1", invests1);
			//查询用户的回款记录
			PageBean<Invest> invests2 = investService.listByUseridWithStatus(userid, 4,curPage2);
			model.addAttribute("investList2", invests2);
			//查询用户的完成记录
			PageBean<Invest> invests3 = investService.listByUseridWithStatus(userid, 5,curPage3);
			model.addAttribute("investList3", invests3);
			return "/frontpage/investment";
		}
		return null;
	}
	
	//删除
	@SystemControllerLog(description="删除")
	@RequestMapping("deleteInvest")
	public String deleteInvest(@ModelAttribute("id")Integer id) {
		investService.delete(id);
		return "redirect:/invest/openInvestPage";
	}
	
	
	//根据userid、状态（status）查询list
	@SystemControllerLog(description="根据userid、状态（status）查询list")
	@ResponseBody
	@RequestMapping("listByUseridWithStatus")
	public Object listByUseridWithStatus(Integer userid,Integer status) {
		if(status==4) {
			//查询用户的回款记录
			//List<Invest> invests2 = investService.listByUseridWithStatus(userid, status);
			//return invests2;
		}
		if(status==5) {
			//查询用户的完成记录
			//List<Invest> invests3 = investService.listByUseridWithStatus(userid, status);
			//return invests3;
		}
		return null;
	}
}
