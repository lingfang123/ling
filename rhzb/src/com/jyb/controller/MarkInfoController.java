package com.jyb.controller;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jyb.annotation.SystemControllerLog;
import com.jyb.pojo.Applyfor;
import com.jyb.pojo.Invest;
import com.jyb.pojo.Mark;
import com.jyb.pojo.MarkInfo;
import com.jyb.pojo.Redenvelopes;
import com.jyb.pojo.RefundRecord;
import com.jyb.pojo.User;
import com.jyb.pojo.UserMoney;
import com.jyb.service.ApplyforService;
import com.jyb.service.InvestService;
import com.jyb.service.MarkInfoService;
import com.jyb.service.MarkService;
import com.jyb.service.RedenvelopesService;
import com.jyb.service.RefundRecordService;
import com.jyb.service.UserMoneyService;
import com.jyb.util.DateUtils;
import com.jyb.util.PageBean;

@Controller
@RequestMapping("markinfo")
public class MarkInfoController {
	@Resource(name="markInfoServiceImpl")
	private MarkInfoService markInfoService;
	@Resource(name="markServiceImpl")
	private MarkService markService;
	@Resource(name="userMoneyServiceImpl")
	private UserMoneyService userMoneyService;
	@Resource(name="redenvelopesServiceImpl")
	private RedenvelopesService redenvelopesService;
	@Resource(name="investServiceImpl")
	private InvestService investService;
	@Resource(name="refundRecordServiceImpl")
	private RefundRecordService refundRecordService;
	@Resource(name="applyforServiceImpl")
	private ApplyforService applyforService;
	
	//查询标List
	@SystemControllerLog(description="查询标")
	@RequestMapping("markInfoes")
	public String listMarkInfo(@RequestParam(value="currentPage",defaultValue="1",required=false)Integer currentPage,Model model) {
		List<Mark> marks = markService.list();
		PageBean<MarkInfo> markInfos = markInfoService.listAll(currentPage);
		model.addAttribute("marks", marks);
		model.addAttribute("markInfos", markInfos);
		//累计投资交易金额
		DecimalFormat df = new DecimalFormat("0.00");
		Double sumMoney = markInfoService.sumMoney();
		model.addAttribute("sumMoney", df.format(sumMoney/10000));
		//用户累计赚取收益
		double sumZqmoney = userMoneyService.sumZqmoney();
		model.addAttribute("sumZqmoney", df.format(sumZqmoney/10000));
		return "/frontpage/addInvest";
	}
	//根据标型查询List
	@SystemControllerLog(description="根据标型查询")
	@RequestMapping("listMarkInfoByMarkid")
	public String listMarkInfoByMarkid(@ModelAttribute("markid")Integer markid,
			@RequestParam(name="currPage",defaultValue="1",required=false)Integer currPage,Model model){
		if(markid!=null) {
			Mark mark = markService.getById(markid);
			model.addAttribute("mark", mark);
			PageBean<MarkInfo> listMarkInfo = markInfoService.pageByMark(markid, currPage);
			model.addAttribute("listMarkInfo", listMarkInfo);
			DecimalFormat df = new DecimalFormat("0.00");
			double sumMoney = markInfoService.sumMoney();
			model.addAttribute("sumMoney", df.format(sumMoney/10000));
			//平台为用户赚取金额
			double sumZqmoney = userMoneyService.sumZqmoney();
			model.addAttribute("sumZqmoney", df.format(sumZqmoney/10000));
			return "/frontpage/markInfoList";
		}
		return null;
	}
	//还款页面
	@SystemControllerLog(description="还款页面")
	@RequestMapping("info")
	public String info(@ModelAttribute("markid")Integer markid,@ModelAttribute("id")Integer id,
			@RequestParam(name="curPage",defaultValue="1",required=false)Integer curPage,
			@RequestParam(name="currentPage",defaultValue="1",required=false)Integer currentPage,Model model) {
		Mark mark = markService.getById(markid);
		model.addAttribute("mark", mark);
		MarkInfo markInfo = markInfoService.getById(id);
		model.addAttribute("markInfo", markInfo);
		PageBean<Invest> investList = investService.listByTmarkid(markInfo.getId(), curPage); 
		model.addAttribute("investList",investList);
		PageBean<RefundRecord> refundRecordPage = refundRecordService.refundRecordPage(markInfo.getId(), currentPage);
		model.addAttribute("refundRecordPage",refundRecordPage);
		model.addAttribute("summoney",refundRecordService.bxSumMoney(markInfo.getId()));
		Date datea = refundRecordService.xqRefundtime(markInfo.getId());
		long tnumber = DateUtils.pastDays(datea);
		model.addAttribute("xqtime", datea);
		model.addAttribute("tnumber", -tnumber);
		Applyfor applyfor = applyforService.getById(markInfo.getApplyforid());
		model.addAttribute("applyfor", applyfor);
		return "/frontpage/info";
	}
	//投标页面
	@SystemControllerLog(description="投标页面")
	@RequestMapping("info2")
	public String info2(@ModelAttribute("markid")Integer markid,@ModelAttribute("id")Integer id,
			@RequestParam(name="curPage",defaultValue="1",required=false)Integer curPage,HttpSession session,Model model) {
		User u = (User) session.getAttribute("user");
		if(u!=null) {
			UserMoney userMoney = userMoneyService.getByuserid(u.getId());
			model.addAttribute("userMoney", userMoney);
			List<Redenvelopes> redeList = redenvelopesService.getByUserid(u.getId());
			model.addAttribute("redeList", redeList);
		}
		Mark mark = markService.getById(markid);
		model.addAttribute("mark", mark);
		MarkInfo markInfo2 = markInfoService.getById(id);
		model.addAttribute("markInfo2", markInfo2);
		PageBean<Invest> investList = investService.listByTmarkid(markInfo2.getId(), curPage); 
		model.addAttribute("investList",investList);
		Applyfor applyfor = applyforService.getById(markInfo2.getApplyforid());
		model.addAttribute("applyfor", applyfor);
		return "/frontpage/info2";
	}
	
}
