package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class RegexAdvisorTest {

    @Test
    public void regex() {
        String config = "com/smart/advisor/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Waiter waiter1 = (Waiter) ctx.getBean("waiter1");
        waiter1.greetTo("John");
        waiter1.serveTo("John");
    }
}
