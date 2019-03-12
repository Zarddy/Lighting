package com.zarddy.lighting.configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a href="https://www.jianshu.com/p/e84e2709f383">第四章：使用Druid作为SpringBoot项目数据源（添加监控）</a>
 */
@Configuration
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean statViewServlet() {
        // create servlet entity
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // ip white list
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
        // ip black list
        servletRegistrationBean.addInitParameter("deny", "192.168.0.1");
        // setting terminal root
        servletRegistrationBean.addInitParameter("loginUsername", "druid");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
        // can reset data
        servletRegistrationBean.addInitParameter("resetEnable", "false");

        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        // setting filter path
        filterRegistrationBean.addUrlPatterns("/*");
        // ignore files
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        return filterRegistrationBean;
    }
}
