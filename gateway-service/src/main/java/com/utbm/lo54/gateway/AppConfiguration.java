//package com.utbm.lo54.zuul;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
//
//@Configuration
//@Order(value = 0)
//public class AppConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private ResourceServerTokenServices resourceServerTokenServices;
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/oauth/**",
//                        "/login").permitAll()
//                .anyRequest().authenticated().and()
//                .logout().permitAll().logoutSuccessUrl("/");
//    }
//}
