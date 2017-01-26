package com.book.bean;

public class Discuss {
    private long discuss_id;
    private long user_id;
    private String title;
    private String content;
    private int admire_num;
    private int discuss_num;
    private int top;
    private int esence;
    private int deletes;

    public Discuss(){}
    public Discuss(long discuss_id, long user_id, String title, String content, int admire_num, 
            int discuss_num, int top, int esence, int deletes){
        this.discuss_id = discuss_id;
        this.user_id = user_id;
        this.title = title;
        this.content = content;
        this.admire_num = admire_num;
        this.discuss_num = discuss_num;
        this.top = top;
        this.esence = esence;
        this.deletes = deletes;
    }

    public long getDiscuss_id(){
        return discuss_id;
    }
    public void setDiscuss_id(long discuss_id){
       this.discuss_id = discuss_id;
    }
    public long getUser_id(){
        return user_id;
    }
    public void setUser_id(long user_id){
       this.user_id = user_id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
       this.title = title;
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
    public int getDiscuss_num(){
        return discuss_num;
    }
    public void setDiscuss_num(int discuss_num){
       this.discuss_num = discuss_num;
    }
    public int getTop(){
        return top;
    }
    public void setTop(int top){
       this.top = top;
    }
    public int getEsence(){
        return esence;
    }
    public void setEsence(int esence){
       this.esence = esence;
    }
    public int getDeletes(){
        return deletes;
    }
    public void setDeletes(int deletes){
       this.deletes = deletes;
    }
    @Override
    public String toString(){
        return "Discuss{"+
        "discuss_id="+discuss_id+
        ",user_id="+user_id+
        ",title="+title+
        ",content="+content+
        ",admire_num="+admire_num+
        ",discuss_num="+discuss_num+
        ",top="+top+
        ",esence="+esence+
        ",deletes="+deletes+"}";
    }
}
