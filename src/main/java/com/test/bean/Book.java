package com.test.bean;

import java.util.Date;

public class Book {
    private Long bookId;

    private String bookName;

    private Long authorId;

    private String cover;

    private String introduce;

    private Integer bookType;

    private Date createTime;

    private Long allVarcharacter;

    private Integer bookStatus;

    private Integer writeStatus;

    private Long clickNum;

    private Long readNum;

    private Long incomeNum;

    private Long income;

    private Float score;

    public Book(Long bookId, String bookName, Long authorId, String cover, String introduce, Integer bookType, Date createTime, Long allVarcharacter, Integer bookStatus, Integer writeStatus, Long clickNum, Long readNum, Long incomeNum, Long income, Float score) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorId = authorId;
        this.cover = cover;
        this.introduce = introduce;
        this.bookType = bookType;
        this.createTime = createTime;
        this.allVarcharacter = allVarcharacter;
        this.bookStatus = bookStatus;
        this.writeStatus = writeStatus;
        this.clickNum = clickNum;
        this.readNum = readNum;
        this.incomeNum = incomeNum;
        this.income = income;
        this.score = score;
    }

    public Book() {
        super();
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getAllVarcharacter() {
        return allVarcharacter;
    }

    public void setAllVarcharacter(Long allVarcharacter) {
        this.allVarcharacter = allVarcharacter;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Integer getWriteStatus() {
        return writeStatus;
    }

    public void setWriteStatus(Integer writeStatus) {
        this.writeStatus = writeStatus;
    }

    public Long getClickNum() {
        return clickNum;
    }

    public void setClickNum(Long clickNum) {
        this.clickNum = clickNum;
    }

    public Long getReadNum() {
        return readNum;
    }

    public void setReadNum(Long readNum) {
        this.readNum = readNum;
    }

    public Long getIncomeNum() {
        return incomeNum;
    }

    public void setIncomeNum(Long incomeNum) {
        this.incomeNum = incomeNum;
    }

    public Long getIncome() {
        return income;
    }

    public void setIncome(Long income) {
        this.income = income;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

}