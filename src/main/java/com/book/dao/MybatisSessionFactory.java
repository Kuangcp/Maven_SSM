package com.book.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Myth on 2017/1/21 0021
 * Session的工厂类，为了getSession方便 最好不用static然后加载配置文件 而是使用Spring注入一个已有的工厂
 */
@Component
public class MybatisSessionFactory {

    @Autowired
    private  SqlSessionFactory sessionFactory;
    private static org.slf4j.Logger Log = LoggerFactory.getLogger(MybatisSessionFactory.class);
    //使用本地线程组能避免不必要的Session开支，加强性能
    private static final ThreadLocal<SqlSession> THREAD_LOCAL = new ThreadLocal<SqlSession>();
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

        SqlSession session = (SqlSession)THREAD_LOCAL.get();
        if(session==null ){
            session = this.sessionFactory.openSession();
            THREAD_LOCAL.set(session);
        }
        Log.info("__获取了一个Session__"+session);
        return session;
    }
    /*
        关闭连接
     */
    public void closeSession(){
        SqlSession session = (SqlSession)THREAD_LOCAL.get();
        THREAD_LOCAL.set(null);
        if(session!=null){
            session.close();
        }

    }

    public  SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public  void setSessionFactory(SqlSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
