package com.utbm.lo54.adminwebapp;

import com.utbm.lo54.security.SecurityConfiguration;
import com.utbm.lo54.common.PersistenceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.utbm.lo54.adminwebapp", "com.utbm.lo54.common"})
@EnableWebMvc
@Import({ SecurityConfiguration.class, PersistenceConfiguration.class, UsersPersistenceConfiguration.class})
public class AppConfig {
}
