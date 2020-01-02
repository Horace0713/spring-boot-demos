package com.horace.test.web;

import com.horace.test.web.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2020-01-02 20:59
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(String name) {
        return "hello " + name;
    }

    @PostMapping("/book")
    public String addBook(@RequestBody Book book) {
        return book.toString();
    }
}
