package com.horace.security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @Secured("ROLE_ADMIN")
    public String admin() {
        return "hello admin!";
    }

    @GetMapping("/user/hello")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String user() {
        return "hello user!";
    }

    @GetMapping("/db/hello")
    @PreAuthorize("hasRole('ADMIN') and hasRole('DBA')")
    public String dba() {
        return "hello dba!";
    }
}
