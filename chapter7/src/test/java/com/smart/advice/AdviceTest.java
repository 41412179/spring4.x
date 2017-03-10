package com.smart.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AdviceTest {

    @Test
    public void advice() {
        String config = "com/smart/advice/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Waiter waiter = (Waiter) ctx.getBean("waiter");
        waiter.greetTo("John");
        waiter.serveTo("Tom");
    }
}
