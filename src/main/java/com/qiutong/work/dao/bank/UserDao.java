package com.qiutong.work.dao.bank;

import com.qiutong.work.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserDao {

    /**
     * 获取用户信息
     * @return
     */
   User getUsers();

   User getUserById(int userId );

   int insertUser(User user);

}
