package com.book.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Myth on 2017/1/21 0021
 * Session的工厂类，为了getSession方便 最好不用static 使用Spring注入
 */
@Component
public class MybatisSessionFactory {
    private static org.slf4j.Logger Log = LoggerFactory.getLogger(MybatisSessionFactory.class);
    @Autowired
    private  SqlSessionFactory sessionFactory;
/*    static{
        try {
            String resource = "mybatis.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            System.out.println("获取Session失败");
        }
    }*/

    /**
     * 获取Session
     * @return
     */
    public  SqlSession getSession(){

        SqlSession session = null;
        session = this.sessionFactory.openSession();
        Log.info("获取了一个Session"+session);
        return session;
    }

    public  SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public  void setSessionFactory(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
