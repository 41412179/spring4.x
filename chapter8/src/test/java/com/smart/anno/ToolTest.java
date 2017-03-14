package com.smart.anno;

import org.junit.Test;

import java.lang.reflect.Method;

public class ToolTest {

    /*
      在Java 5.0 中，Package、Class、Constructor、Method及Field等反射对象都新增了
      访问注解信息的方法： <T extends Annotation> T getAnnotation(Class<T> annotationClass),
      该方法支持通过泛型直接返回注解对象
     */

    @Test
    public void tool() {

        // 1.得到ForumService对应的Class对象
        Class clazz = ForumService.class;

        // 2.得到ForumService对应的Method数组
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);
        for (Method method : methods) {
            // 3.获取方法上所标注的注解对象
            NeedTest nt = method.getAnnotation(NeedTest.class);
            if (nt != null) {
                if (nt.value()) {
                    System.out.println(method.getName() + "()需要测试");
                } else {
                    System.out.println(method.getName() + "()不需要测试");
                }
            }
        }
    }
}
