package com.mybatis.dao;

import com.mybatis.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**用户的持久层接口
 * CRUD一共有四个注解
 * @Select @Insert @Update @Delete
* */
@CacheNamespace(blocking = true)
public interface IUserDao {
    /***
    * @Description 查询所有用户
    * @Param []
    * @return java.util.List<com.mybatis.domain.User>
    */
    @Select("select * from user")
    @Results(id = "userMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "address",property = "address"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "id",property="accounts",many = @Many(select = "com.mybatis.dao.IAccountDao.findAccountByUid",fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /***
    * @Description 根据id查询用户
    * @Param [userId]
    * @return com.mybatis.domain.User
    */
    @Select("select * from user where id=#{id}")
    User findById(Integer userId);
    /***
    * @Description 根据用户名称查询用户
    * @Param [username]
    * @return java.util.List<com.mybatis.domain.User>
    */
    @Select("select * from user where username like #{username}")
    List<User> findUserByName(String username);
}
