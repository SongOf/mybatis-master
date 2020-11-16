package com.mybatis.sqlsession.defaults;

import com.mybatis.config.Configuration;
import com.mybatis.sqlsession.SqlSession;
import com.mybatis.sqlsession.SqlSessionFactory;
import com.mybatis.sqlsession.defaults.DefaultSqlSession;

/**
 * @author SongOf
 * @ClassName DefaultSqlSessionFactory
 * @Description SqlSessionFactory的实现类
 * @Date 2020/11/12 19:07
 * @Version 1.0
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg=cfg;
    }
    /***
    * @Description 用于创建一个新的数据库操作对象
    * @Param []
    * @return com.mybatis.sqlsession.SqlSession
    */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
