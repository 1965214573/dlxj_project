package com.example.service;

import com.example.VO.RouteInfo;
import com.example.common.JsonResult;
import com.example.common.Result;
import com.example.pojo.Routes;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/6 16:02
 */
public interface RouteService {
    JsonResult findTower(Integer routeId, Integer towerStatus, Integer page, Integer limit);

    Result addTower(String number, Integer routeId, Integer towerStatus);

    Result addRoute(Routes route);

    JsonResult findAllRoute(String routeNumber, Integer routeRunStatus, Integer page, Integer limit);

    Result updateRoute(RouteInfo route);

    Result changeTowerStatus(Integer id, Integer towerStatus);

    Result delTower(Integer id);

    Result batchTowerDel(Integer[] ids);

    Result delRoute(Integer id);

    Result batchRoutedel(Integer[] ids);

    Result changeRouteStatus(Integer id, Integer routeStatus);

    JsonResult findRoute();
}
