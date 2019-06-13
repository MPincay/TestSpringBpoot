package com.conecel.testspringboot.configuration;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Log4j2Loader {

	private String log4j2DirectoryFile="C:\\Users\\HITSS\\Desktop\\GLOBAL\\config\\testSpringBoot\\log4j2.xml";

	static final Logger logger = LogManager.getLogger(Log4j2Loader.class.getName());

	@Bean
	public String init(){	
		String loggerConfig = log4j2DirectoryFile;
		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		File file = new File(loggerConfig);
		logger.info("Loading configuration log4j2..");
		context.setConfigLocation(file.toURI());
		logger.info("Loaded configuration log4j2 succesfully");
		return "OK";
	}
}
