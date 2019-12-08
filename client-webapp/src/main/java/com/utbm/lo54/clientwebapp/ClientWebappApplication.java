package com.utbm.lo54.clientwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class })
public class ClientWebappApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
		return builder.sources(ClientWebappApplication.class);
	}

	public static void main (String[] args) {

		SpringApplication app =
				new SpringApplication(ClientWebappApplication.class);
		app.run(args);
	}

}

