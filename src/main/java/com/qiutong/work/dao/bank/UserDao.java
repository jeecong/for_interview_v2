package com.qiutong.work.dao.bank;

import com.qiutong.work.module.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserDao {

    /**
     * 获取用户信息
     * @return
     */
   User getUsers();
}
