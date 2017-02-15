package com.book.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Myth on 2017/2/15 0015
 */
@Component
public class SystemInit implements ServletContextListener {

    RedisUtil util = new RedisUtil();
    private static Logger logger = LoggerFactory.getLogger(SystemInit.class);
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("初始化系统");
        Jedis cache = util.getJedis();
        System.out.println("缓存结果 : "+cache.get("u"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("系统销毁");
    }

    public RedisUtil getUtil() {
        return util;
    }

    public void setUtil(RedisUtil util) {
        this.util = util;
    }
}
