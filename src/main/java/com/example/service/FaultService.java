package com.example.service;

import com.example.common.JsonResult;
import com.example.common.Result;
import com.example.pojo.FaultType;
import org.springframework.stereotype.Service;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/7 23:05
 */

public interface FaultService {
    JsonResult findAllFaultType(Integer page, Integer limit);

    Result addFaultType(FaultType faultType);

    Result updateFaultType(FaultType faultType);

    Result delFaultType(Integer id);

    JsonResult findAllFaultList(Integer page, Integer limit);
}
