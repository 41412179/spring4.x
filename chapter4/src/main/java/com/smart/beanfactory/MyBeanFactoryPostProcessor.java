package com.smart.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    // 对car <bean>的brand属性配置信息进行“偷梁换柱”的加工操作
    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
        BeanDefinition bd = bf.getBeanDefinition("car");

        bd.getPropertyValues().addPropertyValue("brand", "奇瑞QQ");
        System.out.println("调用BeanFactoryPostProcessor.postProcessBeanFactory().");
    }
}
