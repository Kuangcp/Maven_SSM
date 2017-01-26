package com.book.bean;

public class DiscussDetail {
    private long detail_id;
    private long discuss_id;
    private java.util.Date push_time;
    private long user_id;
    private String content;
    private int admire_num;

    public DiscussDetail(){}
    public DiscussDetail(long detail_id, long discuss_id, java.util.Date push_time, 
            long user_id, String content, int admire_num){
        this.detail_id = detail_id;
        this.discuss_id = discuss_id;
        this.push_time = push_time;
        this.user_id = user_id;
        this.content = content;
        this.admire_num = admire_num;
    }

    public long getDetail_id(){
        return detail_id;
    }
    public void setDetail_id(long detail_id){
       this.detail_id = detail_id;
    }
    public long getDiscuss_id(){
        return discuss_id;
    }
    public void setDiscuss_id(long discuss_id){
       this.discuss_id = discuss_id;
    }
    public java.util.Date getPush_time(){
        return push_time;
    }
    public void setPush_time(java.util.Date push_time){
       this.push_time = push_time;
    }
    public long getUser_id(){
        return user_id;
    }
    public void setUser_id(long user_id){
       this.user_id = user_id;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
       this.content = content;
    }
    public int getAdmire_num(){
        return admire_num;
    }
    public void setAdmire_num(int admire_num){
       this.admire_num = admire_num;
    }
    @Override
    public String toString(){
        return "DiscussDetail{"+
        "detail_id="+detail_id+
        ",discuss_id="+discuss_id+
        ",push_time="+push_time+
        ",user_id="+user_id+
        ",content="+content+
        ",admire_num="+admire_num+"}";
    }
}
