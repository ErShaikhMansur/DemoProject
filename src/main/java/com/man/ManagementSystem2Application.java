package com.man;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
public class ManagementSystem2Application {

	
	public static void main(String[] args) {
		SpringApplication.run(ManagementSystem2Application.class, args);
		System.out.println("Management Application is Runnng.....");
	}
}
