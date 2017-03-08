package com.smart.beanprop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.testng.Assert.assertNotNull;

public class BeanPropTest {

    @Test
    public void testBeanPropReference() throws Throwable {
        String resource = "com/smart/beanprop/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
        DataSource ds = ctx.getBean(DataSource.class);
        Connection connection = ds.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void testAnnotationBeanPropReference() throws Exception {
        String resource = "com/smart/beanprop/beans1.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
        ApplicationManager manager = ctx.getBean(ApplicationManager.class);
        assertNotNull(manager);
    }
}
