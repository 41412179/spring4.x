package com.smart.aspectj.fun;

import com.smart.Seller;
import com.smart.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PointcutFunTest {
    @Test
    public void pointcut() {
        String configPath = "com/smart/aspectj/fun/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");

        // 在引入Seller接口增强时，使用this()
        naiveWaiter.greetTo("John");
        naiveWaiter.serveTo("John");
        ((Seller) naiveWaiter).sell("Beer", "John");
    }
}
