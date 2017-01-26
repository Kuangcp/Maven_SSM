package com.book.bean;

public class FatherType {
    private int father_type_id;
    private String type_name;
    private int sex;

    public FatherType(){}
    public FatherType(int father_type_id, String type_name, int sex){
        this.father_type_id = father_type_id;
        this.type_name = type_name;
        this.sex = sex;
    }

    public int getFather_type_id(){
        return father_type_id;
    }
    public void setFather_type_id(int father_type_id){
       this.father_type_id = father_type_id;
    }
    public String getType_name(){
        return type_name;
    }
    public void setType_name(String type_name){
       this.type_name = type_name;
    }
    public int getSex(){
        return sex;
    }
    public void setSex(int sex){
       this.sex = sex;
    }
    @Override
    public String toString(){
        return "FatherType{"+
        "father_type_id="+father_type_id+
        ",type_name="+type_name+
        ",sex="+sex+"}";
    }
}
