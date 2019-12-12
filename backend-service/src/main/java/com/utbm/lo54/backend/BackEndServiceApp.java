package com.utbm.lo54.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.utbm.lo54.common.domain.courses", "com.utbm.lo54.backend"}, exclude = {UserDetailsServiceAutoConfiguration.class })
@EntityScan("com.utbm.lo54.common.domain.courses")
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class BackEndServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(BackEndServiceApp.class, args);
	}

}
