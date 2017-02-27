package com.smart.attr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class BeanAttrDITest {

    private ApplicationContext factory = null;
    private static String[] CONFIG_FILES = {"com/smart/attr/beans.xml"};

    @BeforeClass
    public void setUp() {
        factory = new ClassPathXmlApplicationContext(CONFIG_FILES);
    }

    @Test
    public void testBeanRetrieveCar() {
        Car car = (Car) factory.getBean("car");
        assertNotNull(car);
        System.out.println(car);
    }

    @Test
    public void testBeanRetrieveBoss1() {
        Boss boss1 = (Boss) factory.getBean("boss1");
        assertNotNull(boss1);
        System.out.println(boss1);
    }

    @Test
    public void testBeanRetrieveBoss2() {
        Boss boss2 = (Boss) factory.getBean("boss2");
        assertNotNull(boss2);
        System.out.println(boss2);
    }

    @Test
    public void testBeanRetrieveBoss3() {
        Boss boss3 = (Boss) factory.getBean("boss3");
        assertNotNull(boss3);
        System.out.println(boss3);
    }

    @Test
    public void testBeanRetrieveBoss4() {
        Boss boss4 = (Boss) factory.getBean("boss4");
        assertNotNull(boss4);
        System.out.println(boss4);
    }

    @Test
    public void testBeanRetrieveChildBoss() {
        Boss childBoss = (Boss) factory.getBean("childBoss");
        assertNotNull(childBoss);
        System.out.println(childBoss);
    }

    @Test
    public void testBeanRetrieveSportCar() {
        SportsCar sportCar = (SportsCar) factory.getBean("sportsCar");
        assertNotNull(sportCar);
        System.out.println(sportCar);
    }
}
