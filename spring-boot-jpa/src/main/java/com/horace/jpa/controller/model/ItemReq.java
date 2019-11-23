package com.horace.jpa.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-11-23 11:54
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemReq {
    private Long id;

    private String title;

    private String sellPoint;

    private BigDecimal price;

    private Integer num;

    private String barcode;

    private String image;

    private Integer cid;

    private Integer status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //todo 为什么不管用
    private LocalDateTime upTime;

    private LocalDateTime downTime;

    private LocalDateTime createTime;

    private String createBy;

    private LocalDateTime updateTime;

    private String updateBy;
}
