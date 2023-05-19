package com.dt.platform.common.service.impl;

import com.github.foxnic.dao.spec.DAO;
import org.github.foxnic.web.framework.dao.DBConfigs;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import com.bstek.ureport.console.UReportServlet;
import com.bstek.ureport.definition.datasource.BuildinDatasource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@Component
public class UreportDataSource implements BuildinDatasource {
    @Resource
    DataSource dataSource;

    @Resource(name= DBConfigs.PRIMARY_DAO)
    private DAO dao=null;

    private Logger log = LoggerFactory.getLogger(getClass());

    // 构建数据源名称
    @Override
    public String name() {
        return "uReportDataSource";
    }

    // 构建数据源连接
    @Override
    public Connection getConnection() {
        try {
            System.out.println("###getConnection");
            return dao.getDataSource().getConnection();

        } catch (SQLException e) {
            log.error("Ureport 数据源 获取连接失败！");
            e.printStackTrace();
        }
        return null;
    }

}
