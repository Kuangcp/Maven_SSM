package com.book.dao;

/**
 * Created by Myth on 2017/1/22 0022
 */
public class Condition {
    String name;
    String value;

    public Condition(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
