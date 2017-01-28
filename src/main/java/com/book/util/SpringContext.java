package com.book.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Myth on 2017/1/27
 * 为了在JSP方便调用别的类的方法
 */
public class SpringContext {
    private static ApplicationContext context;
    static {
        context = new ClassPathXmlApplicationContext("application.xml");
    }
    public static Object getBean(String name){
        return context.getBean(name);
    }

}
