package com.smart.injectfun;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//实现了ApplicationContextAware接口，应用将与Spring框架绑定在一起
public class MagicBossImpl implements MagicBoss, ApplicationContextAware {

    private ApplicationContext ctx;
    public Car getCar() {
        return (Car) ctx.getBean("car");
    }

    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }
}
