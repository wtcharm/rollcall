package com.xfqb.rollcall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xfqb.rollcall.entity.IpFilter;
import com.xfqb.rollcall.mapper.IpFilterMapper;
import com.xfqb.rollcall.service.IpFilterService;
@Service
public class IpFilterServiceImpl implements IpFilterService {
	
	@Autowired
	private IpFilterMapper ipFilterMapper;
	
	/**
	 * 添加数据
	 * @param ipFilter
	 * @return
	 * @author: tao wang
	 * @date:   2019年4月29日
	 */
	@Override
	public boolean addIpFilter(IpFilter ipFilter) {
		return this.ipFilterMapper.insert(ipFilter)> 0 ? true : false;
	}

	/**
	 * 查询数据
	 * @param ipFilter
	 * @return
	 * @author: tao wang
	 * @date:   2019年4月29日
	 */
	@Override
	public List<IpFilter> getIpFilterAll(IpFilter ipFilter) {
		return this.ipFilterMapper.select(ipFilter);
	}

}
