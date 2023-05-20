package com.dt.platform.common.config;

import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import com.bstek.ureport.definition.datasource.BuildinDatasource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.SQLException;


@Component
public class UreportDataSource implements BuildinDatasource {


    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    private Logger log = LoggerFactory.getLogger(getClass());


    @Override
    public String name() {
        return "currentDataSource";
    }


    @Override
    public Connection getConnection() {
        try {
            return dao.getDataSource().getConnection();

        } catch (SQLException e) {
            log.error("Ureport 数据源 获取连接失败！");
            e.printStackTrace();
        }
        return null;
    }

}
