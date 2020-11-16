package com.mybatis.sqlsession;

/**
 * @author SongOf
 * @InterfaceName SqlSession
 * @Description 自定义Mybatis中和数据库交互的核心类 它里面可以创建dao接口的代理对象
 * @Date 2020/11/12 17:35
 * @Version 1.0
 */
public interface SqlSession {
    /***
    * @Description 根据参数创建代理对象
    * @Param [daoInterfaceClass] dao的接口字节码
    * @return T
    */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**释放资源
     */
    void close();
}
