package com.smart.i18n;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.GregorianCalendar;
import java.util.Locale;

public class I18nGreeting {

    public static void rsrBdlMessageSource() {
        String[] config = {"com/smart/i18n/beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        MessageSource ms = (MessageSource) ctx.getBean("myResource1");
        Object[] params = {"John", new GregorianCalendar().getTime()};

        String str1 = ms.getMessage("greeting.common", params, Locale.US);
        String str2 = ms.getMessage("greeting.morning", params, Locale.CHINA);
        String str3 = ms.getMessage("greeting.afternoon", params, Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
    }

    public static void rrsrBdlMessageSource() throws Exception {
        String[] config = {"com/smart/i18n/beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        MessageSource ms = (MessageSource) ctx.getBean("myResource2");
        Object[] params = {"John", new GregorianCalendar().getTime()};

        for (int i = 0; i < 2; i ++) {
            String str1 = ms.getMessage("greeting.common", params, Locale.US);
            System.out.println(str1);
            Thread.sleep(10000);//再次期间更改资源文件
        }
    }

    public static void ctxMessageResource() {
        String[] config = {"com/smart/i18n/beans.xml"};
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        //直接通过容器访问国际化信息资源
        Object[] params = {"John", new GregorianCalendar().getTime()};

        String str1 = ctx.getMessage("greeting.common", params, Locale.US);
        String str2 = ctx.getMessage("greeting.morning", params, Locale.CHINA);
        System.out.println(str1);
        System.out.println(str2);
    }

    public static void main(String[] args) throws Exception {
        rsrBdlMessageSource();
        rrsrBdlMessageSource();
        ctxMessageResource();
    }
}
