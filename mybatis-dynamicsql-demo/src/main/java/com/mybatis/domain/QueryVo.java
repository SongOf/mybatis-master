package com.mybatis.domain;

import java.util.List;

/**
 * @author SongOf
 * @ClassName QueryVo
 * @Description
 * @Date 2020/11/13 10:50
 * @Version 1.0
 */
public class QueryVo {
    private User user;

    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
