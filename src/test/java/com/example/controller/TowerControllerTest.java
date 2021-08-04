package com.example.controller;

import com.example.SpringbootStart;
import com.example.common.JsonResult;
import com.example.common.Result;
import com.example.service.RouteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author youngoo
 * @version 1.0
 * @description TODO
 * @date 2021/7/6 20:10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SpringbootStart.class})
public class TowerControllerTest {
    @Autowired(required = false)
    RouteService routeService;

    @Test
    public void findTower() {
        JsonResult tower = routeService.findTower(null, null, null, null);
    }

    @Test
    public void addTower() {
        Result result = routeService.addTower("XW00001", 1, 1);
        System.out.println(result.getMsg());
    }
}
