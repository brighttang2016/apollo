/**
 * 
 */
package com.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test{
	@Value("${spring.rabbitmq.host}")
	private String host;
	
	@Value("${druid.url}")
	private String druidUrl;
	
	@GetMapping(value = "/test")
	public String  gpsInfo() {
		System.out.println("test,spring.rabbitmq.host:"+host);
		System.out.println("test,druid.url:"+druidUrl);
		return "测试";

	}



}