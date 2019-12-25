package com.horace.web.core.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Horace
 * @desc: 拦截器配置
 * @project: spring-boot-demos
 * @create: 2019-12-25 23:12
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**") //拦截路径
                .excludePathPatterns("/hello"); //排除路径
    }
}
