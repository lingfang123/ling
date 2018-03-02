package com.jyb.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jyb.mapper.MarkInfoMapper;
import com.jyb.pojo.MarkInfo;
import com.jyb.service.MarkInfoService;
import com.jyb.util.PageBean;
@Transactional
@Service
public class MarkInfoServiceImpl implements MarkInfoService{
	@Resource
	private MarkInfoMapper markInfoMapper;

	public void add(MarkInfo t) {
		markInfoMapper.add(t);
	}

	public List<MarkInfo> list() {
		return markInfoMapper.list();
	}

	public MarkInfo getById(Integer id) {
		return markInfoMapper.getById(id);
	}

	public void update(MarkInfo t) {
		markInfoMapper.update(t);
	}

	public void delete(Integer id) {
		markInfoMapper.delete(id);
	}

	public List<MarkInfo> listByMarkid(Integer markid) {
        return markInfoMapper.listByMarkid(markid);
	}
	//查询平台已筹金额
	public double sumMoney() {
		return markInfoMapper.sumMoney();
	}

	public PageBean<MarkInfo> listAll(Integer currentPage) {
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<MarkInfo> pageBean = new PageBean<MarkInfo>();
        
        Integer pageSize = 3;
        pageBean.setCurrPage(currentPage);
        pageBean.setPageSize(pageSize);
        //查询总条数
        int totalCount = markInfoMapper.getTotal();
        pageBean.setTotalCount(totalCount);
        //查询总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        //设置从第几页开始，每页显示多少条数据
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        List<MarkInfo> lists = markInfoMapper.listAll(map);
        pageBean.setLists(lists);
        /**
         * select * from user u
         * limit #{start},#{size}
         * */
        return pageBean;
	}

	public Integer getTotal() {
		return markInfoMapper.getTotal();
	}

	public Integer getTotalBymark(Integer markid) {
		return markInfoMapper.getTotalBymark(markid);
	}

	public PageBean<MarkInfo> pageByMark(Integer markid, Integer currentPage) {
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<MarkInfo> pageBean = new PageBean<MarkInfo>();
        
        Integer pageSize = 3;
        pageBean.setCurrPage(currentPage);
        pageBean.setPageSize(pageSize);
        //查询总条数
        int totalCount = markInfoMapper.getTotalBymark(markid);
        pageBean.setTotalCount(totalCount);
        //查询总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        //设置从第几页开始，每页显示多少条数据
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("markid", markid);
        List<MarkInfo> lists = markInfoMapper.pageByMark(map);
        pageBean.setLists(lists);
        /**
         * select * from user u
         * limit #{start},#{size}
         * */
        return pageBean;
	}

	
}
