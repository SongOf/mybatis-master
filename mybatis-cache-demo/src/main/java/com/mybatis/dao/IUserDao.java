package com.mybatis.dao;

import com.mybatis.domain.User;

import java.util.List;

/*用户的持久层接口
* */
public interface IUserDao {
    /***
    * @Description 查询所有用户
    * @Param []
    * @return java.util.List<com.mybatis.domain.User>
    */
    List<User> findAll();

    /***
    * @Description 查询单个用户
    * @Param [userId]
    * @return com.mybatis.domain.User
    */
    User findUserById(Integer userId);
    /***
    * @Description 更新用户信息
    * @Param [user]
    * @return void
    */
    void updateUser(User user);
}
