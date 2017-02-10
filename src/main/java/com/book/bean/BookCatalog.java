package com.book.bean;

public class BookCatalog {
    private long catalog_id;
    private int chapter_id;
    private long book_id;
    private String chapter_name;
    private String content;
    private java.util.Date up_time;
    private int chapter_character;

    public BookCatalog(){}
    public BookCatalog(long catalog_id,int chapter_id, long book_id, String chapter_name, String content,
            java.util.Date up_time, int chapter_character){
        this.catalog_id = catalog_id;
        this.chapter_id = chapter_id;
        this.book_id = book_id;
        this.chapter_name = chapter_name;
        this.content = content;
        this.up_time = up_time;
        this.chapter_character = chapter_character;
    }

    public int getChapter_id(){
        return chapter_id;
    }
    public void setChapter_id(int chapter_id){
       this.chapter_id = chapter_id;
    }
    public long getBook_id(){
        return book_id;
    }
    public void setBook_id(long book_id){
       this.book_id = book_id;
    }
    public String getChapter_name(){
        return chapter_name;
    }
    public void setChapter_name(String chapter_name){
       this.chapter_name = chapter_name;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
       this.content = content;
    }
    public java.util.Date getUp_time(){
        return up_time;
    }
    public void setUp_time(java.util.Date up_time){
       this.up_time = up_time;
    }
    public int getChapter_character(){
        return chapter_character;
    }
    public void setChapter_character(int chapter_character){
       this.chapter_character = chapter_character;
    }

    public long getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(long catalog_id) {
        this.catalog_id = catalog_id;
    }

    @Override
    public String toString(){
        return "BookCatalog{"+
        "chapter_id="+chapter_id+
        ",book_id="+book_id+
        ",chapter_name="+chapter_name+
        ",content="+content+
        ",up_time="+up_time+
        ",catalog="+catalog_id+
        ",chapter_character="+chapter_character+"}";
    }
}
