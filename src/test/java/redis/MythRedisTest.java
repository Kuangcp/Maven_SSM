package redis;

import com.book.redis.RedisUtils;
import com.book.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Myth on 2017/2/15 0015
 * 测试Redis的工具类的方法
 */
public class MythRedisTest {
    private static org.slf4j.Logger Log = LoggerFactory.getLogger(MythRedisTest.class);
    ApplicationContext context = null;
    Jedis jedis = null;
    //@Autowired
    private BookService bookService;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("application.xml");
        RedisUtils util = (RedisUtils) context.getBean("redisUtils");
        jedis = util.getConnect();
    }
    @Test
    public void Runs(){
        System.out.println(jedis.get("u"));
    }

    @Test
    public void test(){
        RedisUtils util  = (RedisUtils) context.getBean("redisUtils");
        jedis = util.getConnect();
        jedis.set("u","hello");
        System.out.println(jedis.get("u"));

        jedis.del("u");
        System.out.println(jedis.get("u"));
    }


    @Test
    public void TestMap() {
        //map 适合存放一个对象

        Map<String,String> Book = new HashMap<String,String>();
        jedis.hmset("",Book);
        Log.info("OutPut:"+jedis.get("u"));
    }
    // 测试正确存入书籍数据， 并正确读取数据
    @Test
    public void TestList(){
//        载入数据
//        jedis.del("BookFatherType");
//        bookService = (BookService) context.getBean("bookService");
//        List<FatherType> list = bookService.getAllTypes();
//        int FatherSize = list.size();
//        for(int i=FatherSize-1;i>=0;i--){
//            FatherType fatherType = list.get(i);
//            // 放入父类
//            jedis.lpush("BookFatherType",fatherType.getType_name());
//            List<BookType> types = fatherType.getBookTypes();
//            int TypeSize = types.size();
//            jedis.del(fatherType.getType_name());
//            for(int j=TypeSize-1;j>=0;j--){
//                jedis.lpush(fatherType.getType_name(),types.get(j).getType_name());
//            }
//        }
//        获取数据
        List<String> types = jedis.lrange("BookFatherType",0,-1);
        //Log.info(jedis.lrange("BookFatherType",0,-1).toString());
        for(int i=0;i<types.size();i++){
            Log.info("|"+types.get(i)+"|");
            List type = jedis.lrange(types.get(i),0,-1);
            for (int j=0;j<type.size();j++){
                Log.info(j+"/"+type.get(j)+"/");
            }
        }

    }


    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }
}
