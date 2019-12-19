package com.study.multi.datasource;

/**
 * Decription
 * <p>
 * </p>
 * DATE 2019-12-17.
 *
 * @author guijiamin.
 */
public interface DataSourceProperties {
    String getUrl();

    String getUserName();

    String getPassword();

    String getDriverClass();

    boolean isWallFilter();
}
