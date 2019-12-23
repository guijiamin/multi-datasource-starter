package com.study.multi.datasource.statistics;

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
@Import({StatisticsDataSourceProperties.class})
@ConditionalOnProperty(name = "statistics.datasource.enabled", havingValue = "true")
@MapperScanner(basePackages = {"${statistics.datasource.basePackage}"}, sqlSessionFactoryRef = "statisticsSqlSessionFactory")
public class StatisticsDataSourceAutoConfiguration {

    @Bean(name = "statisticsDataSource")
    public DataSource statisticsDataSource(StatisticsDataSourceProperties properties) throws SQLException {
        return DruidDataSourceFactory.createDataSource(properties);
    }

    @Bean(name = "statisticsSqlSessionFactory")
    public SqlSessionFactory statisticsSqlSessionFactory(@Qualifier("statisticsDataSource") DataSource dataSource) throws Exception {
        return MybatisSqlSessionFactory.createSqlSessionFactory(dataSource);
    }

    @Bean(name = "statisticsTransactionManager")
    public DataSourceTransactionManager statisticsTransactionManager(@Qualifier("statisticsDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
