package com.smart.conf;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DaoConfig {

    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    @Bean
    public LogDao logDao() {
        return new LogDao();
    }

}
