package com.smart.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 1.将一个POJO标注为定义Bean的配置类
@Configuration
public class AppConfig {

    // 2.以下两个方法定义了两个Bean，并提供了Bean的实例化逻辑
    // 2.1Bean的名称默认和方法名相同，也可以通过入参显式的指定Bean名称
    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean(name = "logDao")
    public LogDao logDao() {
        return new LogDao();
    }

    // 3.定义了logonService的Bean
    @Bean
    public LogonService logonService() {
        LogonService logonService = new LogonService();
        // 4.将2处定义的Bean注入到logonService Bean中
        logonService.setLogDao(logDao());
        logonService.setUserDao(userDao());
        return logonService;
    }
}
