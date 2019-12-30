package com.horace.log.web;

import com.horace.log.a.A;
import com.horace.log.b.B;
import com.horace.log.service.MobileService;
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
public class HelloController {

    @Autowired
    private A a;

    @Autowired
    private B b;
    @Autowired
    private MobileService mobileService;

    @GetMapping("/hello")
    public String hello() {
        a.info();
        b.debug();
        mobileService.call("13964061215");
        return "hello world";
    }
}
