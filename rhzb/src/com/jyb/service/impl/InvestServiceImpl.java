package com.jyb.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.InvestMapper;
import com.jyb.pojo.Invest;
import com.jyb.service.InvestService;
import com.jyb.util.PageBean;
@Transactional
@Service
public class InvestServiceImpl implements InvestService{
	@Resource
	private InvestMapper investMapper;
	public void add(Invest t) {
		investMapper.add(t);
	}
	public List<Invest> list() {
		return investMapper.list();
	}
	public Invest getById(Integer id) {
		return investMapper.getById(id);
	}
	public void update(Invest t) {
		investMapper.update(t);
	}
	//删除
	public void delete(Integer id) {
		investMapper.delete(id);
	}

	//根据userid、状态（status）查询list
	public PageBean<Invest> listByUseridWithStatus(Integer userid,Integer status,Integer currentPage) {
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Invest> pageBean = new PageBean<Invest>();
        
        Integer pageSize = 3;
        pageBean.setCurrPage(currentPage);
        pageBean.setPageSize(pageSize);
        //查询总条数
        int totalCount = investMapper.getTotal(userid,status);
        pageBean.setTotalCount(totalCount);
        //查询总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        //设置从第几页开始，每页显示多少条数据
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("userid", userid);
        map.put("status", status);
        List<Invest> list = investMapper.listByUseridWithStatus(map);
        pageBean.setLists(list);
        /**
         * select * from user u
         * limit #{start},#{size}
         * */
        return pageBean;
	}

	//查询累计投资
	public double getAllCorpus(Integer userid) {
		return investMapper.getAllCorpus(userid);
	}
	
	//查询累计收益
	public double getAllLucre(Integer userid, Integer status) {
		return investMapper.getAllLucre(userid, status);
	}

	//查询待收本金
	public double getWaitCorpus(Integer userid, Integer status) {
		return investMapper.getWaitCorpus(userid, status);
	}

	//查询待收收益
	public double getWaitLucre(Integer userid, Integer status) {
		return investMapper.getWaitLucre(userid, status);
	}
	//查询总记录数
	public Integer getTotal(Integer userid,Integer status) {
		return investMapper.getTotal(userid,status);
	}
	
	public List<Invest> getMonthBidTime(String bidtime) {
		return investMapper.getMonthBidTime(bidtime);
	}
	
	public PageBean<Invest> listByTmarkid(Integer tmarkid,Integer currentPage) {
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Invest> pageBean = new PageBean<Invest>();
        
        Integer pageSize = 1;
        pageBean.setCurrPage(currentPage);
        pageBean.setPageSize(pageSize);
        //查询总条数
        int totalCount = investMapper.getTotalBytmarkid(tmarkid);
        pageBean.setTotalCount(totalCount);
        //查询总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        //设置从第几页开始，每页显示多少条数据
        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("tmarkid", tmarkid);
        List<Invest> list = investMapper.listByTmarkid(map);
        pageBean.setLists(list);
        /**
         * select * from user u
         * limit #{start},#{size}
         * */
        return pageBean;
	}
	public Integer getTotalBytmarkid(Integer tmarkid) {
		return investMapper.getTotalBytmarkid(tmarkid);
	}
	@Override
	public List<Invest> getBytmakid(Integer tmkid) {
		return investMapper.getBytmakid(tmkid);
	}
	@Override
	public Integer getmaney(Integer makid) {
		return investMapper.getmaney(makid);
	}

	
	public List<Invest> getByInvestTmarkid(Integer tmarkid) {
		return investMapper.getByInvestTmarkid(tmarkid);
	}
	public List<Invest> investPoi(Integer userid) {
		return investMapper.investPoi(userid);
	}
	@Override
	public List<Invest> getByUserid(Integer userid) {
		// TODO Auto-generated method stub
		return investMapper.getByUserid(userid);
	}
}
