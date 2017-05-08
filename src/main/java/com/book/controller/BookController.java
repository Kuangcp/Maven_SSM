package com.book.controller;

import com.book.bean.Author;
import com.book.bean.Book;
import com.book.dao.AuthorDao;
import com.book.service.AuthorService;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Myth on 2017/2/11 
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;

    /**
     * 查询书籍或作家，是自动查询的
     * @return 
     */
    @RequestMapping("/search/{type}/{value}")
    public ModelAndView Query(@PathVariable("type") String type,@PathVariable("value") String value){
        List<String> book_params = new ArrayList<String>();
        book_params.add("");
        List<Book> bookList = bookService.queryBook(book_params);
        List<String> author_params = new ArrayList<String>();
        author_params.add("");
        List<Author> authorList = authorService.getAll(author_params);
        ModelAndView view = new ModelAndView("search");
        return view;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public AuthorService getAuthorService() {
        return authorService;
    }

    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }
}
