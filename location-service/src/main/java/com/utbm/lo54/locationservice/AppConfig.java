package com.utbm.lo54.locationservice;

import com.utbm.lo54.common.PersistenceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({"com.utbm.lo54.locationservice", "com.utbm.lo54.common", })
@EnableJpaRepositories(basePackages={"com.utbm.lo54.locationservice", "com.utbm.lo54.common"},
        entityManagerFactoryRef = "coursesEntityManagerFactory",
        transactionManagerRef = "coursesTransactionManager")
@EnableWebMvc
@Import({ PersistenceConfiguration.class })
public class AppConfig {
}
