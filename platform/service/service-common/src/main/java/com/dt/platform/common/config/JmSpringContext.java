
package com.dt.platform.common.config;

import com.bstek.ureport.UReportPropertyPlaceholderConfigurer;
import com.bstek.ureport.console.UReportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.ClassPathResource;

import javax.servlet.Servlet;


//@ImportResource("classpath:ureport-console-context.xml")// 引入ureport-console-context.xml配置文件
//@Configuration
public class JmSpringContext {

    /*定义ureport的启动servlet*/
    @Bean
    @SuppressWarnings("unchecked")
    public ServletRegistrationBean<Servlet> JmServlet(){
        return new ServletRegistrationBean<>(new JmReportServlet(),"/jmreport/list","/jmreport/*");
    }

//    @Bean
//    public UReportPropertyPlaceholderConfigurer UReportPropertyPlaceholderConfigurer(){
//        UReportPropertyPlaceholderConfigurer config=new UReportPropertyPlaceholderConfigurer();
//        config.setIgnoreUnresolvablePlaceholders(true);
//        config.setOrder(1);
//        ClassPathResource path=new ClassPathResource("context.properties");
//        config.setLocation(path);
//        return config;
//    }



}
