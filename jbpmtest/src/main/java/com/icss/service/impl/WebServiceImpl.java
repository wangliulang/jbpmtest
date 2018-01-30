package com.icss.service.impl;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.icss.service.IWebService;

//@WebService(endpointInterface="com.chy.ws.service.HelloServiceImpl")
@WebService
public class WebServiceImpl extends SpringBeanAutowiringSupport implements IWebService{

	private static final Logger logger = Logger.getLogger(WebServiceImpl.class);
	
	
	
	public String getAppointment(String xmlStr) {
		return "<error>系统错误</error>";
	}
	
	
}
