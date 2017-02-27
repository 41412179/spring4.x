package com.smart.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigTest {

    public static void main(String[] args) {
        // 1.使用@Configuration类提供的Bean定义信息启动容器

        // 通过构造函数加载配置类
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. 通过编码方式注册配置类
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//        //注册多个配置类
//        ctx.register(DaoConfig.class);
//        ctx.register(ServiceConfig.class);
//        //刷新容器以应用这些配置类
//        ctx.refresh();

        // 3.通过XML配置文件引用@configuration的配置
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:com/smart/conf/beans2.xml");

        // 4.通过@Configuration配置类引用XML配置信息
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(LogonAppConfig.class);

        // 5.@Configuration配置类互相引用
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class, ServiceConfig.class);
        LogonService logonService = ctx.getBean(LogonService.class);
        System.out.println(logonService.getLogDao() != null);
        logonService.printHello();
    }
}
