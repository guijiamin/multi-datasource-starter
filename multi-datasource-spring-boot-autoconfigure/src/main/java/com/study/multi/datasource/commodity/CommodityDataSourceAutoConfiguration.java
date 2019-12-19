package com.study.multi.datasource.commodity;

import com.study.multi.datasource.factory.DruidDataSourceFactory;
import com.study.multi.datasource.factory.MybatisSqlSessionFactory;
import com.study.multi.datasource.mybatis.scanner.MapperScanner;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

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
@Configuration
@Import({CommodityDataSourceProperties.class})
@ConditionalOnProperty(name = "commodity.datasource.enabled", havingValue = "true")
@MapperScanner(basePackages = {"${commodity.datasource.basePackage}"}, sqlSessionFactoryRef = "commoditySqlSessionFactory")
public class CommodityDataSourceAutoConfiguration {

    @Bean(name = "commodityDataSource")
    public DataSource commodityDataSource(CommodityDataSourceProperties properties) throws SQLException {
        return DruidDataSourceFactory.createDataSource(properties);
    }

    @Bean(name = "commoditySqlSessionFactory")
    public SqlSessionFactory orderSqlSessionFactory(@Qualifier("commodityDataSource") DataSource dataSource) throws Exception {
        return MybatisSqlSessionFactory.createSqlSessionFactory(dataSource);
    }

    @Bean(name = "commodityTransactionManager")
    public DataSourceTransactionManager orderTransactionManager(@Qualifier("commodityDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
