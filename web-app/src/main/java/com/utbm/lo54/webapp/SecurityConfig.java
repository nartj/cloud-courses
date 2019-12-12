package com.utbm.lo54.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
//@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
@EnableGlobalAuthentication
@Order(0)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        //Implementing Token based authentication in this filter
//        final TokenAuthenticationFilter tokenFilter = new TokenAuthenticationFilter();
//        http.addFilterBefore(tokenFilter, Bear.class);
        http
//                .authorizeRequests()
//                .antMatchers("/")
//                .permitAll()
//                .and()
                .csrf()
                .disable()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/authenticate")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");
//        http
//                .csrf().disable()
//                .httpBasic().disable()
//                .formLogin().disable()
//                .authorizeRequests()
//                .anyRequest()
//                .permitAll()
//                .and();

        // @formatter:on
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()                                               // static users
                .withUser("admin").password("{noop}admin").roles("USER", "ADMIN")
                .and()
                .withUser("anonymous").password("{noop}anonymous").roles("USER")
                .and()
                .withUser("professor").password("{noop}professor").roles("USER", "PROFESSOR");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http.authorizeExchange().anyExchange().permitAll();
//        return http.build();
//    }


//    @Bean("oauth2RestTemplate")
//    public OAuth2RestTemplate oauth2RestTemplate(BaseOAuth2ProtectedResourceDetails baseOAuth2ProtectedResourceDetails) {
//        return new OAuth2RestTemplate(baseOAuth2ProtectedResourceDetails);
//    }
//
//    @Bean
//    public ResourceServerTokenServices tokenService() {
//        RemoteTokenServices tokenServices = new RemoteTokenServices();
//        tokenServices.setClientId("resource_id");
//        tokenServices.setClientSecret("resource_secret");
//        tokenServices.setCheckTokenEndpointUrl("http://<server-url>:<port>/oauth/check_token");
//        return tokenServices;
//    }
}
