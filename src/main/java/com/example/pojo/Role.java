package com.example.pojo;

import java.sql.Timestamp;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/4 10:43
 */
public class Role {
    private Integer id;
    private String roleName;
    private Integer userId;
    private Timestamp updateDate;
    private Integer roleStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }
}
