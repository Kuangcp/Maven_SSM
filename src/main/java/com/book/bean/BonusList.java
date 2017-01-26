package com.book.bean;

public class BonusList {
    private long income_id;
    private long book_id;
    private long user_id;
    private int income;

    public BonusList(){}
    public BonusList(long income_id, long book_id, long user_id, int income){
        this.income_id = income_id;
        this.book_id = book_id;
        this.user_id = user_id;
        this.income = income;
    }

    public long getIncome_id(){
        return income_id;
    }
    public void setIncome_id(long income_id){
       this.income_id = income_id;
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
    public int getIncome(){
        return income;
    }
    public void setIncome(int income){
       this.income = income;
    }
    @Override
    public String toString(){
        return "BonusList{"+
        "income_id="+income_id+
        ",book_id="+book_id+
        ",user_id="+user_id+
        ",income="+income+"}";
    }
}
