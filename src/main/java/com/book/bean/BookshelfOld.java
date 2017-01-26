package com.book.bean;

public class BookshelfOld {
    private long book_id;
    private long user_id;
    private java.util.Date delete_time;

    public BookshelfOld(){}
    public BookshelfOld(long book_id, long user_id, java.util.Date delete_time){
        this.book_id = book_id;
        this.user_id = user_id;
        this.delete_time = delete_time;
    }

    public long getBook_id(){
        return book_id;
    }
    public void setBook_id(long book_id){
       this.book_id = book_id;
    }
    public long getUser_id(){
        return user_id;
    }
    public void setUser_id(long user_id){
       this.user_id = user_id;
    }
    public java.util.Date getDelete_time(){
        return delete_time;
    }
    public void setDelete_time(java.util.Date delete_time){
       this.delete_time = delete_time;
    }
    @Override
    public String toString(){
        return "BookshelfOld{"+
        "book_id="+book_id+
        ",user_id="+user_id+
        ",delete_time="+delete_time+"}";
    }
}
