package com.book.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Myth on 2017/1/27
 * 为了在JSP方便调用别的类的方法
 */
public class SpringContext {
    public static Object getBean(String name){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        return context.getBean(name);
    }

}
