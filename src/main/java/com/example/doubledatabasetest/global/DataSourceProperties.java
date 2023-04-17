package com.example.doubledatabasetest.global;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
@EnableConfigurationProperties
public class DataSourceProperties {

    @Bean(name = "test1DataSource")
    @Qualifier("test1DataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari.test1")
    public DataSource test1DataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "test2DataSource")
    @Qualifier("test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.test2")
    public DataSource test2DataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
