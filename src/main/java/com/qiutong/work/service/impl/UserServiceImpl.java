package com.qiutong.work.service.impl;

import com.qiutong.work.dao.bank.UserDao;
import com.qiutong.work.model.User;
import com.qiutong.work.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(int userId) {
        return userDao.getUsers();
    }
}








