package com.smart.simple;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class BeanRetrieveTest {

    private ApplicationContext factory = null;

    private static String[] CONFIG_FILES = {"com/smart/simple/beans.xml"};

    @BeforeClass
    public void setUp() throws Exception {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testBeanRetrieve() {
        Car car = (Car) factory.getBean("car#1");
        assertNotNull(car);
    }

}
