package com.smart.introduce;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class IntroduceTest {

    @Test
    public void introduce() {
        String configPath = "com/smart/introduce/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService) ctx.getBean("forumService");
        //默认情况下，未开启性能监控功能
        forumService.removeForum(10);
        forumService.removeTopic(1022);

        //激活性能监控空能
        Monitorable monitorable = (Monitorable) forumService;
        monitorable.setMonitorActive(true);

        forumService.removeForum(10);
        forumService.removeTopic(1020);

    }
}
