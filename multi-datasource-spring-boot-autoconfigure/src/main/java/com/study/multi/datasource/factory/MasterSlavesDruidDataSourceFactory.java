package com.study.multi.datasource.factory;

import com.study.multi.datasource.MasterSlavesDataSourceProperties;
import io.shardingsphere.api.algorithm.masterslave.RandomMasterSlaveLoadBalanceAlgorithm;
import io.shardingsphere.api.config.rule.MasterSlaveRuleConfiguration;
import io.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Decription
 * <p>
 * </p>
 * DATE 2019-12-23.
 *
 * @author guijiamin.
 */
public class MasterSlavesDruidDataSourceFactory {
    public MasterSlavesDruidDataSourceFactory() {
    }

    public static DataSource createMasterSlaveDataSource(MasterSlavesDataSourceProperties properties) throws SQLException{
        DataSource masterDataSource = getMasterDataSource(properties);
        Map<String, DataSource> slavesDataSource = getSlavesDataSource(properties);
        Map<String, DataSource> dataSourceMap = new HashMap<>(16);
        dataSourceMap.put("master", masterDataSource);
        dataSourceMap.putAll(slavesDataSource);
        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration("ds_master_slave", "master", slavesDataSource.keySet(), new RandomMasterSlaveLoadBalanceAlgorithm());
        return MasterSlaveDataSourceFactory.createDataSource(dataSourceMap, masterSlaveRuleConfig, new HashMap<>(), new Properties());
    }

    private static DataSource getMasterDataSource(MasterSlavesDataSourceProperties properties) throws SQLException {
        return DruidDataSourceFactory.createDataSource(properties.getMaster(), properties.getUserName(), properties.getPassword(), properties.getDriverClass(), properties.isWallFilter());
    }

    private static Map<String, DataSource> getSlavesDataSource(MasterSlavesDataSourceProperties properties) throws SQLException {
        List<String> slaves = Stream.of(properties.getSlaves().split(",")).collect(Collectors.toList());
        Map<String, DataSource> map = new HashMap<>(16);
        for (int i = 0; i < slaves.size(); i++) {
            DataSource dataSource = DruidDataSourceFactory.createDataSource(slaves.get(i), properties.getUserName(), properties.getPassword(), properties.getDriverClass(), properties.isWallFilter());
            map.put("slave".concat(String.valueOf(i)), dataSource);
        }
        return map;
    }
}
