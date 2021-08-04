package com.example.service.impl;

import com.example.VO.FaultListInfo;
import com.example.common.JsonResult;
import com.example.common.Result;
import com.example.mapper.FaultMapper;
import com.example.mapper.RouteMapper;
import com.example.mapper.UserMapper;
import com.example.pojo.FaultType;
import com.example.pojo.Routes;
import com.example.pojo.Towers;
import com.example.pojo.Users;
import com.example.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/7 23:06
 */
@Service
public class FaultServiceImpl implements FaultService {

    @Autowired
    private FaultMapper faultMapper;
    @Autowired
    private RouteMapper routeMapper;
    @Autowired
    private UserMapper userMapper;


    @Override
    public JsonResult findAllFaultType(Integer page, Integer limit) {
        List<FaultType> faultTypeList =  faultMapper.findAllFaultType((page-1)*limit, limit);
        JsonResult result = new JsonResult();
        if (faultTypeList!=null){
            result.setCode(0);
            result.setMsg("查询成功");
            result.setCount(faultMapper.countFaultType((page-1)*limit, limit));
            result.setData(faultTypeList);
        } else {
            result.setCode(500);
            result.setMsg("查询异常");
        }
        return result;
    }

    @Override
    public Result addFaultType(FaultType faultType) {
        int row = faultMapper.addFaultType(faultType);
        Result result = new Result();
        if (row != 0){
            result.setCode(200);
            result.setMsg("添加成功");
        } else {
            result.setCode(500);
            result.setMsg("添加失败");
        }
        return result;
    }

    @Override
    public Result updateFaultType(FaultType faultType) {
        int row = faultMapper.updateFaultType(faultType);
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
    public Result delFaultType(Integer id) {
        int row = faultMapper.delFaultTypeById(id);
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
    public JsonResult findAllFaultList(Integer page, Integer limit) {
        List<FaultListInfo> faultListInfos = faultMapper.findAllFaultList((page-1)*limit, limit);
        for (FaultListInfo faultInfo : faultListInfos) {
            Routes route = routeMapper.findRouteById(faultInfo.getRouteId());
            Towers tower = routeMapper.findTowerById(faultInfo.getTowerId());
            Users user = userMapper.findUserById(faultInfo.getUserId());
            FaultType faultType = faultMapper.findFaultTypeById(faultInfo.getFaultId());
            faultInfo.setRouteNumber(route.getRouteNumber());
            faultInfo.setTowerNumber(tower.getNumber());
            faultInfo.setFinder(user.getUserName());
            faultInfo.setFaultName(faultType.getFaultName());
        }
        JsonResult result = new JsonResult();
        result.setCode(0);
        result.setMsg("查询成功");
        result.setCount(faultMapper.countFaultList((page-1)*limit, limit));
        result.setData(faultListInfos);
        return result;
    }
}
