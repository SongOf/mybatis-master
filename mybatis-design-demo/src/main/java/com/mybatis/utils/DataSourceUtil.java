package com.mybatis.utils;

import com.mybatis.config.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author SongOf
 * @ClassName DataSourceUtil
 * @Description 用于创建数据源的工具类
 * @Date 2020/11/12 19:59
 * @Version 1.0
 */
public class DataSourceUtil {
    /***
    * @Description 用于获取一个连接
    * @Param [cfg]
    * @return java.sql.Connection
    */
    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
