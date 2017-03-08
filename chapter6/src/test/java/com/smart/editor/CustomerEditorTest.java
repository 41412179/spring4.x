package com.smart.editor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertNotNull;

public class CustomerEditorTest {

    private ApplicationContext factory;
    private static String[] CONFIG_FILES = {"com/smart/editor/beans.xml"};

    @BeforeClass
    public void setUp() {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testCustomerCarEditor() {
        Boss boss = (Boss) factory.getBean("boss");
        assertNotNull(boss);
        System.out.println(boss);
    }
}
