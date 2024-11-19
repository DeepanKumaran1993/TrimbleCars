package com.trimblecars.leaseManagement;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.trimblecars.*")
//@EnableSwagger2
public class LeaseManagementApplication {

	private static Logger logger=LoggerFactory.getLogger(LeaseManagementApplication.class);
	public static void main(String[] args) {
		logger.info("info Level Log");
		logger.atInfo();
		SpringApplication.run(LeaseManagementApplication.class, args);
	}

}
