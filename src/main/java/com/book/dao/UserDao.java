package com.book.dao;

import com.book.bean.Users;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Myth on 2017/1/25
 * 用户的数据操作类
 */
@Repository
public class UserDao extends BaseDaoImpl<Users,Long>{

    /*
       返回ID，失败返回0
     */
    public long Login(String Email,String Password){
        SqlSession session = getSession();
        Map map = new HashMap();
        map.put("email",Email);
        map.put("password",Password);
        long result = session.selectOne("myth.book.login",map);
        return result;
    }
}
