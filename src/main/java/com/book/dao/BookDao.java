package com.book.dao;

import com.book.bean.Book;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Myth on 2017/1/25 0025
 */
@Repository
public class BookDao extends BaseDaoImpl<Book,Long>{

    // 多参数的查询书籍,参数<--->值
//    public List<Book> queryBook(HashMap<String,String> params){
//        SqlSession session = getSession();
//        List<Book> list = session.selectList("query_Book",params);
//        return list;
//    }

}
