package com.Carritos.AcademiaCarros.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.Carritos.AcademiaCarros.Repository.MySQL2", 
    entityManagerFactoryRef = "mysql2EMF", 
    transactionManagerRef = "mysql2TrxManager"
)
@EnableTransactionManagement
public class MySQL2Config {

    @Bean("mysql2Properties")
    @ConfigurationProperties(prefix = "spring.datasource.mysql2")
    public DataSourceProperties getMysql2Properties() {
        return new DataSourceProperties();
    }

    @Bean("mysql2Datasource")
    public DataSource getMysql2DataSource(@Qualifier("mysql2Properties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean("mysql2EMF")
    public LocalContainerEntityManagerFactoryBean mysql2EntityManagerFactory(
            @Qualifier("mysql2Datasource") DataSource dataSource, EntityManagerFactoryBuilder builder) {

        Map<String, String> additionalProps = new HashMap<>();
        additionalProps.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

        return builder
                .dataSource(dataSource)
                .persistenceUnit("mysql2")
                .properties(additionalProps)
                .packages("com.Carritos.AcademiaCarros.Model.MySQL2")
                .build();
    }

    @Bean("mysql2TrxManager")
    public JpaTransactionManager getMysql2TrxManager(@Qualifier("mysql2EMF") LocalContainerEntityManagerFactoryBean mysql2EMF) {
        return new JpaTransactionManager(Objects.requireNonNull(mysql2EMF.getObject()));
    }
}
