package com.jyb.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.NewCompanyMapper;
import com.jyb.pojo.NewCompany;
import com.jyb.service.NewCompanyService;
import com.jyb.util.PageBean;
@Transactional
@Service
public class NewCompanyServiceImpl implements NewCompanyService{
	@Resource
	private NewCompanyMapper newcompanyMapper;
	
	@Override
	public void add(NewCompany t) {
		// TODO Auto-generated method stub
		
	}

	public List<NewCompany> list() {
		return newcompanyMapper.list();
	}

	@Override
	public NewCompany getById(Integer id) {
		return newcompanyMapper.getById(id);
	}

	@Override
	public void update(NewCompany t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NewCompany> listNewInfo(Integer type) {
		return newcompanyMapper.listNewInfo(type);
	}

	@Override
	public PageBean<NewCompany> listAll(Integer currentPage) {
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<NewCompany> pageBean = new PageBean<NewCompany>();
        
        Integer pageSize = 10;
        pageBean.setCurrPage(currentPage);
        pageBean.setPageSize(pageSize);
        //查询总条数
        int totalCount = newcompanyMapper.getTotal();
        pageBean.setTotalCount(totalCount);
        //查询总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        //设置从第几页开始，每页显示多少条数据
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        List<NewCompany> lists = newcompanyMapper.listAll(map);
        pageBean.setLists(lists);
        /**
         * select * from user u
         * limit #{start},#{size}
         * */
        return pageBean;
	}

	@Override
	public Integer getTotal() {
		return newcompanyMapper.getTotal();
	}

}
