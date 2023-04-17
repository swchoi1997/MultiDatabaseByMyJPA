package com.example.doubledatabasetest.test2.config;


import java.util.Objects;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "test2EntityManagerFactory",
        transactionManagerRef = "test2TransactionManager",
        basePackages = { "com.example.doubledatabasetest.test2.repository" }
)
public class Test2DataSourceConfig {

    private final DataSource test2DataSource;

    @Autowired
    public Test2DataSourceConfig(@Qualifier("test2DataSource") DataSource test2DataSource) {
        this.test2DataSource = test2DataSource;
    }


    @Bean(name = "test2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean test2EntityManagerFactory(final EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(test2DataSource)
                .packages("com.example.doubledatabasetest.test2.domain")
                .persistenceUnit("test2")
                .build();
    }

    @Bean("test2TransactionManager")
    public PlatformTransactionManager test2TransactionManager(final EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(Objects.requireNonNull(test2EntityManagerFactory(builder).getObject()));
    }
}
