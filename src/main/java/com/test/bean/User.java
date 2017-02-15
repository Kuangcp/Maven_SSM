package com.test.bean;

import java.io.Serializable;

/**
 * Created by Myth on 2017/2/15 0015
 */
public class User implements Serializable{
    private static final long serialVersionUID = -6011241820070393952L;
    private String name;
    private String id;
    private String pass;
    public User(){}
    public User(String name,String id,String pass){
        this.name = name;
        this.id = id;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
