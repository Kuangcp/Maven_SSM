package mybatis;

import com.book.bean.Book;
import com.book.bean.BookType;
import com.book.bean.FatherType;
import com.book.dao.BookDao;
import com.book.dao.BookTypeDao;
import com.book.dao.MybatisSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
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
    ApplicationContext context = null;


    @Before
    public void init(){
        context = new ClassPathXmlApplicationContext("application.xml");
    }
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
        BookTypeDao dao  =(BookTypeDao) context.getBean("bookTypeDao");
//        BookTypeDao dao = new BookTypeDao();

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
        BookDao dao = (BookDao)context.getBean("bookDao");
        List<Book> list = dao.getAll();
        for (Book b:list){
            Log.info(b.toString());
        }
    }
    @Test
    public void testDelete()throws Exception{
        BookTypeDao dao = (BookTypeDao) context.getBean("bookTypeDao");
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
        BookTypeDao dao = (BookTypeDao) context.getBean("bookTypeDao");
        BookType bookType = dao.getBooksByBookType(2L);
        for(Book book:bookType.getBooks()){
            if(book!=null)Log.info(book.toString());

        }
    }
    //测试关联关系的查询，实现方式有问题
    @Test
    public void testAllType()throws Exception{
        BookTypeDao dao = (BookTypeDao) context.getBean("bookTypeDao");
        List<FatherType> fas = dao.getAllTypes();
        for(FatherType fa:fas){
            for(BookType type:fa.getBookTypes()){
                Log.info(type.toString());
            }
            Log.info("-----------------");
        }
    }
}
