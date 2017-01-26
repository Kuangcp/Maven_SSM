package mybatis;

import com.book.bean.Book;
import com.book.bean.BookType;
import com.book.dao.BookDao;
import com.book.dao.BookTypeDao;
import com.book.dao.MybatisSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Myth on 2017/1/21 0021
 * Mybatis 部署成功
 */
public class TestRunable {
    private static org.slf4j.Logger Log = LoggerFactory.getLogger(TestRunable.class);
    @Test
    public void Runable(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //首字母小写
        MybatisSessionFactory factory = (MybatisSessionFactory) context.getBean("mybatisSessionFactory");
        SqlSession session = factory.getSession();
        List<BookType> list = session.selectList("myth.book.getAll_BookType");
        System.out.println("session对象： "+session);

        Log.info(" list "+list.size());

        for(BookType b:list){
            System.out.println(b.toString());
        }
    }
    @Test
    public void TestBookTypeQuery() throws Exception{
        BookTypeDao dao = new BookTypeDao();

        List params = new ArrayList();
        //多条件查询
        params.add("book_type=10");
        params.add("father_type=2");
        List list = dao.getAll(params);
        //单条件查询
        //        List list = dao.getAll("book_type=34");
        for(Object o:list){
            Log.info(""+o);
        }
    }
    @Test
    public void testBookQuery()throws Exception{
        BookDao dao = new BookDao();
        List<Book> list = dao.getAll();
        for (Book b:list){
            Log.info(b.toString());
        }
    }
    @Test
    public void testDelete()throws Exception{
        BookTypeDao dao = new BookTypeDao();
        BookType b = new BookType();
        b.setBook_type(82);
        b.setType_name("?");
        b.setSex(5);
        b.setFather_type(5);
        Log.info(b.toString());
        dao.update(b);
        //查询单个
//        BookType b = (BookType)dao.getOne(12L);
//        Log.info(b.toString());
    }
    //测试一对多关系
    @Test
    public void testCollection() throws Exception{
        BookTypeDao dao = new BookTypeDao();
        BookType bookType = dao.getBooksByBookType(2L);
        for(Book book:bookType.getBooks()){
            Log.info(book.toString());

        }
    }
}
