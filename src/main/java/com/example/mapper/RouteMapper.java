package com.example.mapper;

import com.example.VO.RouteInfo;
import com.example.VO.TowerInfo;
import com.example.pojo.Routes;
import com.example.pojo.Towers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/6 18:56
 */
@Mapper
public interface RouteMapper {

    int addTower(@Param("number") String number, @Param("routeId") Integer routeId, @Param("towerStatus") Integer towerStatus);
    int delTowerById(@Param("id")Integer id);
    int editTowerById();
    List<TowerInfo> findTower(@Param("routeId") Integer routeId, @Param("towerStatus")Integer towerStatus, @Param("page") Integer page, @Param("limit") Integer limit);
    Integer countTower(@Param("routeId") Integer routeId, @Param("towerStatus")Integer towerStatus, @Param("page") Integer page, @Param("limit") Integer limit);

    Routes findRouteById(@Param("routeId") long routeId);

    int addRoute(Routes route);

    Integer countRoute(@Param("routeNumber") String routeNumber, @Param("routeRunStatus") Integer routeRunStatus, @Param("page") Integer page, @Param("limit") Integer limit);

    List<Routes> findAllRoute(@Param("routeNumber") String routeNumber, @Param("routeRunStatus") Integer routeRunStatus, @Param("page") Integer page, @Param("limit") Integer limit);

    int updateRoute(RouteInfo route);

    int changeTowerStatus(@Param("id") Integer id, @Param("towerStatus") Integer towerStatus);


    int delRouteById(@Param("id")Integer id);

    int changeRouteStatus(@Param("id") Integer id, @Param("routeStatus")Integer routeStatus);

    Towers findTowerById(@Param("towerId") long towerId);

    List<Routes> findRoute();
}
