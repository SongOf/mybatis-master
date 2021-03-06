package com.mybatis.dao;

import com.mybatis.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**用户的持久层接口
 * CRUD一共有四个注解
 * @Select @Insert @Update @Delete
* */
public interface IUserDao {
    /***
    * @Description 查询所有用户
    * @Param []
    * @return java.util.List<com.mybatis.domain.User>
    */
    @Select("select * from user")
    @Results(id = "userMap", value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "address",property = "address"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday")
    })
    List<User> findAll();

    /***
    * @Description 根据id查询用户
    * @Param [userId]
    * @return com.mybatis.domain.User
    */
    @Select("select * from user where id=#{id}")
    @ResultMap(value = {"userMap"})
    User findById(Integer userId);
    /***
    * @Description 根据用户名称查询用户
    * @Param [username]
    * @return java.util.List<com.mybatis.domain.User>
    */
    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String username);

    /***
    * @Description 保存用户
    * @Param [user]
    * @return void
    */
    @Insert("insert into user(username,address,sex,birthday)values(#{username},#{address},#{sex},#{birthday})")
    void saveUser(User user);
    /***
    * @Description 更新用户信息
    * @Param [user]
    * @return void
    */
    @Update("update user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void updateUser(User user);
    /***
    * @Description 删除用户信息
    * @Param [user]
    * @return void
    */
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer userId);
}
