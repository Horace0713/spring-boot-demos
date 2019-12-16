package com.horace.web.web;

import com.horace.web.web.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-16 22:50
 */
@RestController  //默认MappingJackson2HttpMessageConverter 转成Json给前端
public class BookController {

    @GetMapping("/book")
    public Book book() {
        return Book.builder()
                .author("刘慈欣")
                .name("三体")
                .price(new BigDecimal(100))
                .pubTime(LocalDateTime.of(2006, 10, 1, 10, 12, 12))
                .build();
    }
}
