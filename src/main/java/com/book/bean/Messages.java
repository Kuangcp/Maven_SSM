package com.book.bean;

public class Messages {
    private long message_id;
    private long send;
    private long receive;
    private String title;
    private String message;
    private int readed;

    public Messages(){}
    public Messages(long message_id, long send, long receive, String title, String message, 
            int readed){
        this.message_id = message_id;
        this.send = send;
        this.receive = receive;
        this.title = title;
        this.message = message;
        this.readed = readed;
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
    @Override
    public String toString(){
        return "Messages{"+
        "message_id="+message_id+
        ",send="+send+
        ",receive="+receive+
        ",title="+title+
        ",message="+message+
        ",readed="+readed+"}";
    }
}
