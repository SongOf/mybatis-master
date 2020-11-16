package com.mybatis.dao;

import com.mybatis.domain.User;

import java.util.List;

/*用户的持久层接口
* */
public interface IUserDao {
    /*查询所有操作
    * */
    List<User> findAll();
    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);
    /***
     * @Description 跟新用户
     * @Param [user]
     * @return void
     */
    void updateUser(User user);
    /***
     * @Description 删除单个用户
     * @Param [userId]
     * @return void
     */
    void deleteUser(Integer userId);
    /***
     * @Description 查询单个用户
     * @Param [userId]
     * @return com.mybatis.domain.User
     */
    User findUserById(Integer userId);
    /***
     * @Description 根据用户名模糊查询用户
     * @Param [username]
     * @return java.util.List<com.mybatis.domain.User>
     */
    List<User> findUserByName(String username);
}
