package com.example.controller;

import com.example.VO.RouteInfo;
import com.example.common.JsonResult;
import com.example.common.Result;
import com.example.pojo.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.service.RouteService;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/6 15:58
 */
@RestController
public class RouteController {

    RouteService routeService;
    public void setTowerService(RouteService towerService) {
        this.routeService = towerService;
    }

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/getTower")
    public JsonResult findTower(Integer routeId, Integer towerStatus, Integer page, Integer limit){
        return routeService.findTower(routeId, towerStatus, page, limit);
    }

    @PostMapping("/addTower")
    public Result addTower(String number, Integer routeId, Integer towerStatus){
        return routeService.addTower(number, routeId, towerStatus);
    }


    @PostMapping("/changeTowerStatus")
    public Result changeTowerStatus(Integer id, Integer towerStatus){
        return routeService.changeTowerStatus(id, towerStatus);
    }

    @PostMapping("/delTower")
    public Result delTower(Integer id){
        return routeService.delTower(id);
    }

    @PostMapping("/batchTowerdel")
    public Result batchTowerDel(Integer[] ids){
        return routeService.batchTowerDel(ids);
    }




    @PostMapping("/addRoute")
    public Result addRoute(Routes route){
        return routeService.addRoute(route);
    }

    @PostMapping("/updateRoute")
    public Result updateRoute(RouteInfo route){
        return routeService.updateRoute(route);
    }

    @GetMapping("/getRoute")
    public JsonResult getRoute(String routeName, Integer routeRunStatus, Integer page, Integer limit){
        return routeService.findAllRoute(routeName, routeRunStatus, page, limit);
    }

    @GetMapping("/getAllRoute")
    public JsonResult getAllRoute(){
        return routeService.findRoute();
    }


    @PostMapping("/delRoute")
    public Result delRoute(Integer id){
        return routeService.delRoute(id);
    }

    @PostMapping("/batchRoutedel")
    public Result batchRoutedel(Integer[] ids){
        return routeService.batchRoutedel(ids);
    }


    @PostMapping("/changeRouteStatus")
    public Result changeRouteStatus(Integer id, Integer routeStatus){
        return routeService.changeRouteStatus(id, routeStatus);
    }
}
