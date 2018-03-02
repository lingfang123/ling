package com.jyb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jyb.mapper.LogsMapper;
import com.jyb.pojo.Logs;
import com.jyb.service.LogsService;
@Transactional
@Service
public class LogsServiceImpl implements LogsService {

	@Resource
	private LogsMapper logsMapper;

	@Override
	public void add(Logs t) {
		logsMapper.add(t);

	}

	@Override
	public List<Logs> list() {
		return logsMapper.list();
	}

	@Override
	public Logs getById(Integer id) {
		return logsMapper.getById(id);
	}

	@Override
	public void update(Logs t) {
		logsMapper.update(t);

	}

	@Override
	public void delete(Integer id) {
		logsMapper.delete(id);

	}

}
