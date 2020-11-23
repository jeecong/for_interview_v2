package com.qiutong.work.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Bean(name = "bank")
    @ConfigurationProperties(prefix = "spring.datasource.bank")
    public DataSource oxpDbDataSource() {
        return DataSourceBuilder.create().build();
    }
}
