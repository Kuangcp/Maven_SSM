package com.book.service;

import com.book.bean.Author;
import com.book.bean.Messages;
import com.book.bean.MessagesPlus;
import com.book.bean.Users;
import com.book.dao.AuthorDao;
import com.book.dao.MessageDao;
import com.book.dao.UserDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Myth on 2017/2/6 0006
 */
@Service
public class MessageService {
    @Autowired
    UserDao userDao;
    @Autowired
    AuthorDao authorDao;
    @Autowired
    MessageDao messageDao;
    private static org.slf4j.Logger Log = LoggerFactory.getLogger(MessageService.class);

    /**
     * 获取未读取的消息
     * @param id
     * @return
     */
    public List<MessagesPlus> getNowMessages(long id){
        List<Messages> list = null;
        List<MessagesPlus> lists = new ArrayList<MessagesPlus>();
        String name="";
        try {
            list = messageDao.getAll("receive="+id+"");
            for(int i=0;i<list.size();i++){
                Messages m = list.get(i);
                long sendid = m.getSend();

                String temp = sendid+"";

                if(temp.length()==12){
                    Users u = (Users)userDao.getOne(sendid);
                    if(u!=null ) name = u.getName();
                }else if(temp.length()==10){
                    Author a = (Author)authorDao.getOne(sendid);
                    if(a!=null) name = a.getName();
                }
                Log.info("["+temp+"]["+name+"]");
                MessagesPlus p = new MessagesPlus(m,name);
                lists.add(p);
            }} catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public AuthorDao getAuthorDao() {
        return authorDao;
    }

    public void setAuthorDao(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }
}
