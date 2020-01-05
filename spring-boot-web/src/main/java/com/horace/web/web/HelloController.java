package com.horace.web.web;

import com.horace.web.service.BookServce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BookServce bookServce;

    @GetMapping("/hello")
    public String hello() {
        log.info("hello");
        bookServce.jpa();
        return "hello world";
    }
}
