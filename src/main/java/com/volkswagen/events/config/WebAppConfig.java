package com.volkswagen.events.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.volkswagen.events.security.UserSecurityInterceptor;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class WebAppConfig extends WebMvcAutoConfigurationAdapter {

    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new UserSecurityInterceptor()).addPathPatterns("/*").excludePathPatterns("/login*","/static/**");
        super.addInterceptors(registry);
        
    }
}
