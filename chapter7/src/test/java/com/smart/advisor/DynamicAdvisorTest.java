package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class DynamicAdvisorTest {

    @Test
    public void dynamic() {
        String config = "com/smart/advisor/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Waiter waiter2 = (Waiter) ctx.getBean("waiter2");
        //在织入切面时，对目标类中的所有方法执行静态切点检查
        //第一次调用serverTo()方法时，执行静态切点检查
        waiter2.serveTo("Peter");
        //第一次调用greetTo()方法时，执行静态、动态切点检查
        waiter2.greetTo("Peter");
        //第二次调用serveTo()方法时，不再执行静态切点检查
        waiter2.serveTo("John");
        //第二次调用serveTo()方法时，只执行动态切点检查
        waiter2.greetTo("John");

    }
}
