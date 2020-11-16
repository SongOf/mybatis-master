package com.mybatis.sqlsession.proxy;

import com.mybatis.config.Configuration;
import com.mybatis.config.Mapper;
import com.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @author SongOf
 * @ClassName MapperProxy
 * @Description
 * @Date 2020/11/12 19:32
 * @Version 1.0
 */
public class MapperProxy implements InvocationHandler {
    /*mappers的key是dao接口的全限定名+方法名
    * */
    private Map<String, Mapper> mappers;
    private Connection conn;
    public MapperProxy(Map<String, Mapper> mappers,Connection conn){
        this.mappers=mappers;
        this.conn=conn;
    }
    /***
    * @Description 用于对方法进行增强 我们的增强其实就是调用selectList()
    * @Param [proxy, method, args]
    * @return java.lang.Object
    */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名
        String methodName=method.getName();
        //2.获取方法所在类的名称
        String className=method.getDeclaringClass().getName();
        //3.生成key
        String key=className+'.'+methodName;
        //4.获取mappers中的Mapper对象，dao接口方法对应的mapper对象（sql+resultType）
        Mapper mapper=mappers.get(key);
        //5.判断是否有mapper
        if(mapper==null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        return new Executor().selectList(mapper,conn);
    }
}
