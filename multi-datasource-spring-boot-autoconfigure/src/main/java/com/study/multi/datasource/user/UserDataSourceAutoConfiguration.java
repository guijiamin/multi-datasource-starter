package com.study.multi.datasource.user;

import com.study.multi.datasource.factory.DruidDataSourceFactory;
import com.study.multi.datasource.factory.MybatisSqlSessionFactory;
import com.study.multi.datasource.mybatis.scanner.MapperScanner;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
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
@Import({UserDataSourceProperties.class})
@ConditionalOnProperty(name = "user.datasource.enabled", havingValue = "true")
@MapperScanner(basePackages = {"${user.datasource.basePackage}"}, sqlSessionFactoryRef = "userSqlSessionFactory")
public class UserDataSourceAutoConfiguration {

    @Bean(name = "userDataSource")
    @Primary
    public DataSource userDataSource(UserDataSourceProperties properties) throws SQLException {
        return DruidDataSourceFactory.createDataSource(properties);
    }

    @Bean(name = "userSqlSessionFactory")
    @Primary
    public SqlSessionFactory userSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
        return MybatisSqlSessionFactory.createSqlSessionFactory(dataSource);
    }

    @Bean(name = "userTransactionManager")
    @Primary
    public DataSourceTransactionManager userTransactionManager(@Qualifier("userDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
