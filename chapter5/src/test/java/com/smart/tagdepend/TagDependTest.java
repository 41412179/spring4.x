package com.smart.tagdepend;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class TagDependTest {

    private ApplicationContext factory = null;

    private static String[] CONFIG_FILES = {"com/smart/tagdepend/beans.xml"};

    @BeforeClass
    public void setUp() {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testInheritTag() {
        Car car3 = (Car) factory.getBean("car3");
        Car car4 = (Car) factory.getBean("car4");
        assertNotNull(car3);
        assertNotNull(car4);
    }

    @Test
    public void testReferenceTag() {
        Boss boss = (Boss) factory.getBean("boss");
        assertNotNull(boss);
        System.out.println(boss);
    }

}
