package com.starline.starline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class StarlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarlineApplication.class, args);
	}

	}
