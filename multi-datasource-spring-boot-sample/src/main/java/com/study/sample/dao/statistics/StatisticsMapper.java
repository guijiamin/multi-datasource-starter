package com.study.sample.dao.statistics;

import com.study.sample.entity.Statistics;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Decription
 * <p>
 * </p>
 * DATE 2019-12-23.
 *
 * @author guijiamin.
 */
public interface StatisticsMapper {
    @Select("select * from statistics")
    List<Statistics> selectAll();
}
