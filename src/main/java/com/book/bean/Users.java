package com.book.bean;

public class Users {
    private long user_id;
    private String name;
    private int sex;
    private java.util.Date birthday;
    private long account;
    private String password;
    private String email;

    public Users(){}
    public Users(long user_id, String name, int sex, java.util.Date birthday, long account, 
            String password, String email){
        this.user_id = user_id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.account = account;
        this.password = password;
        this.email = email;
    }

    public long getUser_id(){
        return user_id;
    }
    public void setUser_id(long user_id){
       this.user_id = user_id;
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
    public java.util.Date getBirthday(){
        return birthday;
    }
    public void setBirthday(java.util.Date birthday){
       this.birthday = birthday;
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
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
       this.email = email;
    }
    @Override
    public String toString(){
        return "Users{"+
        "user_id="+user_id+
        ",name="+name+
        ",sex="+sex+
        ",birthday="+birthday+
        ",account="+account+
        ",password="+password+
        ",email="+email+"}";
    }
}
