package com.mybatis.sqlsession;

import com.mybatis.config.Configuration;
import com.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author SongOf
 * @ClassName SqlSessionFactoryBuilder
 * @Description 用于创建一个SqlSessionFactory对象
 * @Date 2020/11/12 17:29
 * @Version 1.0
 */
public class SqlSessionFactoryBuilder {
    /***
    * @Description 根据参数的输入字节流来构建一个SqlSessionFactory工厂
    * @Param [config]
    * @return com.mybatis.sqlsession.SqlSessionFactory
    */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg= XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
