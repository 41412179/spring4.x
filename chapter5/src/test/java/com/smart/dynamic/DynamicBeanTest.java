package com.smart.dynamic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class DynamicBeanTest {

    private ApplicationContext factory = null;
    private static String[] CONFIG_FILES = {"classpath:com/smart/dynamic/beans.xml"};

    @BeforeClass
    public void setUp() {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testRegisterBean() {
        try {
            Object userService1 = factory.getBean("userService1");
            Object userService2 = factory.getBean("userService2");
            assertNotNull(userService1);
            assertNotNull(userService2);
        } catch (NoSuchBeanDefinitionException e) {
            e.printStackTrace();
        }
    }
}
