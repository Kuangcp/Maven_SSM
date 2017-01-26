package com.book.service;

import com.book.dao.BookDao;
import com.book.dao.BookTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Myth on 2017/1/25 0025
 */
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private BookTypeDao bookTypeDao;

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
