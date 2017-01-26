package com.book.bean;

public class BookshelfNow {
    private long user_id;
    private long book_id;
    private java.util.Date add_time;
    private int last_chapter;

    public BookshelfNow(){}
    public BookshelfNow(long user_id, long book_id, java.util.Date add_time, int last_chapter){
        this.user_id = user_id;
        this.book_id = book_id;
        this.add_time = add_time;
        this.last_chapter = last_chapter;
    }

    public long getUser_id(){
        return user_id;
    }
    public void setUser_id(long user_id){
       this.user_id = user_id;
    }
    public long getBook_id(){
        return book_id;
    }
    public void setBook_id(long book_id){
       this.book_id = book_id;
    }
    public java.util.Date getAdd_time(){
        return add_time;
    }
    public void setAdd_time(java.util.Date add_time){
       this.add_time = add_time;
    }
    public int getLast_chapter(){
        return last_chapter;
    }
    public void setLast_chapter(int last_chapter){
       this.last_chapter = last_chapter;
    }
    @Override
    public String toString(){
        return "BookshelfNow{"+
        "user_id="+user_id+
        ",book_id="+book_id+
        ",add_time="+add_time+
        ",last_chapter="+last_chapter+"}";
    }
}
