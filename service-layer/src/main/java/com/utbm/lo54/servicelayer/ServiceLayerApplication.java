package com.utbm.lo54.servicelayer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.utbm.lo54.common.domain.courses", "com.utbm.lo54.servicelayer"}, exclude = {UserDetailsServiceAutoConfiguration.class, org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class })
@EntityScan("com.utbm.lo54.common.domain.courses")
@EnableEurekaClient
public class ServiceLayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceLayerApplication.class, args);
	}

}
