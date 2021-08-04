package com.example.pojo;


public class FaultType {

  private Integer id;
  private String faultName;
  private long faultStatus;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getFaultName() {
    return faultName;
  }

  public void setFaultName(String faultName) {
    this.faultName = faultName;
  }


  public long getFaultStatus() {
    return faultStatus;
  }

  public void setFaultStatus(long faultStatus) {
    this.faultStatus = faultStatus;
  }

}
