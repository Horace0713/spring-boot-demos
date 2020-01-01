package com.horace.web.core.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2020-01-01 17:30
 */
@Component
@Slf4j
@Order(1)
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        //args 是启动类中但args，参数没有ApplicationRunner多
        log.info(this.getClass().getSimpleName() + "run");
    }
}
