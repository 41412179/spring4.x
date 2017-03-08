package com.smart.placeholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class PropertyPlace {
    private ApplicationContext ctx = null;

    private static String[] CONFIG_FILES = {"com/smart/placeholder/beans.xml"};

    @BeforeClass
    public void setUP() {
        ctx = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testMyDataSource() {
        MyDataSource dataSource = ctx.getBean(MyDataSource.class);
        assertNotNull(dataSource);
    }
}
