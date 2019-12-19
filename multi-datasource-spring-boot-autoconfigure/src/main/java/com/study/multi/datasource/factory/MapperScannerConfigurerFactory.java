package com.study.multi.datasource.factory;

import org.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Decription
 * <p>
 * </p>
 * DATE 2019-12-17.
 *
 * @author guijiamin.
 */
public class MapperScannerConfigurerFactory {
    public MapperScannerConfigurerFactory() {

    }

    public static MapperScannerConfigurer createMapperScannerConfigurer(String sqlSessionFactoryName, String basePackage) {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName(sqlSessionFactoryName);
        mapperScannerConfigurer.setBasePackage(basePackage);
        return mapperScannerConfigurer;
    }
}
