package com.horace.jpa.controller.model;

import lombok.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author: Horace
 * @desc:  分页返回
 * @project: spring-boot-demos
 * @create: 2019-11-25 22:39
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResp<T> {
    private int page;
    private int totalPage;
    private Long totalNum;
    private List<T> content;
//    private Pageable pageable; //如果能返回这个，很省事
}
