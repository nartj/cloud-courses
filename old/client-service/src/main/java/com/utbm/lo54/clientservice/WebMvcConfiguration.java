package com.utbm.lo54.clientservice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {
        "com.utbm.lo54.common.courses",
        "com.utbm.lo54.clientservice.repository",
        "com.utbm.lo54.clientservice.service",
        "com.utbm.lo54.clientservice.controller"
})
public class WebMvcConfiguration implements WebMvcConfigurer {

}