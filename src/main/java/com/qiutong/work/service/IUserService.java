package com.qiutong.work.service;


import com.qiutong.work.model.User;


public interface IUserService {

    User getUser(int userId);

    User getUserById(int userId);

    int insertUser(User user);
}
