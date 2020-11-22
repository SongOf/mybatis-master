package com.mybatis.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author SongOf
 * @ClassName Role
 * @Description
 * @Date 2020/11/21 21:59
 * @Version 1.0
 */
public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    //多对多的关系映射，一个角色可以赋予多个用户
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}
