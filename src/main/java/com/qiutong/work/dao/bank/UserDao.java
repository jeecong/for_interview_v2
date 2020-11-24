package com.qiutong.work.dao.bank;

import com.qiutong.work.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface UserDao {

    /**
     * 获取用户信息
     * @return
     */
   User getUsers();

   User getUserByName(@Param("username") String username, @Param("password") String password);

   int insertUser(User user);

}
