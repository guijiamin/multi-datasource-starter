package com.study.sample.dao.user;

import com.study.sample.entity.User;
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
public interface UserMapper {
    @Select("select * from user")
    List<User> selectAll();
}
