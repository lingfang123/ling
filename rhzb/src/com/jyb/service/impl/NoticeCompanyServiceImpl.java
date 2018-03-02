package com.jyb.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.NoticeCompanyMapper;
import com.jyb.pojo.NoticeCompany;
import com.jyb.service.NoticeCompanyService;
import com.jyb.util.PageBean;

@Transactional
@Service
public class NoticeCompanyServiceImpl implements NoticeCompanyService{

	@Resource
	private NoticeCompanyMapper noticeCompanyMapper;
	
	@Override
	public void add(NoticeCompany t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NoticeCompany> list() {
		return noticeCompanyMapper.list();
	}
	@Override
	public NoticeCompany getById(Integer id) {
		return noticeCompanyMapper.getById(id);
	}

	@Override
	public void update(NoticeCompany t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<NoticeCompany> noticeCompanyList(Integer type) {
		
		return noticeCompanyMapper.noticeCompanyList(type);
	}

	@Override
	public PageBean<NoticeCompany> listAll(Integer currentPage) {
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<NoticeCompany> pageBean = new PageBean<NoticeCompany>();
        
        Integer pageSize = 10;
        pageBean.setCurrPage(currentPage);
        pageBean.setPageSize(pageSize);
        //查询总条数
        int totalCount = noticeCompanyMapper.getTotal();
        pageBean.setTotalCount(totalCount);
        //查询总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        //设置从第几页开始，每页显示多少条数据
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        List<NoticeCompany> lists = noticeCompanyMapper.listAll(map);
        pageBean.setLists(lists);
        /**
         * select * from user u
         * limit #{start},#{size}
         * */
        return pageBean;
	}

	@Override
	public Integer getTotal() {
		return noticeCompanyMapper.getTotal();
	}

}
