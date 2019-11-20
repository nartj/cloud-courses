package com.utbm.lo54.courseservice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {
        "com.utbm.lo54.core.courses",
        "com.utbm.lo54.courseservice.repository",
        "com.utbm.lo54.courseservice.service",
        "com.utbm.lo54.courseservice.controller"
})
public class WebMvcConfiguration implements WebMvcConfigurer {

}