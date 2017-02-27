package com.smart.injectfun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;

public class injectFunTest {

    private ApplicationContext factory = null;

    private static String[] CONFIG_FILES = {"com/smart/injectfun/beans.xml"};

    @BeforeClass
    public void setUp() {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testLookup() {
        MagicBoss magicBoss = (MagicBoss) factory.getBean("magicBoss");
        assertNotSame(magicBoss.getCar(), magicBoss.getCar());
    }

    @Test
    public void testReplace() {
        MagicBoss boss1 = (MagicBoss) factory.getBean("boss1");
        assertEquals(boss1.getCar().getBrand(), "美人豹");
    }

}
