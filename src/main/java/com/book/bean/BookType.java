package com.book.bean;

import java.util.List;

public class BookType {
    private int book_type;
    private String type_name;
    private int sex;
    private int father_type;
    private List<Book> books;

    public BookType(){}
    public BookType(int book_type, String type_name, int sex, int father_type){
        this.book_type = book_type;
        this.type_name = type_name;
        this.sex = sex;
        this.father_type = father_type;
    }

    public int getBook_type(){
        return book_type;
    }
    public void setBook_type(int book_type){
       this.book_type = book_type;
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
    public int getFather_type(){
        return father_type;
    }
    public void setFather_type(int father_type){
       this.father_type = father_type;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString(){
        return "BookType{"+
        "book_type="+book_type+
        ",type_name="+type_name+
        ",sex="+sex+
        ",father_type="+father_type+"}";
    }
}
