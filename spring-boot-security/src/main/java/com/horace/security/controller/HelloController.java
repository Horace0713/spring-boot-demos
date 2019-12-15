package com.horace.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Horace
 * @desc:
 * @project: base-demo
 * @create: 2019-11-20 22:25
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/horace")
    public String horace() {
        return "horace";
    }

    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin!";
    }

    @GetMapping("/user/hello")
    public String user() {
        return "hello user!";
    }

    @GetMapping("/db/hello")
    public String dba() {
        return "hello dba!";
    }
}
