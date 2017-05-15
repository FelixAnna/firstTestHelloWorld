package com.xiangyong.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

/**
 * Created by yuxiangyong on 2017/5/6.
 */
@Configuration
@EnableJpaRepositories(
        basePackageClasses = com.xiangyong.repository.ContactRepository.class,
        entityManagerFactoryRef ="testEntityManagerFactory")
@EntityScan(basePackageClasses=com.xiangyong.entity.ContactInfo.class)
public class JpaConfig {
}
