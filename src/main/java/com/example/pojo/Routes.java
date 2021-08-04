package com.example.pojo;


public class Routes {

  private long id;
  private String routeNumber;
  private String routeName;
  private long routeLength;
  private long circleLength;
  private java.sql.Date operatedDate;
  private long voltageClass;
  private String startTowerNumber;
  private String endTowerNumber;
  private long towerCount;
  private long routeRunStatus;
  private long routeStatus;
  private String routeComment;
  public long getTowerCount() {
    return towerCount;
  }

  public void setTowerCount(long towerCount) {
    this.towerCount = towerCount;
  }




  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getRouteNumber() {
    return routeNumber;
  }

  public void setRouteNumber(String routeNumber) {
    this.routeNumber = routeNumber;
  }


  public String getRouteName() {
    return routeName;
  }

  public void setRouteName(String routeName) {
    this.routeName = routeName;
  }


  public long getRouteLength() {
    return routeLength;
  }

  public void setRouteLength(long routeLength) {
    this.routeLength = routeLength;
  }


  public long getCircleLength() {
    return circleLength;
  }

  public void setCircleLength(long circleLength) {
    this.circleLength = circleLength;
  }


  public java.sql.Date getOperatedDate() {
    return operatedDate;
  }

  public void setOperatedDate(java.sql.Date operatedDate) {
    this.operatedDate = operatedDate;
  }


  public long getVoltageClass() {
    return voltageClass;
  }

  public void setVoltageClass(long voltageClass) {
    this.voltageClass = voltageClass;
  }


  public String getStartTowerNumber() {
    return startTowerNumber;
  }

  public void setStartTowerNumber(String startTowerNumber) {
    this.startTowerNumber = startTowerNumber;
  }


  public String getEndTowerNumber() {
    return endTowerNumber;
  }

  public void setEndTowerNumber(String endTowerNumber) {
    this.endTowerNumber = endTowerNumber;
  }


  public long getRouteRunStatus() {
    return routeRunStatus;
  }

  public void setRouteRunStatus(long routeRunStatus) {
    this.routeRunStatus = routeRunStatus;
  }


  public long getRouteStatus() {
    return routeStatus;
  }

  public void setRouteStatus(long routeStatus) {
    this.routeStatus = routeStatus;
  }


  public String getRouteComment() {
    return routeComment;
  }

  public void setRouteComment(String routeComment) {
    this.routeComment = routeComment;
  }

  @Override
  public String toString() {
    return "Routes{" +
            "id=" + id +
            ", routeNumber='" + routeNumber + '\'' +
            ", routeName='" + routeName + '\'' +
            ", routeLength=" + routeLength +
            ", circleLength=" + circleLength +
            ", operatedDate=" + operatedDate +
            ", voltageClass=" + voltageClass +
            ", startTowerNumber='" + startTowerNumber + '\'' +
            ", endTowerNumber='" + endTowerNumber + '\'' +
            ", routeRunStatus=" + routeRunStatus +
            ", routeStatus=" + routeStatus +
            ", routeComment='" + routeComment + '\'' +
            '}';
  }
}
