package com.book.dao;

import com.book.bean.Messages;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Myth on 2017/2/5 0005
 */
@Repository
public class MessageDao extends BaseDaoImpl<Messages,Long>{
    /**
     * 获取所有未读消息总数
     * @param id
     * @return
     */
    public int getNoReadNums(long id){
        return getSession().selectOne("myth.book.NoReadNums",id);
    }

    public int getNoReadNum(long receive_id,long send_id){
        Map param = new HashMap();
        param.put("receive",receive_id);
        param.put("send",send_id);
//        System.out.println(receive_id+":"+send_id);
        return getSession().selectOne("myth.book.NoReadNum",param);
    }
}
