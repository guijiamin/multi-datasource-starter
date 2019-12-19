package com.study.multi.datasource.factory;

import com.alibaba.druid.pool.DruidDataSource;
import com.study.multi.datasource.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Decription
 * <p>
 * </p>
 * DATE 2019-12-17.
 *
 * @author guijiamin.
 */
public class DruidDataSourceFactory {
    public DruidDataSourceFactory() {

    }

    public static DruidDataSource createDataSource(DataSourceProperties properties) throws SQLException {
        return createDataSource(properties.getUrl(), properties.getUserName(), properties.getPassword(), properties.getDriverClass(), properties.isWallFilter());
    }

    public static DruidDataSource createDataSource(String url, String userName, String password, String driverClass, boolean isWallFilter) throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClass);
        if (isWallFilter) {
            druidDataSource.setFilters("stat,wall,slf4j");
        } else {
            druidDataSource.setFilters("stat,slf4j");
        }
        druidDataSource.setMaxActive(50);
        druidDataSource.setInitialSize(5);
        druidDataSource.setMaxWait(5000L);
        druidDataSource.setMinIdle(5);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000L);
        druidDataSource.setMinEvictableIdleTimeMillis(300000L);
        druidDataSource.setValidationQuery("select 'x'");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(true);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setAsyncInit(true);
        return druidDataSource;
    }
}
