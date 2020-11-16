package com.mybatis.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author SongOf
 * @AnnotationName Select
 * @Description 查询的注解
 * @Date 2020/11/12 20:46
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
    /***
    * @Description 配置sql语句
    * @Param []
    * @return java.lang.String
    */
    String value();
}
