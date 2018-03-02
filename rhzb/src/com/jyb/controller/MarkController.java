package com.jyb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jyb.annotation.SystemControllerLog;
import com.jyb.pojo.Mark;
import com.jyb.service.MarkService;
/**
 * 标型表(t_mark)Controller
 * */
@Controller
@RequestMapping("mark")
public class MarkController {
	@Resource(name="markServiceImpl")
	private MarkService markService;
	
	//新增
	public String addMark(Mark t) {
		markService.add(t);
		return null;
	}
	//查询List
	public String listMark() {
		markService.list();
		return null;
	}
	@SystemControllerLog(description="marklsit")
	@RequestMapping("marklsit")
	@ResponseBody
	public Map<String,Object> markList(){
		HashMap<String, Object> result = new HashMap<String, Object>();
		List<Mark> markList = markService.markList();
		result.put("markList", markList);
		return result;
	}
	//根据ID查询单个
	public String getMarkById(@ModelAttribute("id")Integer id) {
		markService.getById(id);
		return null;
	}
	//更新
	public String updateMark(Mark t) {
		markService.update(t);
		return null;
	}
	//删除
	public String deleteMark(@ModelAttribute("id")Integer id) {
		markService.delete(id);
		return null;
	}
}
