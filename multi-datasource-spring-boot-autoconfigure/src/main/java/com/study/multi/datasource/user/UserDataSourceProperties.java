package com.study.multi.datasource.user;

import com.study.multi.datasource.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Decription
 * <p>
 * </p>
 * DATE 2019-12-17.
 *
 * @author guijiamin.
 */
@Configuration
@ConfigurationProperties(prefix = "user.datasource")
public class UserDataSourceProperties implements DataSourceProperties {
    private String url;
    private String userName;
    private String password;
    private String driverClass;
    private boolean wallFilter;

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    @Override
    public boolean isWallFilter() {
        return wallFilter;
    }

    public void setWallFilter(boolean wallFilter) {
        this.wallFilter = wallFilter;
    }
}
