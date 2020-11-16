package com.mybatis.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SongOf
 * @ClassName Configuration
 * @Description 自定义mybatis的配置类
 * @Date 2020/11/12 18:35
 * @Version 1.0
 */
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;
    private Map<String,Mapper> mappers=new HashMap<String, Mapper>();

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        /*追加到mappers
        * */
        this.mappers.putAll(mappers);
    }
}
