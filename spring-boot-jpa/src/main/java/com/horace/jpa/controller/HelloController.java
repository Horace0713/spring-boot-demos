package com.horace.jpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-11-21 22:16
 */
@RestController
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
//        int i = 1 / 0;
        log.info("/hello 请求");
        return "hello world";
    }
}
