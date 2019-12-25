package com.horace.jpa.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemReq {
    private Long id;

    private String title;
    @NotBlank(message = "卖点不能为空")
    private String sellPoint;

    @JsonIgnore  //转json忽略这个字段
    private BigDecimal price;

    private Integer num;

    private String barcode;

    private String image;

    private Integer cid;

    private Integer status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //todo 为什么不管用
    private LocalDateTime upTime;

    private LocalDateTime downTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 管用  默认用MappingJackson2HttpMessageConverter转Json
    private LocalDateTime createTime;

    private String createBy;

    private LocalDateTime updateTime;

    private String updateBy;
}
