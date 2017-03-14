package com.smart.schema;

import com.smart.Seller;
import com.smart.Waiter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class SchemaAspectTest {
    @Test
    public void schema() {
        String configPath = "com/smart/schema/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
        naiveWaiter.greetTo("John");
        ((Seller) naiveWaiter).sell("Beer", "John");
    }
}
