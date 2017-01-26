package com.book.service;

import com.book.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Myth on 2017/1/25 0025
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    /*
       返回ID，失败返回0
     */
    public long Login(String Email,String password){
        return userDao.Login(Email,password);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
