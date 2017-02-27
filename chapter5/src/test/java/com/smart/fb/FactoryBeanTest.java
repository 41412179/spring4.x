package com.smart.fb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;

@ContextConfiguration(locations = "/com/smart/fb/beans.xml")
public class FactoryBeanTest extends AbstractTestNGSpringContextTests {
    @Autowired
    public ApplicationContext factory;

    @Test
    public void testCarFactoryBean() {
        Car car1 = factory.getBean("car1", Car.class);
        Car car2 = factory.getBean("car1", Car.class);
        assertNotNull(car1);
        assertNotSame(car1, car2);
        System.out.println(car1);
    }

    @Test
    public void testCollFactoryBean() {
        List list = factory.getBean("favoriteList", List.class);
        Set set = factory.getBean("favoriteSet", Set.class);
        Map map = factory.getBean("emails", Map.class);
        Properties properties = factory.getBean("emailProps", Properties.class);
        assertEquals(list.size(), 3);
        assertEquals(set.size(), 3);
        assertEquals(map.size(), 2);
        assertEquals(properties.size(), 2);
    }

    @Test
    public void testFiledFactoryBean() {
        Car car2 = factory.getBean("car2", Car.class);
        assertNotNull(car2);
        System.out.println(car2);
    }

    @Test
    public void testPropPathFactoryBean() {
        Car car5 = factory.getBean("car5", Car.class);
        assertNotNull(car5);
        System.out.println(car5);
    }

}
