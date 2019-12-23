package com.study.sample.service;

import com.study.sample.dao.statistics.StatisticsMapper;
import com.study.sample.entity.Statistics;
import org.springframework.stereotype.Service;

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
@Service
public class StatisticsService {
    @Resource
    private StatisticsMapper statisticsMapper;

    public List<Statistics> findAll() {
        return statisticsMapper.selectAll();
    }
}
