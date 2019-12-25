package com.horace.web.core.fliter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-25 23:25
 */
@WebFilter("/") //todo 为何不走filter
@Slf4j
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(this.getClass().getSimpleName() + "------>" + "init");
//todo 重要的是这里能做什么
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info(this.getClass().getSimpleName() + "------>" + "doFilter");
//todo 重要的是这里能做什么
    }

    @Override
    public void destroy() {
        log.info(this.getClass().getSimpleName() + "------>" + "destroy");
//todo 重要的是这里能做什么
    }
}
