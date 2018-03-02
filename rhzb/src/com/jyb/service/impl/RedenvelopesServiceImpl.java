package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.RedenvelopesMapper;
import com.jyb.pojo.Redenvelopes;
import com.jyb.service.RedenvelopesService;
@Transactional
@Service
public class RedenvelopesServiceImpl implements RedenvelopesService{
	@Resource
	private RedenvelopesMapper redenvelopesMapper;
	
	public void add(Redenvelopes t) {
		redenvelopesMapper.add(t);
	}

	public List<Redenvelopes> list() {
		return redenvelopesMapper.list();
	}

	public Redenvelopes getById(Integer id) {
		return redenvelopesMapper.getById(id);
	}

	public void update(Redenvelopes t) {
		redenvelopesMapper.update(t);
	}

	public void delete(Integer id) {
		redenvelopesMapper.delete(id);
	}

	public List<Redenvelopes> findList(Integer userid,Integer struts) {
		return redenvelopesMapper.findList(userid,struts);
	}

	public List<Redenvelopes> getByUserid(Integer userid) {
		return redenvelopesMapper.getByUserid(userid);
	}

	
}
