package com.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.app.filter.CorsFilter;
import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;

@EnableWebMvc
@SpringBootApplication
//@ConfigurationProperties(value="classpath:app.properties")
//@EnableApolloConfig("application")
//@Configuration
//@EnableApolloConfig({"application","IT.datasource_mysql"})
public class ApploApplication
{
	public static void main(String[] args) {
		System.out.println("启动开始");
		try {
			ConfigurableApplicationContext ctx = SpringApplication.run(ApploApplication.class, args);
			ConfigurableEnvironment configEnv = ctx.getEnvironment();
			System.out.println("server.port:"+configEnv.getProperty("server.port"));
			System.out.println("info.artifactId:"+configEnv.getProperty("info.artifactId", ""));
			System.out.println("spring.profiles.active:"+configEnv.getProperty("spring.profiles.active", ""));
			System.out.println("分环境设置的参数，envVariable:"+configEnv.getProperty("envVariable", ""));
			System.out.println("schedul.autoAllDataUploadToSeg.cronTime:"+configEnv.getProperty("schedul.autoAllDataUploadToSeg.cronTime", ""));
			
			System.out.println("spring.rabbitmq.host:"+configEnv.getProperty("spring.rabbitmq.host", ""));
			Config config = ConfigService.getAppConfig();
			System.out.println("读取apollo配置：");
			System.out.println("druid.driver:"+config.getProperty("druid.driver", ""));
			System.out.println("druid.url:"+config.getProperty("druid.url", ""));
			System.out.println("schedul.autoAllDataUploadToSeg.cronTime:"+configEnv.getProperty("schedul.autoAllDataUploadToSeg.cronTime", ""));
			
		} catch (Exception e) {
			System.out.println("启动出错:" + e.getMessage());
		}
		System.out.println("启动完成");
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new CorsFilter());
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}
}
