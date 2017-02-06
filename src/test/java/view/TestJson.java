package view;

import com.book.bean.MessagesPlus;
import com.book.service.MessageService;
import com.book.util.SpringContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Myth on 2017/2/6 0006
 */
public class TestJson {
    private static org.slf4j.Logger Log = LoggerFactory.getLogger(TestJson.class);

    @Test
    public void ReadJson()throws Exception{
//        String message="{\"send\":\"2000000002\",\"receive\":\"2000000001\",\"title\":\"发送至 00 \",\"message\":\"54354\",\"send_time\":\"2017-02-06 10:39:02\"}";
        String message = "{\"send\":\"2000000002\",\"receive\":\"2000000001\",\"receive_name\":\"jk \",\"title\":\"发送至 00 \",\"message\":\"54354\",\"send_time\":\"2017-02-06 10:39:02\",\"readed\":0}";
//        List<Messages> list = JSON.parseArray(message, Messages.class);
//        for(int i=0;i<list.size();++i){
//            Log.info(list.get(0).toString());
//        }
//        MessageDao dao  = (MessageDao) SpringContext.getBean("messageDao");
//        dao.save(list.get(0));
        ObjectMapper mapper = new ObjectMapper();
        MessagesPlus as = mapper.readValue(message,MessagesPlus.class);
//        Messages as = mapper.readValue(message,Messages.class);

        Log.info(as.toString());

    }
    @Test
    public void testInt(){
        int a = 10;
        add(a);
        Log.info("a = "+a);
    }
    public int add (int a ){
//        a = new Integer(a*10);
        return a*10;
    }
    @Test
    public void testMessages(){
        MessageService s = (MessageService) SpringContext.getBean("messageService");
        List<MessagesPlus> list = s.getNowMessages(2000000002);
        for(MessagesPlus p :list){
            Log.info(p.toString());
        }
    }
}
