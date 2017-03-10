package com.smart.advice;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.Test;

public class BeforeAdviceTest {

    @Test
    public void before() {
        Waiter waiter = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        // 1.Spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();

        pf.setInterfaces(waiter.getClass().getInterfaces());    //指定为接口进行代理，使用JdkDynamicAopProxy

        pf.setOptimize(true);   //启用优化，针对接口的代理也会使用Cglib2AopProxy

        // 2.设置代理目标
        pf.setTarget(waiter);

        // 3.为代理目标提供增强
        pf.addAdvice(advice);   //可添加多个增强，形成增强链，调用顺序和添加顺序一致；也可通过addAdvice(int,Advice)添加到增强链具体位置

        // 4.生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }
}
