package com.icss.service.impl;

import org.springframework.stereotype.Service;

import com.icss.framework.service.impl.BaseServiceImpl;
import com.icss.model.City;
import com.icss.service.TestHibernateService;

@Service(value="testHiberService")
public class TestHibernateServiceImpl extends BaseServiceImpl implements TestHibernateService {
	@SuppressWarnings("unused")
	public void testTran() {
		City c = (City)this.findByIdHiber(City.class, "40288ad4602f7ab601602f7aff120000");
		City c1 = (City)this.findByIdHiber(City.class, "40288ad4602f7ab601602f7aff270001");
		//this.deleteHiber(c);
		this.deleteMybatis("test.mapper.deletec", null);
		//int a = 1 / 0;
		this.deleteHiber(c1);
	}
}
