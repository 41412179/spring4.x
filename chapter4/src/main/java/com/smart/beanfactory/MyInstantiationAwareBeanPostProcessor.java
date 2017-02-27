package com.smart.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    @Override
    // 1.接口方法，在实例化Bean前调用
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        // 1-1. 仅对容器中的car Bean进行处理
        if ("car".equals(beanName)) {
            System.out.println("调用InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation().");
        }
        return null;
    }

    @Override
    // 2.接口方法，在实例化Bean后调用
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("调用InstantiationAwarePostProcessor.postProcessorAfterInstantiation().");
        }
        return true;
    }

    @Override
    // 3.接口方法，在设置某个属性时调用
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        // 3-1. 仅对容器中的car Bean进行处理， 还可以同过pds入参进行过滤
        if ("car".equals(beanName)) {
            System.out.println("调用InstantiationAwarePostProcessor.postProcessPropertyValues().");
        }
        return pvs;
    }
}
