package com.mysqldatamigration.mysql;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
public class MysqlConfig {

    @Primary
    @Bean(name = "firstDatasource")
    @ConfigurationProperties("spring.datasource")
    DataSource firstDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "firstJdbcTemplate")
    JdbcTemplate firstJdbcTemplate(@Qualifier("firstDatasource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }


}
