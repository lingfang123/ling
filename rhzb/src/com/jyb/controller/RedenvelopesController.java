package com.jyb.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 用户红包Controller（t_redenvelopes）
 * */
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyb.annotation.SystemControllerLog;
import com.jyb.pojo.Redenvelopes;
import com.jyb.pojo.User;
import com.jyb.service.RedenvelopesService;
@Controller
@RequestMapping("redenvelope")
public class RedenvelopesController {
	@Resource(name="redenvelopesServiceImpl")
	private RedenvelopesService redenvelopesService;
	@SystemControllerLog(description="endMoney")
	@ResponseBody
	@RequestMapping("endMoney")
	public Object endMoney(@RequestParam("moneym")double moneym,HttpSession session,Model model) {
		User u = (User) session.getAttribute("user");
		List<Redenvelopes> redeList = redenvelopesService.getByUserid(u.getId());
		for(int i=0;i<redeList.size();i++) {
			if(moneym>=redeList.get(i).getMinmoney() && moneym<=redeList.get(i).getTjmoney()) {
				return redeList.get(i).getHbmoney();
			}
		}
		return 0;
	}
	
}
