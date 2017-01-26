package com.book.bean;

public class DiscussAdmire {
    private long dis_ad_id;
    private long user_id;
    private long discuss_id;
    private java.util.Date click_time;

    public DiscussAdmire(){}
    public DiscussAdmire(long dis_ad_id, long user_id, long discuss_id, java.util.Date click_time){
        this.dis_ad_id = dis_ad_id;
        this.user_id = user_id;
        this.discuss_id = discuss_id;
        this.click_time = click_time;
    }

    public long getDis_ad_id(){
        return dis_ad_id;
    }
    public void setDis_ad_id(long dis_ad_id){
       this.dis_ad_id = dis_ad_id;
    }
    public long getUser_id(){
        return user_id;
    }
    public void setUser_id(long user_id){
       this.user_id = user_id;
    }
    public long getDiscuss_id(){
        return discuss_id;
    }
    public void setDiscuss_id(long discuss_id){
       this.discuss_id = discuss_id;
    }
    public java.util.Date getClick_time(){
        return click_time;
    }
    public void setClick_time(java.util.Date click_time){
       this.click_time = click_time;
    }
    @Override
    public String toString(){
        return "DiscussAdmire{"+
        "dis_ad_id="+dis_ad_id+
        ",user_id="+user_id+
        ",discuss_id="+discuss_id+
        ",click_time="+click_time+"}";
    }
}
