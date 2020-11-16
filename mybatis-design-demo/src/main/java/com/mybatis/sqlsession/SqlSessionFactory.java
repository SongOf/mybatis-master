package com.mybatis.sqlsession;

/**
 * @author SongOf
 * @InterfaceName SqlSessionFactory
 * @Description
 * @Date 2020/11/12 17:33
 * @Version 1.0
 */
public interface SqlSessionFactory {
    /***
    * @Description 用于打开新的SqlSession对象
    * @Param []
    * @return com.mybatis.sqlsession.SqlSession
    */
    SqlSession openSession();
}
