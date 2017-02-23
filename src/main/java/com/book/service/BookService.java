package com.book.service;

import com.book.bean.Book;
import com.book.bean.FatherType;
import com.book.dao.BookDao;
import com.book.dao.BookTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Myth on 2017/1/25 0025
 */
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookTypeDao bookTypeDao;

    public List<FatherType> getAllTypes(){
        List<FatherType> list = null;
        try{
            list = bookTypeDao.getAllTypes();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 查询书籍
     * @param params
     * @return
     */
    public List<Book> queryBook(List<String> params){
        List<Book> list = null;
        try{
            list = bookDao.getAll(params);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public BookTypeDao getBookTypeDao() {
        return bookTypeDao;
    }

    public void setBookTypeDao(BookTypeDao bookTypeDao) {
        this.bookTypeDao = bookTypeDao;
    }
}
