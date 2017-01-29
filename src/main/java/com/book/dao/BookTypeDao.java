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

    //可以使用properties但是还是要学下XML的毕竟是学习
    // 学习使用DOM4J来操作xml文件

    // 一次调用getSession就是打开一个连接
    // 需要使用线程管理，不然资源浪费严重，也就是说不要读数据库，读文件
    public List<FatherType> getAllTypes() throws Exception{
        /*List<FatherType> lists = new ArrayList<FatherType>();
        List<BookType> types = new ArrayList<BookType>();
        FatherType fa=new FatherType();
        BookType type = new BookType();
        type.setType_name("type1");
        types.add(type);
        fa.setType_name("Test");
        fa.setBookTypes(types);
        lists.add(fa);*/

        SqlSession session = getSession();
        List list = session.selectList("myth.book.getAll_FatherType");
        for(int i=0;i<list.size();++i){
            ((FatherType)list.get(i)).setBookTypes(getAll("father_type="+((FatherType)list.get(i)).getFather_type_id()));
        }
        return list;
        //使用上诉方式就要频繁查询，获取Session，使用关联关系还要修复下如下方式有问题
//        return getSession().selectList("myth.book.FatherType_List");
    }
}
