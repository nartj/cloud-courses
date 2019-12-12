package com.utbm.lo54.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableOAuth2Client
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CloudCourseWebApp {



	public static void main (String[] args) {

		SpringApplication app =
				new SpringApplication(CloudCourseWebApp.class);
		app.run(args);
	}

}

