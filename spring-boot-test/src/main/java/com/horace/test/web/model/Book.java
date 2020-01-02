package com.horace.test.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2020-01-02 21:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Integer id ;
    private String name;
    private String author ;
}
