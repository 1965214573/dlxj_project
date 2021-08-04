package com.example.VO;

import com.example.pojo.Role;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/4 10:48
 */
public class RoleInfo extends Role {
    private String creatUser;

    public String getCreatUser() {
        return creatUser;
    }

    public void setCreatUser(String creatUser) {
        this.creatUser = creatUser;
    }
}
