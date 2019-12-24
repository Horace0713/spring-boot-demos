package com.horace.web.web;

import com.horace.web.web.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Book book(@RequestBody @Valid Book book) {
        return Book.builder()
                .author("刘慈欣")
                .name("三体")
                .price(new BigDecimal(100))
                .pubTime(LocalDateTime.of(2006, 10, 1, 10, 12, 12))
                .build();
    }

//    @ExceptionHandler
//    @ResponseStatus()
//    ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
//    }
}
