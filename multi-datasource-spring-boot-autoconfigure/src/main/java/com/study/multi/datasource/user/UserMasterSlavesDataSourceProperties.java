package com.study.multi.datasource.user;

import com.study.multi.datasource.DataSourceProperties;
import com.study.multi.datasource.MasterSlavesDataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Decription
 * <p>
 * </p>
 * DATE 2019-12-23.
 *
 * @author guijiamin.
 */
@Configuration
@ConfigurationProperties(prefix = "user.datasource.ms")
public class UserMasterSlavesDataSourceProperties implements MasterSlavesDataSourceProperties {
    private String master;
    private String slaves;
    private String userName;
    private String password;
    private String driverClass;
    private boolean wallFilter;

    @Override
    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    @Override
    public String getSlaves() {
        return slaves;
    }

    public void setSlaves(String slaves) {
        this.slaves = slaves;
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
