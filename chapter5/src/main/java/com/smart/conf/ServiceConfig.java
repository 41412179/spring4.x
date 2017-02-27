package com.smart.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DaoConfig.class)
public class ServiceConfig {

    // 1.像普通Bean一样注入DaoConfig
    @Autowired
    private DaoConfig daoConfig;

    @Bean
    public LogonService logonService() {
        LogonService logonService = new LogonService();
        // 2.像普通Bean一样，调用Bean相关的方法
//        System.out.println(daoConfig.logDao() == daoConfig.logDao());
        logonService.setUserDao(daoConfig.userDao());
        logonService.setLogDao(daoConfig.logDao());
        return logonService;
    }
}
