package com.dt.platform.common.service.impl;

import com.bstek.ureport.UReportPropertyPlaceholderConfigurer;
import com.bstek.ureport.console.UReportServlet;
import com.bstek.ureport.definition.datasource.BuildinDatasource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@ImportResource("classpath:ureport-console-context.xml")// 引入ureport-console-context.xml配置文件
@Configuration
public class UreportSpringContext {


    @Bean //定义ureport的启动servlet
    @SuppressWarnings("unchecked")
    public ServletRegistrationBean<Servlet> ureportServlet(){
        return new ServletRegistrationBean<>(new UReportServlet(),"/ureport/*");
    }

    @Bean
    public UReportPropertyPlaceholderConfigurer UReportPropertyPlaceholderConfigurer(){
        UReportPropertyPlaceholderConfigurer config=new UReportPropertyPlaceholderConfigurer();
        config.setIgnoreUnresolvablePlaceholders(true);
        config.setOrder(1);
        ClassPathResource path=new ClassPathResource("context.properties");
        config.setLocation(path);
        return config;
    }



}
