package Spring;

import com.book.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Myth on 2017/1/25 0025
 * 测试SPringMVC使用的service类方法
 */
public class TestRunable {
    private static Logger Log = LoggerFactory.getLogger(TestRunable.class);

    @Test
    public void testLogin(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //首字母小写
        UserService user = (UserService) context.getBean("userService");
        Log.info(user.Login("15979940275@163.com","13")+"");
    }
}
