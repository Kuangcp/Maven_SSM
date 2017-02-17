package com.test.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Myth on 2017/2/16 0016
 */
public class TestRedis {
    @Autowired
    private JedisPool jedisPool;

    public void basicOpTest() {
        Jedis jedis = jedisPool.getResource();
        jedis.set("person.001.name", "frank");
        jedis.set("person.001.city", "beijing");
        String name = jedis.get("person.001.name");
        String city = jedis.get("person.001.city");
        System.out.println(""+name+"-"+city);
        //assertEquals("frank", name);
//        assertEquals("beijing", city);
        jedis.del("person.001.name");
        Boolean result = jedis.exists("person.001.name");
//        assertEquals(false, result);
        result = jedis.exists("person.001.city");
//        assertEquals(true, result);
        jedis.close();
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }
}
