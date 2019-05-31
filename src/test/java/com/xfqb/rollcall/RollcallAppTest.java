package com.xfqb.rollcall;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xfqb.rollcall.entity.IpFilter;
import com.xfqb.rollcall.service.IpFilterService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RollcallApplication.class)
@EnableAutoConfiguration
public class RollcallAppTest {

	@Autowired
	private IpFilterService ipFilterService;


	@Test
	public void testAddFiler() {
		IpFilter ipFilter = new IpFilter();
		ipFilter.setCreateTime(new Date());
		ipFilter.setDr(0);
		ipFilter.setMark(0);
		ipFilter.setIp("192.168.10.16");
		ipFilter.setModule("sino-bankflow");
		boolean add = this.ipFilterService.addIpFilter(ipFilter);
		System.err.println("添加成功" + add); 
	}

	@Test
	public void testGetFilerAll() {

		IpFilter ipFilter = new IpFilter();
		ipFilter.setDr(0);
		ipFilter.setMark(0);
		ipFilter.setIp("192.168.10.16");
		ipFilter.setModule("sino-bankflow");
		List<IpFilter> all = this.ipFilterService.getIpFilterAll(ipFilter);
		for (IpFilter ipFilter2 : all) {
			System.err.println("ipFilter2" + ipFilter2.toString()) ;
		}

	}
}
