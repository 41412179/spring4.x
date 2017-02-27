package com.smart.dynamic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFactoryBean implements BeanFactoryPostProcessor {

    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
        // 1.将ConfigurableListableBeanFactory转化为DefaultListableBeanFactory
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) bf;

        // 2.通过BeanDefinitionBuilder创建Bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserService.class);

        // 3.设置属性userDao，此属性引用已经定义的Bean：userDao
        beanDefinitionBuilder.addPropertyReference("userDao", "userDao");

        // 4.注册Bean定义
        beanFactory.registerBeanDefinition("userService1", beanDefinitionBuilder.getBeanDefinition());

        // 5.直接注册一个Bean实例
        beanFactory.registerSingleton("userService2", new UserService());
    }
}
