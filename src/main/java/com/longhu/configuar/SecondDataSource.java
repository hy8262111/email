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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

*/
/**
 * @author: houyong
 * @description: 多数据源配置
 * @create: 2019-05-15 10:04
 *//*

@Configuration
@MapperScan(basePackages = {"com.longhu.wypmdmdatasync.seconddao"}, sqlSessionFactoryRef = "secSqlSessionFactory")
public class SecondDataSource {
    @Bean(name = "secDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "secSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier("secDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(("classpath*:secondmapper/*.xml")));
        return bean.getObject();
    }
}*/
