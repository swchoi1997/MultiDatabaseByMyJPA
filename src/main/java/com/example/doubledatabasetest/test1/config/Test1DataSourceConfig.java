package com.example.doubledatabasetest.test1.config;


import java.util.Objects;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "test1EntityManagerFactory",
        transactionManagerRef = "test1TransactionManager",
        basePackages = { "com.example.doubledatabasetest.test1.repository" }
)
public class Test1DataSourceConfig {



    private final DataSource test1DataSource;

    @Autowired
    public Test1DataSourceConfig(@Qualifier("test1DataSource") DataSource test1DataSource) {
        this.test1DataSource = test1DataSource;
    }

    @Primary
    @Bean(name = "test1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean test1EntityManagerFactory(final EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(test1DataSource)
                .packages("com.example.doubledatabasetest.test1.domain")
                .persistenceUnit("test1")
                .build();
    }

    @Primary
    @Bean("test1TransactionManager")
    public PlatformTransactionManager test1TransactionManager(final EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(Objects.requireNonNull(test1EntityManagerFactory(builder).getObject()));
    }
}
