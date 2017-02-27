package com.smart.groovy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class LogonServiceTest {

    @Test
    public void getBean() {
        // 1.加载指定Groovy Bean配置文件来创建容器
        ApplicationContext ctx = new GenericGroovyApplicationContext(
                "classpath:com/smart/groovy/spring-context.groovy");

        // 2.加载Groovy定义的Bean
        LogonService logonService = ctx.getBean(LogonService.class);
        assertNotNull(logonService);

        // 3.加载注解定义的Bean
        MailService mailService = ctx.getBean(MailService.class);
        assertNotNull(mailService);

        // 4.判断注入的是否是DbUserDao
        UserDao userDao = ctx.getBean(UserDao.class);
        assertTrue(userDao instanceof DbUserDao);

    }
}
