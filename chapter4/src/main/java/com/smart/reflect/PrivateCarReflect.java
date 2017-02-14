package com.smart.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateCarReflect {
    
    public static void main(String[] args) throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.smart.reflect.PrivateCar");
        PrivateCar pCar = (PrivateCar) clazz.newInstance();
        Field colorField = clazz.getDeclaredField("color");

        // 1.取消Java语言访问检查以访问private变量
        colorField.setAccessible(true);
        colorField.set(pCar, "红色");

        Method driveMtd = clazz.getDeclaredMethod("drive", (Class[]) null);

        //取消Java语言访问检查以访问protected方法
        driveMtd.setAccessible(true);
        driveMtd.invoke(pCar, (Object[]) null);
    }
}
