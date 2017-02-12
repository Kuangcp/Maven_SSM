package com.book.bean;

public class ClickList {
    private long click_id;
    private long user_id;
    private String ip_address;
    private long catalog_id;
    private long book_id;

    public ClickList(){}
    public ClickList(long click_id, long user_id, String ip_address,
            long catalog_id){
        this.click_id = click_id;
        this.user_id = user_id;
        this.ip_address = ip_address;
        this.catalog_id = catalog_id;
    }

    public long getClick_id(){
        return click_id;
    }
    public void setClick_id(long click_id){
       this.click_id = click_id;
    }
    public long getUser_id(){
        return user_id;
    }
    public void setUser_id(long user_id){
       this.user_id = user_id;
    }
    public String getIp_address(){
        return ip_address;
    }
    public void setIp_address(String ip_address){
       this.ip_address = ip_address;
    }
    public long getCatalog_id(){
        return catalog_id;
    }
    public void setCatalog_id(long catalog_id){
       this.catalog_id = catalog_id;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    @Override
    public String toString(){
        return "ClickList{"+
        "click_id="+click_id+
        ",user_id="+user_id+
        ",ip_address="+ip_address+
        ",book_id="+book_id+
        ",catalog_id="+catalog_id+"}";
    }
}
