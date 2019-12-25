package com.horace.web.core.interceptor;

import com.horace.web.web.model.ResultWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-25 23:06
 */
@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    /*
         执行顺序：preHandle--->controller-->postHandle---->afterCompletion
         preHandlef返回true，后面的方法才会执行
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info(this.getClass().getSimpleName() + "------>" + "preHandle");
        //todo 重要的是这里能做什么，而不只是执行顺序
        ResultWrapper resultWrapper = ResultWrapper.builder()
                .status(ResultWrapper.Status.BAD_REQUEST)
                .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .data("请求错误")
                .build();
//        response.getWriter().write(resultWrapper.toString());
        return true;//preHandlef返回true，后面的方法才会执行,如果返回false，并且response没有丢数据，那么调用方只能收到200，没有body
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info(this.getClass().getSimpleName() + "------>" + "postHandle");
        //todo 重要的是这里能做什么，而不只是执行顺序

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info(this.getClass().getSimpleName() + "------>" + "afterCompletion");
        //todo 重要的是这里能做什么，而不只是执行顺序

    }
}
