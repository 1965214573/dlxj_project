package com.example.pojo;


import java.sql.Date;
import java.sql.Timestamp;

public class Users {

  private Integer id;
  private String loginAccount;
  private String userName;
  private String userPwd;
  private long roleId;
  private String email;
  private Date entryDate;
  private Date resignDate;
  private long userStatus;
  private Timestamp lastLoginDatetime;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLoginAccount() {
    return loginAccount;
  }

  public void setLoginAccount(String loginAccount) {
    this.loginAccount = loginAccount;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPwd() {
    return userPwd;
  }

  public void setUserPwd(String userPwd) {
    this.userPwd = userPwd;
  }

  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }

  public Date getResignDate() {
    return resignDate;
  }

  public void setResignDate(Date resignDate) {
    this.resignDate = resignDate;
  }

  public long getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(long userStatus) {
    this.userStatus = userStatus;
  }

  public Timestamp getLastLoginDatetime() {
    return lastLoginDatetime;
  }

  public void setLastLoginDatetime(Timestamp lastLoginDatetime) {
    this.lastLoginDatetime = lastLoginDatetime;
  }

  @Override
  public String toString() {
    return "Users{" +
            "id=" + id +
            ", loginAccount='" + loginAccount + '\'' +
            ", userName='" + userName + '\'' +
            ", userPwd='" + userPwd + '\'' +
            ", roleId=" + roleId +
            ", email='" + email + '\'' +
            ", entryDate=" + entryDate +
            ", resignDate=" + resignDate +
            ", userStatus=" + userStatus +
            ", lastLoginDatetime=" + lastLoginDatetime +
            '}';
  }
}
