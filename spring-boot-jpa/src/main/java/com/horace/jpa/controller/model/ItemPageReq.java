package com.horace.jpa.controller.model;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: Horace
 * @desc: item条件分页查询请求
 * @project: spring-boot-demos
 * @create: 2019-11-26 22:26
 */
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ItemPageReq {

    @Min(0)
    private Integer page = 0;

    @Max(100)
    @Min(1)
    private Integer pageSize = 10;

    private String title;

    private String sellPoint;

    private BigDecimal price;

    private Integer num;

    private String barcode;

    private String fromTime;

    private String toTime;
}
