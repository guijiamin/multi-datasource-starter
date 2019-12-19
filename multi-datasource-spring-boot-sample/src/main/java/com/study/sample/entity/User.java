package com.study.sample.entity;

import lombok.Data;

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
public class User {
    private Integer id;
    private String userName;
    private Date createTime;
    private Date updateTime;
}
