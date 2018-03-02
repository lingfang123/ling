package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.MarkMapper;
import com.jyb.pojo.Mark;
import com.jyb.service.MarkService;
@Transactional
@Service
public class MarkServiceImpl implements MarkService{
	@Resource
	private MarkMapper markMapper;
	
	public void add(Mark t) {
		markMapper.add(t);
	}

	public List<Mark> list() {
		return markMapper.list();
	}

	public Mark getById(Integer id) {
		return markMapper.getById(id);
	}

	public void update(Mark t) {
		markMapper.update(t);
	}

	public void delete(Integer id) {
		markMapper.delete(id);
	}
	public List<Mark> markList() {
		return markMapper.markList();
	}
	
	
	
}
