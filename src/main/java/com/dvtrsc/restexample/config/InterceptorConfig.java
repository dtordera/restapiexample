package com.dvtrsc.restexample.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.dvtrsc.restexample.interceptors.UidInterceptor;
import com.dvtrsc.restexample.interceptors.ValidationInterceptor;

/*
 * InterceptorConfig. Request interceptors configuration & registry
 * D.Tordera, 20171031
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	private final static Logger logger = Logger.getLogger(InterceptorConfig.class);
	
	@Autowired
	ValidationInterceptor validationinterceptor;
	
	@Autowired
	UidInterceptor uidinterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry)
	{
		logger.info("Configurating custom interceptors");
		logger.info("Adding uidinterceptor");		
		registry.addInterceptor(uidinterceptor).addPathPatterns("/**");
		
		logger.info("Adding validationinterceptor");		
		registry.addInterceptor(validationinterceptor)
			.addPathPatterns("/ping//**")	// use at ping with echo... 
			.excludePathPatterns("/ping")	// ... except raw ping
			;
		
		logger.info("All ok!");
	}
}
