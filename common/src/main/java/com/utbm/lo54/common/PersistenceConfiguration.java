//package com.utbm.lo54.core;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.PropertySources;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//public
//class PersistenceConfiguration {
//    private final String HIBERNATE_HBM_TO_DDL_AUTO = "hibernate.hbm2ddl.auto";
//    private final String HIBERNATE_DIALECT = "hibernate.dialect";
//    private final String HIBERNATE_SECOND_LVL_CACHE = "hibernate.cache.use_second_level_cache";
//    private final String HIBERNATE_USE_CACHE_QUERY = "hibernate.cache.use_query_cache";
//
//    @Value("spring.datasource.driver-class-name")
//    private String driverClassName;
//
//    @Value("spring.datasource.url")
//    private String dataSourceUrl;
//
//    @Value("spring.datasource.username")
//    private String username;
//
//    @Value("spring.datasource.password")
//    private String password;
//
//    @Value("spring.jpa.hibernate.ddl-auto")
//    private String hibernateDdlAuto;
//
//    @Value("hibernate.dialect")
//    private String hibernateDialect;
//
//    @Value("hibernate.cache.use_query_cache")
//    private String hibernateQueryCache;
//
//    @Value("hibernate.cache.use_second_level_cache")
//    private String hibernateSecondLevelCache;
//
//    @Bean(name = "coursesDataSource")
//    @Qualifier("coursesDataSource")
//    public DataSource coursesDataSource() {
//        DriverManagerDataSource driver = new DriverManagerDataSource();
//        driver.setDriverClassName(driverClassName);
//        driver.setUrl(dataSourceUrl);
//        driver.setUsername(username);
//        driver.setPassword(password);
//        return driver;
//    }
//
//    @Bean(name = "coursesEntityManagerFactory")
//    @Qualifier("coursesEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean coursesEntityManagerFactory() {
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        vendorAdapter.setGenerateDdl(true);
//
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(vendorAdapter);
//        factory.setPackagesToScan("com.utbm.lo54.clientservice", "com.utbm.lo54.core");
//        factory.setDataSource(coursesDataSource());
//        factory.setJpaProperties(additionalProperties());
//
//        return factory;
//    }
//
//    private Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty(HIBERNATE_HBM_TO_DDL_AUTO, hibernateDdlAuto);
//        properties.setProperty(HIBERNATE_DIALECT, hibernateDialect);
//        properties.setProperty(HIBERNATE_USE_CACHE_QUERY, hibernateQueryCache);
//        properties.setProperty(HIBERNATE_SECOND_LVL_CACHE, hibernateSecondLevelCache);
//        return properties;
//    }
//
//    @Bean(name = "coursesPlatformTransactionManager")
//    @Qualifier("coursesPlatformTransactionManager")
//    public PlatformTransactionManager coursesTransactionManager
//            (@Qualifier("coursesEntityManagerFactory") EntityManagerFactory emf) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor coursesExceptionTranslation(){
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//}