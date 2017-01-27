package com.book.dao;

import com.book.bean.BookType;
import com.book.bean.FatherType;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Myth on 2017/1/21 0021
 * BookType 数据操作类
 */
@Repository
public class BookTypeDao extends BaseDaoImpl<BookType,Long>{

    /*
        返回的是BookType 一方，含有多方数据
        通过查询BookType得到Book集合
     */
    public BookType getBooksByBookType(long book_type) throws Exception{
        SqlSession session = getSession();
        return session.selectOne("myth.book.link_book",book_type);
    }

    public List<FatherType> getAllTypes() throws Exception{
        return getSession().selectList("myth.book.FatherType_List");
    }
}
