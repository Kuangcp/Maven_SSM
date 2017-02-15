package redis;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Myth on 2017/2/15 0015
 */
public class MythRedisTest {
    private static org.slf4j.Logger Log = LoggerFactory.getLogger(MythRedisTest.class);
    ApplicationContext context = null;
    JedisPoolConfig config = null;
    JedisPool pool = null;
    Jedis jedis = null;

    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("application.xml");
         config= (JedisPoolConfig)context.getBean("jedisPoolConfig");
         pool = new JedisPool(config,"127.0.0.1");
         jedis = pool.getResource();
    }
    @Test
    public void Runs(){
        System.out.println(jedis.get("u"));
    }
}
