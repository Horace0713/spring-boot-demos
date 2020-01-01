package com.horace.web.web;

import com.horace.web.service.BookServce;
import com.horace.web.utils.validate.groups.Group1;
import com.horace.web.web.model.Book;
import com.horace.web.web.model.ResultWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.applet.context.NoopExecutionContext;
import sun.util.calendar.LocalGregorianCalendar;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-16 22:50
 */
@RestController  //默认MappingJackson2HttpMessageConverter 转成Json给前端
@Slf4j
public class BookController {

    @Autowired
    private BookServce bookServce;

    @PostMapping("/book")
    public ResultWrapper book(@RequestBody @Validated Book book, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors().stream()
                    .map((e) -> e.getDefaultMessage()).collect(Collectors.toList());
            return ResultWrapper.builder()
                    .status(ResultWrapper.Status.BAD_REQUEST)
                    .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                    .data(errors)
                    .build();
        }
        bookServce.book();

        return success(Book.builder()
                .author("刘慈欣")
                .name("三体")
                .price(new BigDecimal(100))
                .pubTime(LocalDateTime.of(2006, 10, 1, 10, 12, 12))
                .upTime(new Date())
                .downTime(LocalDateTime.now())
                .build());
    }

//    @ExceptionHandler
//    @ResponseStatus()
//    ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
//    }

    @ExceptionHandler
    ResultWrapper httpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error(e.getClass().getSimpleName(), e);
        return ResultWrapper.builder()
                .status(ResultWrapper.Status.BAD_REQUEST)
                .errorCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .data(e.getMessage())
                .build();
    }

    @ExceptionHandler
    ResultWrapper runtimeException(RuntimeException e) {
        log.error(e.getClass().getSimpleName(), e);
        return ResultWrapper.builder()
                .status(ResultWrapper.Status.FAILD)
                .errorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .data(e.getMessage())
                .build();
    }


    private ResultWrapper success(Object o) {
        return ResultWrapper.builder()
                .data(o)
                .status(ResultWrapper.Status.SUCCESS)
                .build();
    }
}
