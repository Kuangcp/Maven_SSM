package com.book.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Myth on 2017/2/6 0006
 */
public class MessagesPlus {
    private long message_id;
    private long send;
    private long receive;
    private String title;
    private String message;
    private int readed;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date send_time;
    private String receive_name;

    //空构造器不能少 艹
    public MessagesPlus(){}
    public MessagesPlus(long message_id, long send, long receive, String receive_name,String title, String message, Date send_time, int readed) {
        this.message_id = message_id;
        this.send = send;
        this.receive = receive;
        this.title = title;
        this.message = message;
        this.readed = readed;
        this.receive_name = receive_name;
        this.send_time = send_time;
    }
    public MessagesPlus(Messages me,String receive_name){
        this(me.getMessage_id(),me.getSend(),me.getReceive(),receive_name,me.getTitle(),me.getMessage(),me.getSend_time(),me.getReaded());
    }

    public String getReceive_name() {
        return receive_name;
    }

    public void setReceive_name(String receive_name) {
        this.receive_name = receive_name;
    }

    public long getMessage_id() {
        return message_id;
    }

    public void setMessage_id(long message_id) {
        this.message_id = message_id;
    }

    public long getSend() {
        return send;
    }

    public void setSend(long send) {
        this.send = send;
    }

    public long getReceive() {
        return receive;
    }

    public void setReceive(long receive) {
        this.receive = receive;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getReaded() {
        return readed;
    }

    public void setReaded(int readed) {
        this.readed = readed;
    }

    public Date getSend_time() {
        return send_time;
    }

    public void setSend_time(Date send_time) {
        this.send_time = send_time;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "MessagesPlus{" +
                "message_id=" + message_id +
                ", send=" + send +
                ", receive=" + receive +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", readed=" + readed +
                ", send_time=" + sdf.format(send_time) +
                ", receive_name='" + receive_name + '\'' +
                '}';
    }
}
