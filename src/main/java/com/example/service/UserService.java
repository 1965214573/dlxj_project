package com.example.service;

import com.example.common.JsonResult;
import com.example.common.Result;
import com.example.pojo.Users;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/2 19:31
 */
public interface UserService {
    boolean checkEmail(String email);

    /**
     * 登陆
     * @param username
     * @param password
     * @param vercode
     * @return
     */
    Result login(String username, String password, String vercode);

    /**
     * 重置密码
     * @param username 用户名
     * @param oldPassword
     * @param newPassword
     * @return
     */
    Result resetPassword(String username, String oldPassword, String newPassword);

    /**
     * 查询所有的用户信息
     * @return
     */
    JsonResult findUsers(String userName, Integer userStatus, Integer page, Integer limit);

    /**
     * 查找所有的角色信息
     * @return
     * @param roleName
     * @param roleStatus
     * @param page
     * @param limit
     */
    JsonResult findRoles(String roleName, Integer roleStatus, Integer page, Integer limit);

    Result addRole(String roleName, int userId);

    Result getRoleList();

    Result addUser(Users user);

    Result batchUserDel(Integer[] ids);

    Result delRole(Integer id);

    Result updateRole(String roleName, Integer roleId);

    Result changeRoleStatus(Integer id, Integer roleStatus);

    Result batchRoleDel(Integer[] ids);

    Result changeUserStatus(Integer id, Integer userStatus);

    Result updateUser(Users user);

    Result delUser(Integer id);
}
