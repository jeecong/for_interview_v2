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

/**
 * @author ytp
 * @date 2020/9/21
 */

@Configuration
@MapperScan(basePackages = {"com.lehe.higo.oxp.dao.oxp"}, sqlSessionFactoryRef = "oxpSqlSessionFactory")
public class OxpConfig {

    private final DataSource dataSourceOxp;

    public OxpConfig(@Qualifier("oxp") DataSource dataSourceOxp) {
        this.dataSourceOxp = dataSourceOxp;
    }


    @Bean
    public SqlSessionFactory oxpSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceOxp);

        // 配置下划线自动转驼峰
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);

        factoryBean.setConfiguration(configuration);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/oxp/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate oxpSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(oxpSqlSessionFactory());
    }

}
