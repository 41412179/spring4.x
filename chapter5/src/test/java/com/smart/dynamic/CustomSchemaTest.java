package com.smart.dynamic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class CustomSchemaTest {
    public ApplicationContext applicationContext = null;

    private static String[] CONFIG_FILES = { "com/smart/dynamic/custom.xml" };

    @BeforeClass
    public void setUp() {
        applicationContext = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testRegisterBean() {
        Object userService = applicationContext.getBean("userService");
        assertNotNull(userService);
    }
}
