package com.qiutong.work.service;


import com.qiutong.work.model.User;


public interface IUserService {

    User getUser(int userId);

    User getUserByName(String username, String password);

    int insertUser(User user);
}
