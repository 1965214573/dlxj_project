package com.example.pojo;


public class Towers {

  private long id;
  private String number;
  private long routeId;
  private long towerStatus;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }


  public long getRouteId() {
    return routeId;
  }

  public void setRouteId(long routeId) {
    this.routeId = routeId;
  }


  public long getTowerStatus() {
    return towerStatus;
  }

  public void setTowerStatus(long towerStatus) {
    this.towerStatus = towerStatus;
  }

}
