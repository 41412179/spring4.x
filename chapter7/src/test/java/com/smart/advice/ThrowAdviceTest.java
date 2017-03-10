package com.smart.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class ThrowAdviceTest {

    @Test
    public void throwAdvice() {
        String[] config = {"com/smart/advice/beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        ForumService fs = (ForumService) ctx.getBean("forumService");
        try {
            fs.removeForum(10);
        } catch (Exception ignored) {}
        try {
            fs.updateForum(new Forum());
        } catch (Exception ignored) {}
    }
}
