package com.utbm.lo54.locationservice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {
        "com.utbm.lo54.core.courses",
        "com.utbm.lo54.locationservice.repository",
        "com.utbm.lo54.locationservice.service",
        "com.utbm.lo54.locationservice.controller"
})
public class WebMvcConfiguration implements WebMvcConfigurer {

}