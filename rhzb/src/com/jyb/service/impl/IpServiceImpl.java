package com.jyb.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jyb.mapper.IpMapper;
import com.jyb.pojo.Ip;
import com.jyb.service.IpService;
@Transactional
@Service
public class IpServiceImpl implements IpService{
	@Resource
	private IpMapper IPMapper;
	@Override
	public void add(Ip t) {
	}
	@Override
	public List<Ip> list() {
		return IPMapper.list();
	}
	@Override
	public Ip getById(Integer id) {
		return null;
	}
	@Override
	public void update(Ip t) {
		IPMapper.update(t);
	}
	@Override
	public void delete(Integer id) {
	}


}
