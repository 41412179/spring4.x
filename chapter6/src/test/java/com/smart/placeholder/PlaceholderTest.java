package com.smart.placeholder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import javax.sql.DataSource;

import java.sql.Connection;

import static org.testng.Assert.assertNotNull;

public class PlaceholderTest {

    @Test
    public void hold() throws Throwable{
        String resource = "classpath:com/smart/placeholder/beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resource);
        DataSource ds = ctx.getBean(DataSource.class);
        Connection connection = ds.getConnection();
        assertNotNull(connection);
        System.out.println(ctx.getBean(MyDataSource.class));
    }
}
