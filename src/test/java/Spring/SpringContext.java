package Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Myth on 2017/2/7 0007
 */
public class SpringContext {
    private static ApplicationContext context;
    static{
        context = new ClassPathXmlApplicationContext("application.xml");
    }
    public static Object getBean(String name){
        return context.getBean(name);
    }
}
