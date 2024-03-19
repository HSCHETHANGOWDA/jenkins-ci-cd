package com.javatechie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//(exclude = SecurityAutoConfiguration.class) 
//This is the one way to disable the spring security auto 
//configuration other way is mentioning in the application.properties
public class JenkinsCiCdApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(JenkinsCiCdApplication.class, args);
	}

}
