package com.smart.aspectj.advanced;

import com.smart.NaiveWaiter;
import com.smart.SmartSeller;
import com.smart.Waiter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdvancedTest {

    @Test
    public void advanced() {
        String configPath = "com/smart/aspectj/advanced/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");

        //通过joinPoint访问连接点信息
        naiveWaiter.greetTo("John");

        //绑定连接点参数
        ((NaiveWaiter) naiveWaiter).smile("John", 2);

        SmartSeller seller = (SmartSeller) ctx.getBean("seller");
        seller.sell("Beer", "John");
        seller.checkBill(1);
    }
}
