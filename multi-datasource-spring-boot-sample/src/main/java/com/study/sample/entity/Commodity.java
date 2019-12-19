package com.study.sample.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Decription
 * <p>
 * </p>
 * DATE 2019-12-18.
 *
 * @author guijiamin.
 */
@Data
public class Commodity {
    private Integer id;
    private String commodityName;
    private BigDecimal commodityPrice;
    private Date createTime;
    private Date updateTime;
}
