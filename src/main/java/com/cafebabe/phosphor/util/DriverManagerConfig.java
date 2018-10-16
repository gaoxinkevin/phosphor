package com.cafebabe.phosphor.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


/**
 * @author 孙堂奥
 */

@Component
@Configuration
@ImportResource("classpath:config/applicationContext.xml")
public class DriverManagerConfig{

    @Value("${mysql.url}")
    private String url;

    @Value("${mysql.user}")
    private String user;

    @Value("${mysql.password}")
    private String password;

    @Value("${mysql.driver}")
    private String driver;

    @Bean
    public DataSource  driverManagerUtil(){
        DataSource dataSource=new  DriverManagerDataSource();
        ((DriverManagerDataSource) dataSource).setDriverClassName(driver);
        ((DriverManagerDataSource) dataSource).setUrl(url);
        ((DriverManagerDataSource) dataSource).setUsername(user);
        ((DriverManagerDataSource) dataSource).setPassword(password);
        return  dataSource;
    }
}
