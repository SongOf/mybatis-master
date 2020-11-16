package com.mybatis.dao;

import com.mybatis.annotations.Select;
import com.mybatis.domain.User;

import java.util.List;

/*用户的持久层接口
* */
public interface IUserDao {
    /*查询所有操作
    * */
    @Select("select * from user") //基于注解的方式
    List<User> findAll();
}
