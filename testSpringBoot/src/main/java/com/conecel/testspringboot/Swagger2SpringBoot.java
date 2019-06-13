package com.conecel.testspringboot;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.conecel.testspringboot.configuration.RedisConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "com.conecel.testspringboot.main",
		"com.conecel.testspringboot.api" ,
		"com.conecel.testspringboot.configuration", 
		"io.swagger.model",
		"io.swagger.configuration",
		"com.conecel.testspringboot.service"})
public class Swagger2SpringBoot implements CommandLineRunner {

	static final Logger logger = LogManager.getLogger(Swagger2SpringBoot.class.getName());

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
    
    @Autowired
	private RedisConfig util;

	@PostConstruct
	private void initializeJedisPool() {
		logger.info("Initializing Jedis Pool");
		util.initializeJedisPool();
	}


	@PreDestroy
	private void closeJedisPool() {
		logger.info("Destroying jedisPool..");
		util.destroyJedisPool();
	}
}
