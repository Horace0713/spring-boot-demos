package com.horace.web.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-16 22:55
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class Book {

    private String name;

    private String author;

    @JsonIgnore  //转json忽略该值
    private BigDecimal price;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //转成特定的格式给前端
    private LocalDateTime pubTime;
}
