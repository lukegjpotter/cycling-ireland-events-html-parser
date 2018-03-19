package com.lukegjpotter.spring.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class DatabaseConfiguration {

    @Autowired
    private Environment environment;

    @Bean public DataSource dataSource() {
        DatabaseConfigurationModel db = parseDatabaseUrlEnvironmentalVariable();

        return DataSourceBuilder
                .create()
                .url(db.url)
                .username(db.username)
                .password(db.password)
                .driverClassName(db.driver)
                .build();
    }

    private DatabaseConfigurationModel parseDatabaseUrlEnvironmentalVariable() {

        DatabaseConfigurationModel dcm = new DatabaseConfigurationModel();

        URI dbUri = null;
        try {
            dbUri = new URI(environment.getProperty("DATABASE_URL", "postgres://postgres:@localhost:5432/cyclingirelandevents"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        try {
            dcm.username = dbUri.getUserInfo().split(":")[0];
        } catch (ArrayIndexOutOfBoundsException ignored) {
            dcm.username = "";
        }

        try {
            dcm.password = dbUri.getUserInfo().split(":")[1];
        } catch (ArrayIndexOutOfBoundsException ignored) {
            dcm.password = "";
        }

        dcm.url = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        dcm.driver = "org.postgresql.Driver";

        return dcm;
    }
}
