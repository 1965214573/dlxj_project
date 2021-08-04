package com.example.mapper;

import com.example.VO.FaultListInfo;
import com.example.pojo.FaultType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/7 23:08
 */
@Mapper
public interface FaultMapper {

    List<FaultType> findAllFaultType(@Param("page") Integer page, @Param("limit") Integer limit);

    int countFaultType(@Param("page") Integer page, @Param("limit") Integer limit);

    int addFaultType(FaultType faultType);

    int updateFaultType(FaultType faultType);

    int delFaultTypeById(@Param("id") Integer id);

    List<FaultListInfo> findAllFaultList(@Param("page") Integer page, @Param("limit") Integer limit);

    int countFaultList(@Param("page") Integer page, @Param("limit") Integer limit);

    FaultType findFaultTypeById(@Param("faultId") String faultId);
}
