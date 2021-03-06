//package com.utbm.lo54.zuul;
//
//import javax.servlet.http.HttpServletResponse;
//
//import com.utbm.lo54.common.security.JwtAuthenticationConfig;
//import com.utbm.lo54.common.security.JwtTokenAuthenticationFilter;
//import com.utbm.lo54.common.security.JwtUsernamePasswordAuthenticationFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
///**
// * Config role-based auth.
// *
// * @author shuaicj 2017/10/18
// */
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private JwtAuthenticationConfig config;
//
////    @Bean
////    public JwtAuthenticationConfig jwtConfig() {
////        return new JwtAuthenticationConfig();
////    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser("admin").password(encoder.encode("admin")).roles("ADMIN", "USER").and()
//                .withUser("shuaicj").password(encoder.encode("shuaicj")).roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .csrf().disable()
//                .logout().disable()
//                .formLogin().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .anonymous()
//                .and()
//                .exceptionHandling().authenticationEntryPoint(
//                (req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
//                .and()
//                .addFilterAfter(new JwtTokenAuthenticationFilter(config),
//                        UsernamePasswordAuthenticationFilter.class)
//                .authorizeRequests()
//                .antMatchers(config.getUrl()).permitAll()
//                .antMatchers("/api/user/**").permitAll()
//                .antMatchers("/api/package/**").hasRole("USER")
//                .antMatchers("/api/dashboard/**").hasRole("USER")
//                .antMatchers("/api/records/**").hasRole("USER");
//    }
//}