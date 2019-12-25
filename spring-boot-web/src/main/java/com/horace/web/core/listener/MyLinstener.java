package com.horace.web.core.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-25 23:31
 */
@WebListener
@Slf4j
public class MyLinstener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info(this.getClass().getSimpleName() + "------>" + "requestDestroyed");

        //todo 重要的是这里能做什么
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info(this.getClass().getSimpleName() + "------>" + "requestInitialized");

        //todo 重要的是这里能做什么

    }
}
