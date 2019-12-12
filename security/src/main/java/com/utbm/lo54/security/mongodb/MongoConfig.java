package com.utbm.lo54.security.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.utbm.lo54.security.repository")
public class MongoConfig {

}
