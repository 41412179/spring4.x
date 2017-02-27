package com.smart.dynamic;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

//user-service标签解析类
public class UserServiceDefinitionParser implements BeanDefinitionParser {

    public BeanDefinition parse(Element element, ParserContext parserContext) {

        // 1.通过BeanDefinitionBuilder创建Bean定义
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserService.class);

        // 2.获取自定义标签的属性
        String dao = element.getAttribute("dao");
        beanDefinitionBuilder.addPropertyReference("userDao", dao);
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        // 3.注册Bean定义
        parserContext.registerBeanComponent(new BeanComponentDefinition(beanDefinition, "userService"));

        return null;
    }
}
