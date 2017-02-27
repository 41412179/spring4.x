package com.smart;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean{
    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    //默认构造函数
    public Car(){System.out.println("调用Car()构造函数");}

    //带参构造函数
    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    //未带参方法
    public void introduce() {
        System.out.println("brand:" + brand + ";color:" + color + ";maxSpeed:" + maxSpeed);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand()设置属性");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    // BeanFactoryAware接口方法
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory().");
        this.beanFactory = beanFactory;
    }

    // BeanNameAware接口方法
    public void setBeanName(String s) {
        System.out.println("调用BeanNameAware.setBeanName().");
        this.beanName = s;
    }

    // DisposableBean接口方法
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destroy().");
    }

    // InitializingBean接口方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitialingBean.afterPropertiesSet().");
    }

    // 通过<bean>的init-method属性指定的初始方法
    public void myInit() {
        System.out.println("调用init-method属性指定的myInit(), 将maxSpeed设置为240");
        this.maxSpeed = 240;
    }

    //同过<bean>的destroy-method属性指定的销毁方法
    public void myDestroy() {
        System.out.println("调用destroy-method属性指定的myDestroy().");
    }

}
