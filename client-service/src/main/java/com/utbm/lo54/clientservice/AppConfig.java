package com.utbm.lo54.clientservice;

import com.utbm.lo54.core.PersistenceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.utbm.lo54.clientservice", "com.utbm.lo54.core"})
@EnableJpaRepositories(basePackages={"com.utbm.lo54.clientservice", "com.utbm.lo54.core"},
        entityManagerFactoryRef = "coursesEntityManagerFactory",
        transactionManagerRef = "coursesTransactionManager")
@EnableWebMvc
@Import({ PersistenceConfiguration.class})
public class AppConfig {
}
