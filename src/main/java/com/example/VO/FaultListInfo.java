package com.example.VO;

import com.example.pojo.Faultlist;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/7 22:57
 */
public class FaultListInfo extends Faultlist {
    private String routeNumber;
    private String towerNumber;
    private String faultName;
    private String finder;


    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getTowerNumber() {
        return towerNumber;
    }

    public void setTowerNumber(String towerNumber) {
        this.towerNumber = towerNumber;
    }

    public String getFinder() {
        return finder;
    }

    public void setFinder(String finder) {
        this.finder = finder;
    }
}
