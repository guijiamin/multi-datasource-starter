package com.study.sample.api;

import com.study.sample.entity.Commodity;
import com.study.sample.entity.Statistics;
import com.study.sample.entity.User;
import com.study.sample.service.CommodityService;
import com.study.sample.service.StatisticsService;
import com.study.sample.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Decription
 * <p>
 * </p>
 * DATE 2019-12-18.
 *
 * @author guijiamin.
 */
@RestController
@RequestMapping("/api")
public class AppController {
    @Resource
    private UserService userService;
    @Resource
    private CommodityService commodityService;
    @Resource
    private StatisticsService statisticsService;

    @GetMapping("user/findAll")
    public List<User> findAllUser() {
        return userService.findAll();
    }

    @GetMapping("commodity/findAll")
    public List<Commodity> findAllOrder() {
        return commodityService.findAll();
    }

    @GetMapping("statistics/findAll")
    public List<Statistics> findAllStatistics() {
        return statisticsService.findAll();
    }
}
