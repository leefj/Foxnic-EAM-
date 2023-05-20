package com.dt.platform.common.config;


import com.bstek.ureport.definition.datasource.BuildinDatasource;
import com.dt.platform.framework.datasource.DatasourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@Component
public class UreportDataSource implements BuildinDatasource {


    @Resource(name = DatasourceConfig.PRIMARY_DATA_SOURCE_NAME)
    private DataSource dataSource;

    private Logger log = LoggerFactory.getLogger(getClass());


    @Override
    public String name() {
        return "currentDataSource";
    }


    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();

        } catch (SQLException e) {
            log.error("Ureport 数据源 获取连接失败！");
            e.printStackTrace();
        }
        return null;
    }

}
