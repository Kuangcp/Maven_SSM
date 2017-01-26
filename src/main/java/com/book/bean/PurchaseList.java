package com.book.bean;

public class PurchaseList {
    private long purchase_id;
    private int chapter_id;
    private long user_id;
    private long book_id;
    private int cash_id;
    private java.util.Date deal_time;
    private int pay_money;

    public PurchaseList(){}
    public PurchaseList(long purchase_id, int chapter_id, long user_id, long book_id, 
            int cash_id, java.util.Date deal_time, int pay_money){
        this.purchase_id = purchase_id;
        this.chapter_id = chapter_id;
        this.user_id = user_id;
        this.book_id = book_id;
        this.cash_id = cash_id;
        this.deal_time = deal_time;
        this.pay_money = pay_money;
    }

    public long getPurchase_id(){
        return purchase_id;
    }
    public void setPurchase_id(long purchase_id){
       this.purchase_id = purchase_id;
    }
    public int getChapter_id(){
        return chapter_id;
    }
    public void setChapter_id(int chapter_id){
       this.chapter_id = chapter_id;
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
    public int getCash_id(){
        return cash_id;
    }
    public void setCash_id(int cash_id){
       this.cash_id = cash_id;
    }
    public java.util.Date getDeal_time(){
        return deal_time;
    }
    public void setDeal_time(java.util.Date deal_time){
       this.deal_time = deal_time;
    }
    public int getPay_money(){
        return pay_money;
    }
    public void setPay_money(int pay_money){
       this.pay_money = pay_money;
    }
    @Override
    public String toString(){
        return "PurchaseList{"+
        "purchase_id="+purchase_id+
        ",chapter_id="+chapter_id+
        ",user_id="+user_id+
        ",book_id="+book_id+
        ",cash_id="+cash_id+
        ",deal_time="+deal_time+
        ",pay_money="+pay_money+"}";
    }
}
