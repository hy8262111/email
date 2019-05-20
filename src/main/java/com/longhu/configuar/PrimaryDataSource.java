/*
package com.longhu.configuar;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

*/
/**
 * @author: houyong
 * @description: 多数据源配置
 * @create: 2019-05-15 10:04
 *//*

@Configuration
@MapperScan(basePackages = {"com.longhu.wypmdmdatasync.primarydao"}, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class PrimaryDataSource {
    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(("classpath*:mapper/*.xml")));
        return bean.getObject();
    }
}*/
