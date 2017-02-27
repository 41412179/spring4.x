package com.smart.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
// 1.通过@ImportResource 引入XML配置文件
@ImportResource(value = "classpath:com/smart/conf/beans3.xml")
public class LogonAppConfig {

    // 2.自动注入XML文件中定义的Bean
    @Autowired
    @Bean
    public LogonService logonService(UserDao userDao, LogDao logDao) {
        LogonService logonService = new LogonService();
        logonService.setUserDao(userDao);
        logonService.setLogDao(logDao);
        return logonService;
    }

}
