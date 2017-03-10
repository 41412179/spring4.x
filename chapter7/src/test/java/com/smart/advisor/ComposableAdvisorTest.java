package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class ComposableAdvisorTest {

    @Test
    public void composable() {
        String configPath = "com/smart/advisor/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter waiter4 = (Waiter) ctx.getBean("waiter4");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter4);
        waiter4.greetTo("John");
        waiter4.serveTo("John");
        wd.service("John");
    }

}
