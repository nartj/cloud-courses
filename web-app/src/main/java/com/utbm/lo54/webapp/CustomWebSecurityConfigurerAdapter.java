//package com.utbm.lo54.cloudcourseswebapp;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//@Configuration
//@Order(1)
//public class CustomWebSecurityConfigurerAdapter
//        extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .addFilterBefore(
//                        new CustomFilter(), BasicAuthenticationFilter.class)
//                .authorizeRequests()
//                .antMatchers("/login", "/registration").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable();
//    }
//}
