package com.mybatis.dao;

import com.mybatis.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author SongOf
 * @InterfaceName IAccountDao
 * @Description
 * @Date 2020/11/21 19:17
 * @Version 1.0
 */
public interface IAccountDao {
    /***
    * @Description 查询所有账户,同时还要获取每个账户的用户信息--立即加载
    * @Param []
    * @return java.util.List<com.mybatis.domain.Account>
    */
    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(column = "uid",property="user",one = @One(select = "com.mybatis.dao.IUserDao.findById",fetchType = FetchType.EAGER))
    })
    List<Account> findAll();
    /***
    * @Description 根据用户id查询账户列表
    * @Param [userId]
    * @return java.util.List<com.mybatis.domain.Account>
    */
    @Select("select * from account where uid=#{userId}")
    List<Account> findAccountByUid(Integer userId);
}
