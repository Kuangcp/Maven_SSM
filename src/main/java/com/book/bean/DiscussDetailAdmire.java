package com.book.bean;

public class DiscussDetailAdmire {
    private long det_ad_id;
    private long user_id;
    private long detail_id;
    private java.util.Date click_time;

    public DiscussDetailAdmire(){}
    public DiscussDetailAdmire(long det_ad_id, long user_id, long detail_id, java.util.Date click_time){
        this.det_ad_id = det_ad_id;
        this.user_id = user_id;
        this.detail_id = detail_id;
        this.click_time = click_time;
    }

    public long getDet_ad_id(){
        return det_ad_id;
    }
    public void setDet_ad_id(long det_ad_id){
       this.det_ad_id = det_ad_id;
    }
    public long getUser_id(){
        return user_id;
    }
    public void setUser_id(long user_id){
       this.user_id = user_id;
    }
    public long getDetail_id(){
        return detail_id;
    }
    public void setDetail_id(long detail_id){
       this.detail_id = detail_id;
    }
    public java.util.Date getClick_time(){
        return click_time;
    }
    public void setClick_time(java.util.Date click_time){
       this.click_time = click_time;
    }
    @Override
    public String toString(){
        return "DiscussDetailAdmire{"+
        "det_ad_id="+det_ad_id+
        ",user_id="+user_id+
        ",detail_id="+detail_id+
        ",click_time="+click_time+"}";
    }
}
