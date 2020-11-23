package com.qiutong.work.model;

import lombok.Data;

import java.util.Date;


@Data
public class User {

    private Integer userId;

    private String username;

    private String idCard;

    private String  password;


    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String  getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
