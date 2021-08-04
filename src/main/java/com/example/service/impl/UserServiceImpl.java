package com.example.service.impl;

import com.example.VO.RoleInfo;
import com.example.VO.UserInfo;
import com.example.common.Constants;
import com.example.common.JsonResult;
import com.example.common.Result;
import com.example.mapper.UserMapper;
import com.example.pojo.Role;
import com.example.pojo.Users;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author youngoo
 * @version 1.0
 * @date 2021/7/2 19:32
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public boolean checkEmail(String email) {

        /*List<Users> allUser = userMapper.findAllUser();
        System.out.println(allUser);*/
        return true;
    }

    @Override
    public Result<Users> login(String username, String password, String vercode) {
        Result<Users> result = new Result<>();
        String str = "test";
        if(!str.equals(vercode)){
            result.setCode(501);
            result.setMsg("验证码有误！");
            return result;
        }
        Users user = userMapper.findUser(username,password);
        if (user==null){
            result.setCode(500);
            result.setMsg("账号或密码有误");
        } else {
            result.setCode(200);
            result.setMsg("登陆成功");
            result.setData(user);
        }
        return result;
    }

    @Override
    public Result<Users> resetPassword(String username, String oldPassword, String newPassword) {
        Result<Users> result = new Result<>();
        if (oldPassword.equals(newPassword)) {
            result.setCode(501);
            result.setMsg("新旧密码不允许一致");
            return result;
        }
        Users user = userMapper.findUser(username, oldPassword);
        if (user !=null) {
            int rows = userMapper.updatePassword(username, newPassword);
            if (rows != 0) {
                result.setCode(200);
                result.setMsg("修改成功");
                return result;
            }
            result.setCode(500);
            result.setMsg("服务器出错，请稍后重试");
        }else {
            result.setCode(502);
            result.setMsg("密码输入错误");
        }
        return result;

    }

    @Override
    public JsonResult<List<UserInfo>> findUsers(String userName, Integer userStatus, Integer page, Integer limit) {

        List<UserInfo> allUser = userMapper.findAllUser(userName, userStatus, (page-1)*limit, limit);
        JsonResult<List<UserInfo>> jsonResult = new JsonResult<>();
        for (UserInfo user : allUser) {
            Role role = userMapper.findRoleById(user.getRoleId());
            user.setRoleName(role.getRoleName());
        }
        jsonResult.setCode(0);
        jsonResult.setMsg("查询成功");
        jsonResult.setCount(userMapper.countUsers(userName, userStatus,(page-1)*limit, limit));
        jsonResult.setData(allUser);
        return jsonResult;
    }

    @Override
    public JsonResult findRoles(String roleName, Integer roleStatus, Integer page, Integer limit) {
        System.out.println(roleName);
        System.out.println(roleStatus);
        List<RoleInfo> roleList = userMapper.findAllRole(roleName,roleStatus, (page-1)*limit, limit);
        for (RoleInfo role : roleList) {
            Users user = userMapper.findUserById(role.getUserId());
            role.setCreatUser(user.getLoginAccount());
        }
        JsonResult result = new JsonResult();
        result.setCode(0);
        result.setMsg("角色信息查询成功");
        result.setCount(userMapper.countRoles(roleName,roleStatus, (page-1)*limit, limit));
        result.setData(roleList);
        return result;
    }

    @Override
    public Result addRole(String roleName, int userId) {
        int row = userMapper.addRole(roleName,userId);
        Result result = new Result();
        if (row!=0) {
            result.setCode(200);
            result.setMsg("添加角色成功");
        } else {
            result.setCode(500);
            result.setMsg("服务器开小差！");
        }
        return result;
    }

    @Override
    public Result getRoleList() {
        List<Role> roleList = userMapper.getRoleList();
        Result result = new Result();
        if (roleList!=null){
            result.setCode(200);
            result.setMsg("查询成功");
            result.setData(roleList);
        } else {
            result.setCode(500);
            result.setMsg("数据库查询失败");
        }
        return result;

    }

    @Override
    public Result addUser(Users user) {
        user.setUserPwd(Constants.DEFAULT_PASSWORD);
        int row = userMapper.addUser(user);
        Result result = new Result();
        if (row!=0){
            result.setCode(200);
            result.setMsg("添加用户成功");
        } else {
            result.setCode(500);
            result.setMsg("服务器异常！请联系系统管理员");
        }
        return result;
    }

    @Override
    public Result batchUserDel(Integer[] ids) {
        int row = 0;
        for (Integer id : ids) {
            row += userMapper.delUserById(id);
        }
        Result result = new Result();
        if (row == ids.length){
            result.setCode(200);
            result.setMsg("删除成功");
        } else {
            result.setCode(500);
            result.setMsg("删除失败");
        }
        return result;
    }

    @Override
    public Result batchRoleDel(Integer[] ids) {
        int row = 0;
        for (Integer id : ids) {
            row += userMapper.delRoleById(id);
        }
        Result result = new Result();
        if (row == ids.length){
            result.setCode(200);
            result.setMsg("删除成功");
        } else {
            result.setCode(500);
            result.setMsg("删除失败");
        }
        return result;
    }

    @Override
    public Result changeUserStatus(Integer id, Integer userStatus) {
        if (userStatus == 1){
            userStatus = 0;
        } else {
            userStatus = 1;
        }
        int row = userMapper.changeUserStatus(id, userStatus);
        Result result = new Result();
        if (row != 0){
            result.setCode(200);
            result.setMsg("修改成功");
        } else {
            result.setCode(500);
            result.setMsg("修改失败");
        }
        return result;
    }

    @Override
    public Result updateUser(Users user) {

        int row = userMapper.updateUser(user);
        Result result = new Result();
        if (row != 0){
            result.setCode(200);
            result.setMsg("修改成功");
        } else {
            result.setCode(500);
            result.setMsg("修改失败");
        }
        return result;
    }

    @Override
    public Result delUser(Integer id) {
        int row = userMapper.delUserById(id);
        Result result = new Result();
        if (row != 0){
            result.setCode(200);
            result.setMsg("删除成功");
        } else {
            result.setCode(500);
            result.setMsg("删除失败");
        }
        return result;
    }

    @Override
    public Result delRole(Integer id) {
        int row = userMapper.delRoleById(id);
        Result result = new Result();
        if (row != 0){
            result.setCode(200);
            result.setMsg("删除成功");
        } else {
            result.setCode(500);
            result.setMsg("删除失败");
        }
        return result;
    }

    @Override
    public Result updateRole(String roleName, Integer roleId) {

        int row = userMapper.updateRole(roleName, roleId);
        Result result = new Result();
        if (row != 0){
            result.setCode(200);
            result.setMsg("修改成功");
        } else {
            result.setCode(500);
            result.setMsg("修改失败");
        }
        return result;
    }

    @Override
    public Result changeRoleStatus(Integer id, Integer roleStatus) {
        if (roleStatus == 1){
            roleStatus = 0;
        } else {
            roleStatus = 1;
        }
        int row = userMapper.changeRoleStatus(id, roleStatus);
        Result result = new Result();
        if (row != 0){
            result.setCode(200);
            result.setMsg("修改成功");
        } else {
            result.setCode(500);
            result.setMsg("修改失败");
        }
        return result;
    }
}
