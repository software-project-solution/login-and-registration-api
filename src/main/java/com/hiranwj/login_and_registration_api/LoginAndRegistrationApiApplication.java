package com.hiranwj.login_and_registration_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LoginAndRegistrationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginAndRegistrationApiApplication.class, args);
	}

}
