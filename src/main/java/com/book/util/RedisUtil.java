package com.book.util;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Myth on 2017/2/15
 * 为了获取和 Redis的连接代理对象，单例的连接池
 */
@Component
public class RedisUtil {
    private static org.slf4j.Logger Log = LoggerFactory.getLogger(RedisUtil.class);
    @Autowired
    private JedisPoolConfig config;
    private JedisPool pool;
    private Jedis jedis;

    /**
     * 使用了双重锁确保单例
     * @return
     */
    public JedisPool getPool(){
        if(pool==null){
            synchronized (JedisPool.class){
                if(pool==null){
                    System.out.println("9090"+config);
                    pool = new JedisPool(config,"127.0.0.1");
                }
            }
        }
        return pool;
    }
    //初始化参数
    public Jedis getJedis(){
        pool = getPool();
//        pool = new JedisPool(config,"127.0.0.1");
        jedis = pool.getResource();
        return jedis;
    }

    public JedisPoolConfig getConfig() {
        return config;
    }

    public void setConfig(JedisPoolConfig config) {
        this.config = config;
    }
}
