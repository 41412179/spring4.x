package com.smart.beanfactory;

import com.smart.Car;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {
    public static void lifeCycleInBeanFactory() {
        // 1. 装载配置文件并启动容器
        Resource res = new ClassPathResource("beans.xml");
        BeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) bf);
        reader.loadBeanDefinitions(res);

        //后处理器的实际调用顺序与注册顺序无关，在具有多个后处理器的情况下，必须通过实现
        //org.springframework.core.Ordered接口来确定调用顺序
        // 2. 向容器中注册MyBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyBeanPostProcessor());
        // 3. 向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        // 4. 第一次从容器中获得car， 将触发容器实例化该Bean，这将引发Bean生命周期方法的调用
        Car car1 = (Car) bf.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        // 5. 第二次从容器中获取car， 直接从缓存池中获取
        Car car2 = (Car) bf.getBean("car");

        // 6. 查看car1和car2是否指向同一引用
        System.out.println("car1==car2: " + (car1 == car2));

        // 7. 关闭容器
        ((DefaultListableBeanFactory) bf).destroySingleton("car");

    }

    public static void main(String[] args) {
        lifeCycleInBeanFactory();
    }
}
