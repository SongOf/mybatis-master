package com.mybatis.dao;

import com.mybatis.domain.QueryVo;
import com.mybatis.domain.User;

import javax.jws.soap.SOAPBinding;
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
    /***
    * @Description 根据QueryVo查询用户
    * @Param [vo]
    * @return int
    */
    List<User> findUserByVo(QueryVo vo);
    /***
    * @Description 根据传入参数条件查询用户
    * @Param [user] 查询的条件，有可能有用户名，有可能有性别，有可能有地址，也可能没有
    * @return java.util.List<com.mybatis.domain.User>
    */
    List<User> findUserByCondition(User user);
    /***
    * @Description 根据QueryVo的id集合查询用户
    * @Param [vo]
    * @return java.util.List<com.mybatis.domain.User>
    */
    List<User> findUserInIds(QueryVo vo);
}
