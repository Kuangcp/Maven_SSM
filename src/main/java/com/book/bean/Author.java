package com.book.bean;

public class Author {
    private long author_id;
    private String name;
    private int sex;
    private String id_card;
    private String true_name;
    private long account;
    private String password;
    private String qq;
    private String phone;
    private String email;

    public Author(){}
    public Author(long author_id, String name, int sex, String id_card, String true_name, 
            long account, String password, String qq, String phone, String email){
        this.author_id = author_id;
        this.name = name;
        this.sex = sex;
        this.id_card = id_card;
        this.true_name = true_name;
        this.account = account;
        this.password = password;
        this.qq = qq;
        this.phone = phone;
        this.email = email;
    }

    public long getAuthor_id(){
        return author_id;
    }
    public void setAuthor_id(long author_id){
       this.author_id = author_id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
       this.name = name;
    }
    public int getSex(){
        return sex;
    }
    public void setSex(int sex){
       this.sex = sex;
    }
    public String getId_card(){
        return id_card;
    }
    public void setId_card(String id_card){
       this.id_card = id_card;
    }
    public String getTrue_name(){
        return true_name;
    }
    public void setTrue_name(String true_name){
       this.true_name = true_name;
    }
    public long getAccount(){
        return account;
    }
    public void setAccount(long account){
       this.account = account;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
       this.password = password;
    }
    public String getQq(){
        return qq;
    }
    public void setQq(String qq){
       this.qq = qq;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
       this.phone = phone;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
       this.email = email;
    }
    @Override
    public String toString(){
        return "Author{"+
        "author_id="+author_id+
        ",name="+name+
        ",sex="+sex+
        ",id_card="+id_card+
        ",true_name="+true_name+
        ",account="+account+
        ",password="+password+
        ",qq="+qq+
        ",phone="+phone+
        ",email="+email+"}";
    }
}
