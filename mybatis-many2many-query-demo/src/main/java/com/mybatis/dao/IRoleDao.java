package com.mybatis.dao;

import com.mybatis.domain.Role;

import java.util.List;

/**
 * @author SongOf
 * @InterfaceName IRoleDao
 * @Description
 * @Date 2020/11/21 22:01
 * @Version 1.0
 */
public interface IRoleDao {
    /***
    * @Description 查询所有角色信息
    * @Param []
    * @return java.util.List<com.mybatis.domain.Role>
    */
    List<Role> findAll();
}
