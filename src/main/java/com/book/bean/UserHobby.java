package com.book.bean;

public class UserHobby {
    private long hobby_id;
    private long user_id;
    private int book_type;

    public UserHobby(){}
    public UserHobby(long hobby_id, long user_id, int book_type){
        this.hobby_id = hobby_id;
        this.user_id = user_id;
        this.book_type = book_type;
    }

    public long getHobby_id(){
        return hobby_id;
    }
    public void setHobby_id(long hobby_id){
       this.hobby_id = hobby_id;
    }
    public long getUser_id(){
        return user_id;
    }
    public void setUser_id(long user_id){
       this.user_id = user_id;
    }
    public int getBook_type(){
        return book_type;
    }
    public void setBook_type(int book_type){
       this.book_type = book_type;
    }
    @Override
    public String toString(){
        return "UserHobby{"+
        "hobby_id="+hobby_id+
        ",user_id="+user_id+
        ",book_type="+book_type+"}";
    }
}
