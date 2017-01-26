package com.book.bean;

public class BookAppraiseAdmire {
    private long app_ad_id;
    private long user_id;
    private long appraise_id;
    private java.util.Date click_time;

    public BookAppraiseAdmire(){}
    public BookAppraiseAdmire(long app_ad_id, long user_id, long appraise_id, java.util.Date click_time){
        this.app_ad_id = app_ad_id;
        this.user_id = user_id;
        this.appraise_id = appraise_id;
        this.click_time = click_time;
    }

    public long getApp_ad_id(){
        return app_ad_id;
    }
    public void setApp_ad_id(long app_ad_id){
       this.app_ad_id = app_ad_id;
    }
    public long getUser_id(){
        return user_id;
    }
    public void setUser_id(long user_id){
       this.user_id = user_id;
    }
    public long getAppraise_id(){
        return appraise_id;
    }
    public void setAppraise_id(long appraise_id){
       this.appraise_id = appraise_id;
    }
    public java.util.Date getClick_time(){
        return click_time;
    }
    public void setClick_time(java.util.Date click_time){
       this.click_time = click_time;
    }
    @Override
    public String toString(){
        return "BookAppraiseAdmire{"+
        "app_ad_id="+app_ad_id+
        ",user_id="+user_id+
        ",appraise_id="+appraise_id+
        ",click_time="+click_time+"}";
    }
}
