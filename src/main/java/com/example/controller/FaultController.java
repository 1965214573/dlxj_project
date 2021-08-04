package com.example.controller;

import com.example.common.JsonResult;
import com.example.common.Result;
import com.example.pojo.FaultType;
import com.example.service.FaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/7 23:03
 */
@RestController
public class FaultController {

    @Autowired
    private FaultService faultService;



    @GetMapping("/findAllFault")
    public JsonResult findAllFault(Integer page, Integer limit){
        return faultService.findAllFaultType(page, limit);
    }

    @PostMapping("/addFaultType")
    public Result addFaultType(FaultType faultType){
        return faultService.addFaultType(faultType);
    }

    @PostMapping("/updateFaultType")
    public Result updateFaultType(FaultType faultType){
        return faultService.updateFaultType(faultType);
    }

    @PostMapping("/delFaultType")
    public Result delFaultType(Integer id){
        return faultService.delFaultType(id);
    }

    @GetMapping("/findAllFaultList")
    public JsonResult findAllFaultList(Integer page, Integer limit){
        return faultService.findAllFaultList(page, limit);
    }
}
