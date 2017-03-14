package com.smart.aspectj.example;

import com.smart.NaiveWaiter;
import com.smart.Waiter;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

public class AspectJProxyTest {

    @Test
    public void proxy() {
        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();

        // 1.设置目标对象
        factory.setTarget(target);

        // 2.添加切面类
        factory.addAspect(PreGreetingAspect.class);

        // 3.生成织入切面逻辑的代理对象
        Waiter proxy = factory.getProxy();

        proxy.greetTo("John");
        proxy.serveTo("John");
    }
}
