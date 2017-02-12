package mybatis;

import com.book.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Myth on 2017/2/12 0012
 */
public class TestMethod {
    private static org.slf4j.Logger Log = LoggerFactory.getLogger(TestRunable.class);
    ApplicationContext context = null;
    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("application.xml");
    }

    // 测试未读消息查询
    @Test
    public void TestNums(){
        long id = 2000000001L;
        long send = 2000000002L;
        MessageService messageService = (MessageService) context.getBean("messageService");
        int result = messageService.getNoReadMessage(id);
        int result2 = messageService.getNoReadMessageOne(id,send);
        Log.info(id+" = "+result);
        Log.info(send+"->"+id+"="+result2);
    }
}
