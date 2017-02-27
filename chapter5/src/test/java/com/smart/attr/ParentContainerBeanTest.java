package com.smart.attr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class ParentContainerBeanTest {

    @Test
    public void parent() {
        ApplicationContext parentApp = new ClassPathXmlApplicationContext(new String[]{"com/smart/attr/beans1.xml"});
        ApplicationContext app = new ClassPathXmlApplicationContext(new String[]{"com/smart/attr/beans2.xml"}, parentApp);
        Boss boss = (Boss) app.getBean("boss");
        assertNotNull(boss);
        System.out.println(boss.toString());
    }
}
