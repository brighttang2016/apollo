package com.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidConfig {

	@Value("${druid.url}")
	private String url;
	@Value("${druid.username}")
	private String username;
	@Value("${druid.password}")
	private String password;
	@Value("${druid.driver}")
	private String driver;
	
	@Value("${druid.initial-size}")
	private int initialSize;
	@Value("${druid.min-idle}")
	private int minIdle;
	@Value("${druid.max-active}")
	private int maxActive;
	
	@Bean
	@Primary
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driver);
		
		dataSource.setInitialSize(initialSize);
		dataSource.setMinIdle(minIdle);
		dataSource.setMaxActive(maxActive);
		
		return dataSource;
	}
	
}
