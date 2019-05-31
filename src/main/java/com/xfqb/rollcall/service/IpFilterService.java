package com.xfqb.rollcall.service;

import java.util.List;

import com.xfqb.rollcall.entity.IpFilter;

public interface IpFilterService {
	
	boolean addIpFilter(IpFilter ipFilter);
	
	List<IpFilter> getIpFilterAll(IpFilter ipFilter);
	
	
}
