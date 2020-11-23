package com.qiutong.work.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author ytp
 * @date 2020/9/21
 */

@Configuration
public class DataSourceConfig {

    @Bean(name = "oxp")
    @ConfigurationProperties(prefix = "spring.datasource.oxp")
    public DataSource oxpDbDataSource() {
        return DataSourceBuilder.create().build();
    }
}
