package com.utbm.lo54.coursesessionservice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {
        "com.utbm.lo54.core.courses",
        "com.utbm.lo54.coursesessionservice.repository",
        "com.utbm.lo54.coursesessionservice.service",
        "com.utbm.lo54.coursesessionservice.controller"
})
public class WebMvcConfiguration implements WebMvcConfigurer {

}