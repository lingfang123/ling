package com.jyb.controller;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.jyb.pojo.Invest;
import com.jyb.pojo.Mark;
import com.jyb.pojo.Province;
import com.jyb.pojo.User;
import com.jyb.scatter.ScatterGuo;
import com.jyb.service.InvestService;
import com.jyb.service.MarkInfoService;
import com.jyb.service.MarkService;
import com.jyb.service.ProvinceService;
import com.jyb.service.UserService;
import com.jyb.util.DateUtil;
import com.jyb.util.StringSplitUtil;

@Controller
@RequestMapping("companyReportForm")
public class CompanyReportFormController {
	// 用户user
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@Resource(name="markInfoServiceImpl")
	private MarkInfoService markInfoService;
	
	// 投资记录
	@Resource(name="investServiceImpl")
	private InvestService investService;
	
	// 理财类型
	@Resource(name="markServiceImpl")
	private MarkService markService;
	
	// 省份
	@Resource(name="provinceServiceImpl")
	private ProvinceService provinceService;
	
	// 查询运营报告1-12月图片页
	@RequestMapping("selectCompanyReportForm")
	public String selectCompanyReportForm() {
		return "/frontpage/companyReportForm";
	}
	
	// 查询运营报告单月份详情页面
	@RequestMapping("selectCompanyReportForm2/num/{num}")
	public String selectCompanyReportForm2(@PathVariable("num") String num,Model model) throws ParseException {
		
		List<User> listUser = userService.list();
		
		StringSplitUtil ssUtil = new StringSplitUtil();
		// 切割好的时间     如 2017-01 格式
		String numTimer = ssUtil.StringNum(num);
		
		DateUtil dateUtil = new DateUtil();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		// 把页面传来的数变成  时间类型
		Date month = sdf.parse(numTimer);
		// 调用工具类 得到这个月的最后一天
		Date lDate = dateUtil.getLastDayOfMonth(month);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		// 把得到的最后一天 转化成   2018-01-31 的样子 
		String newLastDay = format.format(lDate);
		
		//查询注册总人数
		Integer userCount =userService.userCount();
		
		// 按月份查询注册人数
		List<User> listMonth = userService.getMonthUserNum(numTimer);
		// 该月注册人数
		Integer listMonthSize = listMonth.size();

		
		// 分别累加出 总的 男女人数
		Integer man = 0;
		Integer woman = 0;
		for(int i=0;i<listUser.size();i++) {
			if(listUser.get(i).getSex()==0) {
				woman += 1;
			}
			if(listUser.get(i).getSex()==1) {
				man += 1;
			}
		}
		
		//查询平台已筹金额
		Double sumMoney = markInfoService.sumMoney();
		
		// 通过参数 numTimer 模糊查询到该月记录
		List<Invest> listInvestMonth = investService.getMonthBidTime(numTimer);
		// 该月投资记录
		Integer listInvestMonthSize = listInvestMonth.size();
		// 用来存放该月投资金额
		Double monthMoneyAll = 0.0;
		// 存放该月 投资用户的ID
		List numList = new ArrayList<>();
		for(int i=0;i<listInvestMonth.size();i++) {
			numList.add(listInvestMonth.get(i).getUserid());
			monthMoneyAll += listInvestMonth.get(i).getMarkmoney();
		}
		// 除去重复的用户ID
		HashSet h = new HashSet(numList);   
		numList.clear();   
		numList.addAll(h);
		// 该月投资人数
		Integer numListSize = numList.size();
		
		
		// 平台总投资记录 
		List<Invest> listInvestAll = investService.list();
		List numListAll = new ArrayList<>();
		for(int i=0;i<listInvestAll.size();i++) {
			numListAll.add(listInvestAll.get(i).getUserid());
		}
		// 除去重复的用户ID
		HashSet hs = new HashSet(numListAll);
		numListAll.clear();
		numListAll.addAll(hs);
		// 总投资人数
		Integer numListAllSize = numListAll.size();
		
		// 该月人均投资金额
		Double moneyMonthAverage = monthMoneyAll/numListSize;
		String MonthAverage;
		if(Double.isNaN(moneyMonthAverage)) {
			MonthAverage = "0.00";
		}else {
			DecimalFormat decimalFormat = new DecimalFormat("0.00");
			MonthAverage = decimalFormat.format(moneyMonthAverage);
		}
		
		
		// 该月笔均投资金额
		Double moneyPen = monthMoneyAll/listInvestMonthSize;
		String pen;
		//NAN表示非数字，它与任何值都不相等，甚至不等于它自己，所以要判断一个数是否为NAN要用isNAN方法
		if(Double.isNaN(moneyPen)) {
			pen = "0.00";
		}else{
			DecimalFormat dFormat = new DecimalFormat("0.00");
			pen = dFormat.format(moneyPen);
		}
		
		
		// 查询理财类型  标型
		List<Mark> listMark = markService.list();
		List<String> markName = new ArrayList<>();
		for(int i=0;i<listMark.size();i++) {
			markName.add(listMark.get(i).getMarkname());
		}
		
		// 存放 固收理财 总金额
		Double MarkMoney1 = 0.0;
		// 存放 基金理财 总金额
		Double MarkMoney2 = 0.0;
		for(int i=0;i<listInvestAll.size();i++) {
			if(listInvestAll.get(i).getMarkid()==1) {
				MarkMoney1 += listInvestAll.get(i).getMarkmoney();
			}
			if(listInvestAll.get(i).getMarkid()==2) {
				MarkMoney2 += listInvestAll.get(i).getMarkmoney();
			}
		}
		// 理财金额
		List listMarkMoney = new ArrayList<>();
		listMarkMoney.add(MarkMoney1);
		listMarkMoney.add(MarkMoney2);
		
		//查询全国地理注册人数分布
		List<Province> list = provinceService.list();
		List<ScatterGuo> scatterGuos = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			ScatterGuo scatterGuo = new ScatterGuo();
			scatterGuo.setName(list.get(i).getProvinceName());
			scatterGuo.setValue(userService.getByUserPid(list.get(i).getPid())+10000);
			scatterGuos.add(scatterGuo);
		}
		String scatter = JSON.toJSON(scatterGuos).toString();
		//System.out.println(scatter);
		model.addAttribute("scatter", scatter);
		
		
		// 理财金额
		model.addAttribute("listMarkMoney", listMarkMoney);
		// 理财类型
		model.addAttribute("markName", markName);
		// 该月笔均投资金额
		model.addAttribute("pen", pen);
		// 该月人均投资金额
		model.addAttribute("MonthAverage", MonthAverage);
		// 该月累计投资额
		model.addAttribute("monthMoneyAll",monthMoneyAll);
		// 总投资人数
		model.addAttribute("numListAllSize",numListAllSize);
		// 该月投资人数
		model.addAttribute("numListSize", numListSize);
		// 该月注册人数
		model.addAttribute("listMonthSize", listMonthSize);
		// 注册总人数
		model.addAttribute("userCount", userCount);
		// 该月的最后一天
		model.addAttribute("newLastDay",newLastDay);
		// 总投资金额
		model.addAttribute("sumMoney",sumMoney);
		// 总的男女人数
		model.addAttribute("man", man);
		model.addAttribute("woman", woman);

		
		return "/frontpage/companyReportForm2";
	}
}
