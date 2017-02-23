package com.book.service;

import com.book.bean.Author;
import com.book.dao.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/02/23.
 * Service 用来处理dao可能出现的异常，和日志记录
 */
@Service
public class AuthorService {
    @Autowired
    AuthorDao authorDao;

    public List<Author> getAll(List<String> params){
        List<Author> list =null;
        try{
            list = authorDao.getAll(params);
        }catch(Exception e ){
            e.printStackTrace();
        }
        return list;
    }

    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }
}
