package com.jyb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.jyb.mapper.DetailMapper;
import com.jyb.pojo.Detail;
import com.jyb.service.DetailService;
import com.jyb.util.PageBean;
import com.jyb.util.PageInfoUtil;
@Transactional
@Service
public class DetailServiceImpl implements DetailService{
	@Resource
	private DetailMapper detailMapper;
	public void add(Detail t) {
		detailMapper.add(t);
	}
	public List<Detail> list() {
		return detailMapper.list();
	}
	public Detail getById(Integer id) {
		return detailMapper.getById(id);
	}
	public void update(Detail t) {
		detailMapper.update(t);
	}
	public void delete(Integer id) {
		detailMapper.delete(id);
	}
	public Integer getTotal(int id) {
		return detailMapper.getTotal(id);
	}
	public void selectPage(PageInfoUtil pageInfoUtil,Detail detail) {
		//传一个分页的bean
		Page<Detail> page = new Page(pageInfoUtil.getNowpage(),pageInfoUtil.getSize());
		List<Detail> listPage=detailMapper.selectPage(page,page.getCondition());
		pageInfoUtil.setRows(listPage);
		pageInfoUtil.setTotal(listPage.size());
	}
	public PageBean<Detail> findAll(Integer currentPage,Integer userid) {
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Detail> pageBean = new PageBean<Detail>();
        
        Integer pageSize = 5;
        pageBean.setCurrPage(currentPage);
        pageBean.setPageSize(pageSize);
        //查询总条数
        int totalCount = detailMapper.getTotal(userid);
        pageBean.setTotalCount(totalCount);
        //查询总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        //设置从第几页开始，每页显示多少条数据
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("userid", userid);
        List<Detail> lists = detailMapper.findAll(map);
        pageBean.setLists(lists);
        /**
         * select * from user u
         * limit #{start},#{size}
         * */
        return pageBean;
	}
	@Override
	public Integer getTotal() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Detail> getListByUserid(Integer userid) {
		return detailMapper.getListByUserid(userid);
	}
	
	

}
