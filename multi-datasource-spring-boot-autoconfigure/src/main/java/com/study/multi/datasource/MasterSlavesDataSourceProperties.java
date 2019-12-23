package com.study.multi.datasource;

/**
 * Decription
 * <p>
 * </p>
 * DATE 2019-12-23.
 *
 * @author guijiamin.
 */
public interface MasterSlavesDataSourceProperties {
    String getMaster();

    String getSlaves();

    String getUserName();

    String getPassword();

    String getDriverClass();

    boolean isWallFilter();
}
