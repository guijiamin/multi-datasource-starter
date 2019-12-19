package com.study.sample.dao.commodity;

import com.study.sample.entity.Commodity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Decription
 * <p>
 * </p>
 * DATE 2019-12-18.
 *
 * @author guijiamin.
 */
public interface CommodityMapper {
    @Select("select * from commodity")
    List<Commodity> selectAll();
}
