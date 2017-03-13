package com.smart.advisor;

import com.smart.aop.BeanSelfProxyAware;

public class Waiter implements BeanSelfProxyAware{
    private Waiter waiter;
    public void greetTo(String name) {
        System.out.println("waiter greet to " + name + "...");
    }

    public void serveTo(String name) {
        System.out.println("waiter serve to " + name + "...");
        waiter.greetTo(name);
    }

    public void setSelfProxy(Object object) {
        this.waiter = (Waiter) object;
    }
}
