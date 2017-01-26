package com.book.bean;

public class StaticStatus {
    private String status_name;
    private String status_value;

    public StaticStatus(){}
    public StaticStatus(String status_name, String status_value){
        this.status_name = status_name;
        this.status_value = status_value;
    }

    public String getStatus_name(){
        return status_name;
    }
    public void setStatus_name(String status_name){
       this.status_name = status_name;
    }
    public String getStatus_value(){
        return status_value;
    }
    public void setStatus_value(String status_value){
       this.status_value = status_value;
    }
    @Override
    public String toString(){
        return "StaticStatus{"+
        "status_name="+status_name+
        ",status_value="+status_value+"}";
    }
}
