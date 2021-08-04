package com.example.service.impl;

import com.example.VO.RouteInfo;
import com.example.VO.TowerInfo;
import com.example.common.JsonResult;
import com.example.common.Result;
import com.example.mapper.RouteMapper;
import com.example.pojo.Routes;
import com.example.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/6 16:02
 */
@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    RouteMapper routeMapper;

    @Override
    public JsonResult findTower(Integer routeId, Integer towerStatus, Integer page, Integer limit) {
        List<TowerInfo> towersList = routeMapper.findTower(routeId, towerStatus, (page-1)*limit, limit);
        for (TowerInfo tower : towersList) {
            Routes route = routeMapper.findRouteById(tower.getRouteId());
            tower.setRouteName(route.getRouteName());
        }
        JsonResult result = new JsonResult();
        result.setCode(0);
        result.setMsg("查询成功");
        result.setCount(routeMapper.countTower(routeId, towerStatus, (page-1)*limit, limit));
        result.setData(towersList);
        return result;
    }

    @Override
    public Result addTower(String number, Integer routeId, Integer towerStatus) {
        int row = routeMapper.addTower(number, routeId, towerStatus);
        Result result = new Result();
        if (row!=0){
            result.setCode(200);
            result.setMsg("添加杆塔成功");
        } else {
            result.setCode(500);
            result.setMsg("服务器出现问题");
        }
        return result;
    }

    @Override
    public Result addRoute(Routes route) {
        int row = routeMapper.addRoute(route);
        Result result = new Result();
        if (row!=0){
            result.setCode(200);
            result.setMsg("线路添加成功");
        } else{
            result.setCode(500);
            result.setMsg("系统出现故障，请联系管理员");
        }
        return result;
    }

    @Override
    public JsonResult findAllRoute(String routeNumber, Integer routeRunStatus, Integer page, Integer limit) {
        List<Routes> routesList = routeMapper.findAllRoute(routeNumber, routeRunStatus, (page-1)*limit, limit);


        JsonResult result = new JsonResult();
        result.setCode(0);
        if (routesList == null){
            result.setMsg("暂无数据");
        } else {
            result.setMsg("查询线路成功");
            result.setCount(routeMapper.countRoute(routeNumber, routeRunStatus, (page-1)*limit, limit));
            result.setData(routesList);
        }
        return result;
    }

    @Override
    public Result updateRoute(RouteInfo route) {
        System.out.println(route.getRouteId());
        int row = routeMapper.updateRoute(route);
        Result result = new Result();
        if (row != 0){
            result.setCode(200);
            result.setMsg("修改线路成功");
        } else {
            result.setCode(500);
            result.setMsg("服务器出现故障，请联系系统管理员");
        }
        return result;
    }

    @Override
    public Result changeTowerStatus(Integer id, Integer towerStatus) {
        if (towerStatus == 1){
            towerStatus = 0;
        } else {
            towerStatus = 1;
        }
        int row = routeMapper.changeTowerStatus(id, towerStatus);
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
    public Result delTower(Integer id) {
        int row = routeMapper.delTowerById(id);
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
    public Result batchTowerDel(Integer[] ids) {
        int row = 0;
        for (Integer id : ids) {
            row += routeMapper.delTowerById(id);
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
    public Result delRoute(Integer id) {
        int row = routeMapper.delRouteById(id);
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
    public Result batchRoutedel(Integer[] ids) {
        int row = 0;
        for (Integer id : ids) {
            row += routeMapper.delRouteById(id);
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
    public Result changeRouteStatus(Integer id, Integer routeStatus) {
        if (routeStatus == 1){
            routeStatus = 0;
        } else {
            routeStatus = 1;
        }
        int row = routeMapper.changeRouteStatus(id, routeStatus);
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
    public JsonResult findRoute() {
        List<Routes> routesList = routeMapper.findRoute();
        JsonResult result = new JsonResult();
        if (routesList!=null){
            result.setCode(200);
            result.setMsg("查询成功");
            result.setData(routesList);
        } else {
            result.setCode(500);
            result.setMsg("查询失败");
        }
        return result;
    }


}
