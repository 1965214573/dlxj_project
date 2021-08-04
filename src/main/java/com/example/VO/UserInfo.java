package com.example.VO;

import com.example.pojo.Users;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/4 19:09
 */
public class UserInfo extends Users {
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
