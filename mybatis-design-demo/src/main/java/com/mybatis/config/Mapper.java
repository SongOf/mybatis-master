package com.mybatis.config;

/**
 * @author SongOf
 * @ClassName Mapper
 * @Description 用于封装执行的sql语句和结果类型的全限定名
 * @Date 2020/11/12 18:41
 * @Version 1.0
 */
public class Mapper {
    private String queryString;
    private String resultType;

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
