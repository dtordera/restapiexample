package com.dvtrsc.restexample;

import org.apache.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/*
 *  Application. Main spring boot application entry point
 *  D.Tordera, 20171031
 */

@Configuration
@SpringBootApplication
public class Application {
			
	final static Logger logger = Logger.getLogger(Application.class);
		
	// main entry point
	public static void main(String[] args) throws Exception {
			header();
			initSpringBoot(args);	
	}
	
	private static void header()
	{
		logger.info("COM.DVTRSC.RESTAPI: REST/JSON API EXAMPLE");
		logger.info("Version 0.1");
	}
		
	private static void initSpringBoot(String[] args) throws Exception
	{
		SpringApplication.run(Application.class, args);
	}	
}
