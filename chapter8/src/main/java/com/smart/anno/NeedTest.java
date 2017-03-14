package com.smart.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @Retention 声明注解的保留期限
 * SOURCE: 注解信息仅保留在目标类代码的源码文件中
 * CLASS： 注解信息将进入目标类代码的字节码文件中
 * RUNTIME: 注解信息在目标类加载到JVM后依然保留，在运行期间通过反射机制可以读取类中的注解信息
 */
@Retention(RetentionPolicy.RUNTIME)
/*
 * @Target 注解应用目标
 * TYPE: 类、接口、注解类、Enum声明处，相应的注解称为类型注解
 * FIELD: 类成员变量或常量声明处，相应的注解被称为域值注解
 * METHOD: 方法声明处，相应的注解被称为方法注解
 * PARAMETER: 参数声明处，相应的注解被称为参数注解
 * CONSTRUCTOR: 构造函数声明处，相应的注解被称为构造函数注解
 * LOCAL_VARIABLE: 局部变量声明处，相应的注解被称为局部变量注解
 * ANNOTATION_TYPE: 注解类声明处，相应的注解被称为注解类注解，ElementType.Type包括ElementType.ANNOTATION_TYPE
 * PACKAGE: 包声明处，相应的和注解被称为包注解
 */
@Target(ElementType.METHOD)
public @interface NeedTest {//定义注解

    /*
     * 成员声明有如下限制：
     * 成员以无入参、无抛出异常的方式声明
     * 可以通过default为成员指定一个默认值
     * 成员类型是受限的，合法的类型包括基本类型及其封装类、String、Class、enums、注解类型，以及上述类型的数组类型
     * 如果只有一个成员，则成员名必须为value()
     * 注解类可以没有成员，没有成员的注解称为标识注解
     * 所有的注解都隐式继承于java.lang.annotation.Annotation,但注解不允许显式继承其它接口
     */
    boolean value() default true; //声明注解成员
}
