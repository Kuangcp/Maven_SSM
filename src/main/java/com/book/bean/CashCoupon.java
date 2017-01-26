package com.book.bean;

public class CashCoupon {
    private int cash_id;
    private String name;
    private float discount;
    private int preferential;
    private java.util.Date start_time;
    private java.util.Date end_time;

    public CashCoupon(){}
    public CashCoupon(int cash_id, String name, float discount, int preferential, 
            java.util.Date start_time, java.util.Date end_time){
        this.cash_id = cash_id;
        this.name = name;
        this.discount = discount;
        this.preferential = preferential;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public int getCash_id(){
        return cash_id;
    }
    public void setCash_id(int cash_id){
       this.cash_id = cash_id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
       this.name = name;
    }
    public float getDiscount(){
        return discount;
    }
    public void setDiscount(float discount){
       this.discount = discount;
    }
    public int getPreferential(){
        return preferential;
    }
    public void setPreferential(int preferential){
       this.preferential = preferential;
    }
    public java.util.Date getStart_time(){
        return start_time;
    }
    public void setStart_time(java.util.Date start_time){
       this.start_time = start_time;
    }
    public java.util.Date getEnd_time(){
        return end_time;
    }
    public void setEnd_time(java.util.Date end_time){
       this.end_time = end_time;
    }
    @Override
    public String toString(){
        return "CashCoupon{"+
        "cash_id="+cash_id+
        ",name="+name+
        ",discount="+discount+
        ",preferential="+preferential+
        ",start_time="+start_time+
        ",end_time="+end_time+"}";
    }
}
