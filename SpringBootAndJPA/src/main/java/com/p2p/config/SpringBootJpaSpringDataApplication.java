package com.p2p.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootJpaSpringDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaSpringDataApplication.class, args);
	}
	
}
