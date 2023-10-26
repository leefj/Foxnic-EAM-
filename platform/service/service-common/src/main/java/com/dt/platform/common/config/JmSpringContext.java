
package com.dt.platform.common.config;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Servlet;

public class JmSpringContext {

    @Bean
    @SuppressWarnings("unchecked")
    public ServletRegistrationBean<Servlet> JmServlet(){
        return new ServletRegistrationBean<>(new JmReportServlet(),"/jmreport/list","/jmreport/*");
    }

}
