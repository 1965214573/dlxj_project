package com.example.mapper;

import com.example.VO.RoleInfo;
import com.example.VO.UserInfo;
import com.example.pojo.Role;
import com.example.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/2 21:20
 */
@Mapper
public interface UserMapper {
    List<UserInfo> findAllUser(@Param("userName") String userName,@Param("userStatus") Integer userStatus, @Param("page") Integer page, @Param("limit") Integer limit);

    Users findUser(@Param("username") String username, @Param("password") String password);

    Users findUserById(@Param("id") int userId);

    int updatePassword(@Param("username") String username, @Param("newPassword") String newPassword);

    List<RoleInfo> findAllRole(@Param("roleName") String roleName, @Param("roleStatus") Integer roleStatus, @Param("page") Integer page, @Param("limit") Integer limit);

    Integer countRoles(@Param("roleName") String roleName, @Param("roleStatus") Integer roleStatus, @Param("page") Integer page, @Param("limit") Integer limit);
    Integer countUsers(@Param("userName") String userName,@Param("userStatus") Integer userStatus,@Param("page") Integer page, @Param("limit") Integer limit);

    int addRole(@Param("roleName") String roleName, @Param("userId") int userId);

    Role findRoleById(@Param("roleId") long roleId);

    List<Role> getRoleList();

    int addUser(Users user);

    int delRoleById(@Param("id") Integer id);

    int updateRole(@Param("roleName") String roleName,@Param("roleId") Integer roleId);

    int changeRoleStatus(@Param("id") Integer id, @Param("roleStatus") Integer roleStatus);

    int delUserById(@Param("id") Integer id);

    int changeUserStatus(@Param("id") Integer id, @Param("userStatus") Integer userStatus);

    int updateUser(Users user);
}
