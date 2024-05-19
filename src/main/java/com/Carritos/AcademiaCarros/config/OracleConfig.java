package com.Carritos.AcademiaCarros.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.Carritos.AcademiaCarros.Repository.Oracle",
    entityManagerFactoryRef = "oracleEntityManagerFactory",
    transactionManagerRef = "oracleTrxManager"
)
@EnableTransactionManagement
public class OracleConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSourceProperties oracleDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource oracleDataSource(@Qualifier("oracleDataSourceProperties") DataSourceProperties oracleDataSourceProperties) {
        return oracleDataSourceProperties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "oracleEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("oracleDataSource") DataSource dataSource) {
        
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");

        return builder
                .dataSource(dataSource)
                .packages("com.Carritos.AcademiaCarros.Model.Oracle")
                .persistenceUnit("oraclePU")
                .properties(properties)
                .build();
    }

    @Bean(name = "oracleTrxManager")
    public JpaTransactionManager oracleTransactionManager(
            @Qualifier("oracleEntityManagerFactory") LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(oracleEntityManagerFactory.getObject()));
    }

    @Bean(name = "oracleEntityManager")
    public EntityManager oracleEntityManager(@Qualifier("oracleEntityManagerFactory") LocalContainerEntityManagerFactoryBean oracleEntityManagerFactory) {
        return oracleEntityManagerFactory.getObject().createEntityManager();
    }
}
