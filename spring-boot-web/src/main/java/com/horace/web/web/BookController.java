package com.horace.web.web;

import com.horace.web.utils.validate.groups.Group1;
import com.horace.web.web.model.Book;
import com.horace.web.web.model.ResultWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-16 22:50
 */
@RestController  //默认MappingJackson2HttpMessageConverter 转成Json给前端
public class BookController {

    @PostMapping("/book")
    public ResultWrapper book(@RequestBody @Validated(value = Group1.class) Book book, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map((e) -> e.getDefaultMessage()).collect(Collectors.toList());
            return ResultWrapper.builder()
                    .status(ResultWrapper.Status.BAD_REQUEST)
                    .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                    .data(errors)
                    .build();
        }

        return success(Book.builder()
                .author("刘慈欣")
                .name("三体")
                .price(new BigDecimal(100))
                .pubTime(LocalDateTime.of(2006, 10, 1, 10, 12, 12))
                .build());
    }

//    @ExceptionHandler
//    @ResponseStatus()
//    ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
//    }

    private ResultWrapper success(Object o) {
        return ResultWrapper.builder()
                .data(o)
                .status(ResultWrapper.Status.SUCCESS)
                .build();
    }
}
