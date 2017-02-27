package com.smart.dynamic;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

//将UserServiceDefinitionParser解析器注册到Spring命名空间解析器
public class UserServiceNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("user-service", new UserServiceDefinitionParser());
    }
}
