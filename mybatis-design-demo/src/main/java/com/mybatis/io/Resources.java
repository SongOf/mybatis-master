package com.mybatis.io;

import java.io.InputStream;

/**
 * @author SongOf
 * @ClassName Resources
 * @Description 使用类加载器读取配置文件的类
 * @Date 2020/11/12 17:19
 * @Version 1.0
 */
public class Resources {
    /**
    * @Description 根据输入的参数，获取一个字节输入流
    * @Param [filePath]
    * @return java.io.InputStream
    */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
