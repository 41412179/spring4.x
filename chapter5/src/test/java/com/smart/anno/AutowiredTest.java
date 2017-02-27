package com.smart.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class AutowiredTest {

    public ApplicationContext factory = null;
    private static String[] CONFIG_FILES = {"com/smart/anno/beans.xml"};

    @BeforeClass
    public void setUp() {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testAutoByName() {
        Boss boss = (Boss) factory.getBean("boss");
        assertNotNull(boss);
    }
}
