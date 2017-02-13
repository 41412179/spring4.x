package com.smart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement //开启事务支持，相当于XML中的<tx:annotation-driven/>
public class Application extends SpringBootServletInitializer {

    @Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    //继承Spring Boot 提供的Servlet初始化器SpringBootServletInitializer
    //并重写SpringBootServletInitializer的configure()方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main (String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
