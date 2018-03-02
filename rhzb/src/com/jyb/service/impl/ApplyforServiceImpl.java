package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.ApplyforMapper;
import com.jyb.pojo.Applyfor;
import com.jyb.service.ApplyforService;
@Transactional
@Service
public class ApplyforServiceImpl implements ApplyforService {
	@Resource
	private ApplyforMapper applyforMapper;
	public void add(Applyfor t) {
		applyforMapper.add(t);
	}
	public List<Applyfor> list() {
		return applyforMapper.list();
	}
	public Applyfor getById(Integer id) {
		return applyforMapper.getById(id);
	}
	public void update(Applyfor t) {
		applyforMapper.update(t);
	}
	public void delete(Integer id) {
		applyforMapper.delete(id);
	}
}
