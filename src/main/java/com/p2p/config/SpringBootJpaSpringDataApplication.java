package com.p2p.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration 
@ComponentScan(basePackages   = {"com.p2p"})
@EnableTransactionManagement
public class SpringBootJpaSpringDataApplication extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootJpaSpringDataApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaSpringDataApplication.class, args);
	}
	
}
