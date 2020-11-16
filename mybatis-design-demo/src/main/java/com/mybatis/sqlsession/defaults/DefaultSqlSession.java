package com.mybatis.sqlsession.defaults;

import com.mybatis.config.Configuration;
import com.mybatis.sqlsession.SqlSession;
import com.mybatis.sqlsession.proxy.MapperProxy;
import com.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author SongOf
 * @ClassName DefaultSqlSession
 * @Description SqlSession接口的实现类
 * @Date 2020/11/12 19:13
 * @Version 1.0
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;
    public DefaultSqlSession(Configuration cfg){
        this.cfg=cfg;
        connection= DataSourceUtil.getConnection(cfg);
    }
    /***
    * @Description 用于创建代理对象
    * @Param [daoInterfaceClass] dao接口的字节码
    * @return T
    */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(cfg.getMappers(),connection)); //如何代理
    }
    /***
    * @Description 用于释放资源
    * @Param []
    * @return void
    */
    public void close() {
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
