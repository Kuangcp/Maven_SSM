package com.book.bean;

public class Book {
    private long book_id;
    private String book_name;
    private long author_id;
    private String cover;
    private String introduce;
    private int book_type;
    private java.util.Date create_time;
    private long all_varcharacter;
    private int book_status;
    private int write_status;
    private long click_num;
    private long read_num;
    private long income_num;
    private long income;
    private float score;

    public Book(){}
    public Book(long book_id, long author_id, String cover, String introduce, int book_type, 
            java.util.Date create_time, long all_varcharacter, int book_status, int write_status, long click_num, long read_num, long income_num, long income, float score){
        this.book_id = book_id;
        this.author_id = author_id;
        this.cover = cover;
        this.introduce = introduce;
        this.book_type = book_type;
        this.create_time = create_time;
        this.all_varcharacter = all_varcharacter;
        this.book_status = book_status;
        this.write_status = write_status;
        this.click_num = click_num;
        this.read_num = read_num;
        this.income_num = income_num;
        this.income = income;
        this.score = score;
    }

    public long getBook_id(){
        return book_id;
    }
    public void setBook_id(long book_id){
       this.book_id = book_id;
    }
    public String getBook_name() {
        return book_name;
    }
    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }
    public long getAuthor_id(){
        return author_id;
    }
    public void setAuthor_id(long author_id){
       this.author_id = author_id;
    }
    public String getCover(){
        return cover;
    }
    public void setCover(String cover){
       this.cover = cover;
    }
    public String getIntroduce(){
        return introduce;
    }
    public void setIntroduce(String introduce){
       this.introduce = introduce;
    }
    public int getBook_type(){
        return book_type;
    }
    public void setBook_type(int book_type){
       this.book_type = book_type;
    }
    public java.util.Date getCreate_time(){
        return create_time;
    }
    public void setCreate_time(java.util.Date create_time){
       this.create_time = create_time;
    }
    public long getAll_varcharacter(){
        return all_varcharacter;
    }
    public void setAll_varcharacter(long all_varcharacter){
       this.all_varcharacter = all_varcharacter;
    }
    public int getBook_status(){
        return book_status;
    }
    public void setBook_status(int book_status){
       this.book_status = book_status;
    }
    public int getWrite_status(){
        return write_status;
    }
    public void setWrite_status(int write_status){
       this.write_status = write_status;
    }
    public long getClick_num(){
        return click_num;
    }
    public void setClick_num(long click_num){
       this.click_num = click_num;
    }
    public long getRead_num(){
        return read_num;
    }
    public void setRead_num(long read_num){
       this.read_num = read_num;
    }
    public long getIncome_num(){
        return income_num;
    }
    public void setIncome_num(long income_num){
       this.income_num = income_num;
    }
    public long getIncome(){
        return income;
    }
    public void setIncome(long income){
       this.income = income;
    }
    public float getScore(){
        return score;
    }
    public void setScore(float score){
       this.score = score;
    }
    @Override
    public String toString(){
        return "Book{"+
        "book_id="+book_id+
        ",author_id="+author_id+
        ",cover="+cover+
        ",introduce="+introduce+
        ",book_type="+book_type+
        ",create_time="+create_time.toLocaleString()+
        ",all_varcharacter="+all_varcharacter+
        ",book_status="+book_status+
        ",write_status="+write_status+
        ",click_num="+click_num+
        ",read_num="+read_num+
        ",income_num="+income_num+
        ",income="+income+
        ",score="+score+"}";
    }
}
