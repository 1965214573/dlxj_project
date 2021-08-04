package com.example.controller;

import com.example.common.JsonResult;
import com.example.common.Result;
import com.example.pojo.Users;
import com.example.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/3 11:13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Result login(String username, String password, String vercode){
        return userService.login(username,password,vercode);
    }

    @PostMapping("/resetPassword")
    public Result resetPassword(String username, String oldPassword, String newPassword){
        System.out.println(username);
        System.out.println(newPassword);
        return userService.resetPassword(username,oldPassword,newPassword);
    }

    @GetMapping("/findUsers")
    public JsonResult findUsers(String userName, Integer userStatus, Integer page, Integer limit){
        return userService.findUsers(userName,userStatus,page, limit);
    }

    @PostMapping("/addUser")
    public Result addUser(Users user){
        return userService.addUser(user);
    }

    @PostMapping("/delUser")
    public Result delUser(Integer id){
        return userService.delUser(id);
    }

    @PostMapping("/batchUserdel")
    public Result batchUserDel(Integer[] ids){
        return userService.batchUserDel(ids);
    }


    @GetMapping("/findAllRoles")
    public JsonResult findRoles(String roleName, Integer roleStatus ,Integer page, Integer limit){

        return userService.findRoles(roleName, roleStatus, page, limit);
    }

    @GetMapping("/getRoleList")
    public  Result getRoleList(){

        return userService.getRoleList();
    }

    @PostMapping("/addRole")
    public Result addRole(String roleName, int userId){
        return userService.addRole(roleName, userId);
    }

    @PostMapping("/batchRoledel")
    public Result batchRoleDel(Integer[] ids){
        return userService.batchRoleDel(ids);
    }

    @PostMapping("/delRole")
    public Result delRole(Integer id){
        return userService.delRole(id);
    }

    @PostMapping("/updateRole")
    public Result updateRole(String roleName, Integer roleId){
        return userService.updateRole(roleName, roleId);
    }
    @PostMapping("/updateUser")
    public Result updateUser(Users user){
        return userService.updateUser(user);
    }

    @PostMapping("/changeRoleStatus")
    public Result changeRoleStatus(Integer id, Integer roleStatus){
        return userService.changeRoleStatus(id, roleStatus);
    }
    @PostMapping("/changeUserStatus")
    public Result changeUserStatus(Integer id, Integer userStatus){
        return userService.changeUserStatus(id, userStatus);
    }
}

