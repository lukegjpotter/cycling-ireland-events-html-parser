package com.lukegjpotter.spring.application.config;

import java.net.URISyntaxException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.commons.dbcp.BasicDataSource;

@Configuration
public class MainConfig {

    @Bean public BasicDataSource dataSource() throws URISyntaxException {
        
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        String username = System.getenv("JDBC_DATABASE_USERNAME");
        String password = System.getenv("JDBC_DATABASE_PASSWORD");
        
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        
        return dataSource;
    }
}
