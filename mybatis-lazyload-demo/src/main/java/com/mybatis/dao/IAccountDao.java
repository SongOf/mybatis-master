package com.mybatis.dao;

import com.mybatis.domain.Account;

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
    * @Description 查询所有账户,同时还要获取到当前账户的所属用户信息
    * @Param []
    * @return java.util.List<com.mybatis.domain.Account>
    */
    List<Account> findAll();
    /***
    * @Description 根据用户id查询账户
    * @Param [uid]
    * @return java.util.List<com.mybatis.domain.Account>
    */
    List<Account> findAccountByUid(Integer uid);
}
