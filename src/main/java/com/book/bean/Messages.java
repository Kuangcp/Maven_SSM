package com.book.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Messages {
    private long message_id;
    private long send;
    private long receive;
    private String title;
    private String message;
    private int readed;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private Date send_time;

    public Messages(){}
    public Messages(long message_id, long send, long receive, String title, String message, 
            int readed,Date send_time){
        this.message_id = message_id;
        this.send = send;
        this.receive = receive;
        this.title = title;
        this.message = message;
        this.readed = readed;
        this.send_time = send_time;
    }
    public Messages (MessagesPlus p){
       this(p.getMessage_id(),p.getSend(),p.getReceive(),p.getTitle(),p.getMessage(),p.getReaded(),p.getSend_time());
    }

    public long getMessage_id(){
        return message_id;
    }
    public void setMessage_id(long message_id){
       this.message_id = message_id;
    }
    public long getSend(){
        return send;
    }
    public void setSend(long send){
       this.send = send;
    }
    public long getReceive(){
        return receive;
    }
    public void setReceive(long receive){
       this.receive = receive;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
       this.title = title;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
       this.message = message;
    }
    public int getReaded(){
        return readed;
    }
    public void setReaded(int readed){
       this.readed = readed;
    }
    public Date getSend_time() {
        return send_time;
    }
    public void setSend_time(Date send_time) {
        this.send_time = send_time;
    }

    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "Messages{"+
        "message_id="+message_id+
        ",send="+send+
        ",receive="+receive+
        ",title="+title+
        ",message="+message+
        ",send_time="+sdf.format(send_time)+
        ",readed="+readed+"}";
    }
}
