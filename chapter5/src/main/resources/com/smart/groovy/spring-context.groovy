package com.smart.groovy

import org.springframework.core.io.ClassPathResource

beans {
    // 1.声明context命名空间
    xmlns context: "http://www.springframework.org/schema/context"

    // 2.与注解混合使用，定义注解Bean扫描包路径
    context.'component-scan'('base-package': "com.smart.groovy") {
        // 3.排除不需要扫描的包路径
        'exclude-filter'('type': "aspectj", 'expression': "com.smart.xml.*")
    }

    // 4.读取app-conf.properties配置文件
    def stream
    def config = new Properties()
    try {
        stream = new ClassPathResource('conf/app-conf.properties').inputStream
        config.load(stream)
    } finally {
        if (stream != null) {
            stream.close()
        }
    }

    // 5.配置无参构造函数Bean，logDao表示Bean名称，括号内LogDao表示要定义的Bean的类名称
    logDao(LogDao) {
        bean ->
            bean.scope = "prototype"    //配置当前Bean的作用域
            bean.initMethod = "init"    //配置当前Bean的初始化方法
            bean.destroyMethod = "destroy"  //配置当前Bean的销毁方法
            bean.lazyInit = true    //配置当前Bean的懒加载
    }

    // 6.根据条件注入Bean，这是Groovy DSL定义Bean的一大亮点
    if ("db" == config.get("dataProvider")) {
        userDao(DbUserDao)
    } else {
        userDao(XmlUserDao)
    }

    // 7.配置有参构造函数注入Bean，参数是userDao
    logonService(LogonService, userDao) {
        logDao = ref("logDao")  // 8.配置属性注入，引用Groovy定义的Bean
        mailService = ref("mailService")    // 9.配置属性注入，引用注解定义Bean
    }

}