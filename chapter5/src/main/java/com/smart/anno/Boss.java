package com.smart.anno;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
public class Boss {

    private Car car;

    public Boss() {
        System.out.println("construct...");
    }

    public Car getCar() {
        return car;
    }

    @Resource//若未指定name属性，则根据属性方法得到需要注入的Bean的名称
    public void setCar(Car car) {
        System.out.println("execute int setCar.");
        this.car = car;
    }

    //使用<bean>进行配置时，可通过init-method和destroy-method的属性指定Bean的初始化和容器销毁前的执行方法
    //@PostConstruct和@PreDestroy注解相当于init-method和destroy-method的功能，且在一个Bean中客定义多个@PostConstruct和@PreDestroy方法

    @PostConstruct
    private void init1() {
        System.out.println("execute int init1.");
    }

    @PostConstruct
    private void init2() {
        System.out.println("execute int init2.");
    }

    @PreDestroy
    private void destroy1() {
        System.out.println("execute int destroy1.");
    }

    @PreDestroy
    private void destroy2() {
        System.out.println("execute int destroy2.");
    }
}
