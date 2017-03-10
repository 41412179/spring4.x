package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class ControlFlowAdvisorTest {

    @Test
    public void controlFlow() {
        String config = "com/smart/advisor/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Waiter waiter3 = (Waiter) ctx.getBean("waiter3");
        WaiterDelegate wd = new WaiterDelegate();
        wd.setWaiter(waiter3);
        waiter3.greetTo("Peter");
        waiter3.serveTo("Peter");
        wd.service("Peter");
    }
}
