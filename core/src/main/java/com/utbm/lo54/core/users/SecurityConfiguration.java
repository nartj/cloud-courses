package com.utbm.lo54.core.users;

import com.utbm.lo54.core.users.domain.Role;
import com.utbm.lo54.core.users.handler.CustomSuccessHandler;
import com.utbm.lo54.core.users.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("usersDataSource")
    private DataSource usersDataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder users = User.builder();

        auth.jdbcAuthentication().dataSource(usersDataSource)
                .withUser(users
                                .username("admin")
                                .password(bCryptPasswordEncoder().encode("admin"))
                                .roles("USER", "ADMIN")
                                .build())
                .withUser(users
                                .username("user")
                                .password(bCryptPasswordEncoder().encode("user"))
                                .roles("USER").build())
                .passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("**/list", "**/client/save")
                        .access("hasRole('USER')")
                .antMatchers("/**")
                        .access("hasRole('ADMIN')")
                .and()
                        .formLogin()
                        .loginPage("/login")
                        .usernameParameter("ssoId")
                        .passwordParameter("password")
                .and()
                        .exceptionHandling()
                        .accessDeniedPage("/Access_Denied");

        http.csrf().disable();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
