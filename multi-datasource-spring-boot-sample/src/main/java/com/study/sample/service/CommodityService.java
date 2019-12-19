package com.study.sample.service;

import com.study.sample.dao.commodity.CommodityMapper;
import com.study.sample.entity.Commodity;
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
public class CommodityService {
    @Resource
    private CommodityMapper commodityMapper;

    public List<Commodity> findAll() {
        return commodityMapper.selectAll();
    }
}
