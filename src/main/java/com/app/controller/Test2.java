/**
 * 
 */
package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test2")
public class Test2{
//	@Value("${spring.rabbitmq.host}")
	private String host;
	
	@GetMapping(value = "/test")
	public String  gpsInfo() {
		System.out.println("test,spring.rabbitmq.host:"+host);
		return "测试";

	}



}