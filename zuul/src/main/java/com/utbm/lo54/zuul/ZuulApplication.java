package com.utbm.lo54.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(scanBasePackages = {"com.utbm.lo54.common", "com.utbm.lo54.zuul"}, exclude = {UserDetailsServiceAutoConfiguration.class })
@EnableZuulProxy
@EnableEurekaClient
@EntityScan({"com.utbm.lo54.common.domain.security", "com.utbm.lo54.zuul.domain"})
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

}
