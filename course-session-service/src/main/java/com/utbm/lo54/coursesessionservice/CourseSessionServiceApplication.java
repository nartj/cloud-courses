package com.utbm.lo54.coursesessionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CourseSessionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseSessionServiceApplication.class, args);
	}

}
