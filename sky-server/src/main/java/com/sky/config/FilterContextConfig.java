package com.sky.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

public class FilterContextConfig {
    @Bean
    public FilterRegistrationBean sentinelFilterRegistration(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new CommonsRequestLoggingFilter());
        registrationBean.addUrlPatterns("/*");
        //入口资源关闭集合
        registrationBean.addInitParameter(CommonsRequestLoggingFilter.ALREADY_FILTERED_SUFFIX,"false");
        registrationBean.setName("sentinelFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
