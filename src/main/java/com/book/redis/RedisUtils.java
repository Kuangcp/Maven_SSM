package com.book.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Myth on 2017/2/16 0016
 * 不保证单例，直接实例化
 */
@Component
public class RedisUtils {

    @Autowired
    private JedisPool pool;
    private Jedis jedis;

    //获取连接
    public Jedis getConnect(){
        //pool = new JedisPool(config,"127.0.0.1");
        jedis = pool.getResource();
        return jedis;
    }

    public void setObject(Object obj){

    }
    public JedisPool getPool() {
        return pool;
    }

    public void setPool(JedisPool pool) {
        this.pool = pool;
    }
}
