package com.smart.reflect;

import sun.reflect.CallerSensitive;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

    public static Car initByDefaultConst() throws Throwable {

        /*
        类装载器工作机制：
         (1)装载：查找和导入Class文件
         (2)链接：
              1.校验：检查载入Class文件数据的正确性
              2.准备：给类的静态变量分配存储空间
              3.解析：将符号引用转化为直接引用（可选）
         (3)初始化：对类的静态变量、静态代码块执行初始化工作
        */

        // 1. 通过类加载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.Car");

        // 2. 获取类的默认构造器对象并通过它实例化Car
        Constructor constructor = clazz.getConstructor((Class[]) null);
        Car car = (Car) constructor.newInstance();

        // 3. 通过反射方法设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "红旗CA72");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "黑色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);

        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println("current loader: " + loader);
        System.out.println("parent loader: " + loader.getParent());
        //根装载器使用C++语言编写，在Java中访问不到
        System.out.println("grandParent loader: " + loader.getParent().getParent());

        //JVM装载类时使用“全盘负责委托机制”
        // 1.当一个ClassLoader装载一个类时，除非显式的使用另一个ClassLoader,该类所依赖及引用的类也由这个ClassLoader载入
        // 2.先委托父类装载器寻找目标类，只有在找不到的情况下才从自己的类路径中查找并装载目标类
    }
}
