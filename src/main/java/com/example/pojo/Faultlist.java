package com.example.pojo;


public class Faultlist {

  private Integer id;
  private String taskNumber;
  private long routeId;
  private long towerId;
  private String towernum;
  private String faultId;
  private double intactrate;
  private String faultstatus;
  private java.sql.Timestamp findtime;
  private Integer userId;
  private long level;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getTaskNumber() {
    return taskNumber;
  }

  public void setTaskNumber(String taskNumber) {
    this.taskNumber = taskNumber;
  }


  public long getRouteId() {
    return routeId;
  }

  public void setRouteId(long routeId) {
    this.routeId = routeId;
  }


  public long getTowerId() {
    return towerId;
  }

  public void setTowerId(long towerId) {
    this.towerId = towerId;
  }


  public String getTowernum() {
    return towernum;
  }

  public void setTowernum(String towernum) {
    this.towernum = towernum;
  }


  public String getFaultId() {
    return faultId;
  }

  public void setFaultId(String faultId) {
    this.faultId = faultId;
  }


  public double getIntactrate() {
    return intactrate;
  }

  public void setIntactrate(double intactrate) {
    this.intactrate = intactrate;
  }


  public String getFaultstatus() {
    return faultstatus;
  }

  public void setFaultstatus(String faultstatus) {
    this.faultstatus = faultstatus;
  }


  public java.sql.Timestamp getFindtime() {
    return findtime;
  }

  public void setFindtime(java.sql.Timestamp findtime) {
    this.findtime = findtime;
  }


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }


  public long getLevel() {
    return level;
  }

  public void setLevel(long level) {
    this.level = level;
  }

}
