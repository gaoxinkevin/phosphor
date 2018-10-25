package com.cafebabe.phosphor.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


/**
 *
 * @author supersuntangao@gmail.com
 *
 * class_name: DriverManagerConfig
 *
 * create_date: 2018/10/25
 *
 * create_time: 09:21
 *
 * description: Mysql数据库连接配置
 **/


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
        DriverManagerDataSource dataSource=new  DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return  dataSource;
    }
}
