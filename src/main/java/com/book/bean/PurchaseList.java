package com.book.bean;

public class PurchaseList {
    private long purchase_id;
    private long user_id;
    private long catalog_id;
    private int cash_id;
    private java.util.Date deal_time;
    private int pay_money;

    public PurchaseList(){}
    public PurchaseList(long purchase_id,long user_id, long catalog_id,
            int cash_id, java.util.Date deal_time, int pay_money){
        this.purchase_id = purchase_id;
        this.user_id = user_id;
        this.catalog_id = catalog_id;
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
    public long getUser_id(){
        return user_id;
    }
    public void setUser_id(long user_id){
       this.user_id = user_id;
    }
    public long getCatalog_id(){
        return catalog_id;
    }
    public void setCatalog_id(long catalog_id){
       this.catalog_id = catalog_id;
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
        ",user_id="+user_id+
        ",catalog_id="+catalog_id+
        ",cash_id="+cash_id+
        ",deal_time="+deal_time+
        ",pay_money="+pay_money+"}";
    }
}
