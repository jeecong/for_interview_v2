package com.qiutong.work.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;


@Configuration
@MapperScan(basePackages = {"com.qiutong.work.dao.bank"}, sqlSessionFactoryRef = "bankSqlSessionFactory")
public class BankConfig {

    private final DataSource dataSourceBank;

    public BankConfig(@Qualifier("bank") DataSource dataSourceBank) {
        this.dataSourceBank = dataSourceBank;
    }


    @Bean
    public SqlSessionFactory bankSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceBank);

        // 配置下划线自动转驼峰
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);

        factoryBean.setConfiguration(configuration);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/bank/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate bankSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(bankSqlSessionFactory());
    }

}
