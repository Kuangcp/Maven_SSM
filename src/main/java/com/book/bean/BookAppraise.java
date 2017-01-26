package com.book.bean;

public class BookAppraise {
    private long appraise_id;
    private long user_id;
    private int score;
    private String content;
    private int admire_num;
    private java.util.Date push_time;

    public BookAppraise(){}
    public BookAppraise(long appraise_id, long user_id, int score, String content, 
            int admire_num, java.util.Date push_time){
        this.appraise_id = appraise_id;
        this.user_id = user_id;
        this.score = score;
        this.content = content;
        this.admire_num = admire_num;
        this.push_time = push_time;
    }

    public long getAppraise_id(){
        return appraise_id;
    }
    public void setAppraise_id(long appraise_id){
       this.appraise_id = appraise_id;
    }
    public long getUser_id(){
        return user_id;
    }
    public void setUser_id(long user_id){
       this.user_id = user_id;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int score){
       this.score = score;
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
    public java.util.Date getPush_time(){
        return push_time;
    }
    public void setPush_time(java.util.Date push_time){
       this.push_time = push_time;
    }
    @Override
    public String toString(){
        return "BookAppraise{"+
        "appraise_id="+appraise_id+
        ",user_id="+user_id+
        ",score="+score+
        ",content="+content+
        ",admire_num="+admire_num+
        ",push_time="+push_time+"}";
    }
}
