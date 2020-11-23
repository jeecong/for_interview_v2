package com.qiutong.work.model;

import lombok.Data;

import java.util.Date;


@Data
public class User {

    private Integer userId;

    private String name;

    private String email;

    private Integer oauthId;

    private String gitPrivateToken;

    private Date ctime;

    private Date mtime;
}
