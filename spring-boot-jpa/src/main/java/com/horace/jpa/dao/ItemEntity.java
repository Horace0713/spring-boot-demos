package com.horace.jpa.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-11-22 21:39
 */
@Entity
@Table(name = "tb_item")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    //@Column(columnDefinition = "COMMENT '商品id，同时也是商品编号'")
    private Long id;

    //@Column(nullable = false, columnDefinition = "varchar(100) COMMENT '商品标题'")
    private String title;

    //@Column(columnDefinition = "varchar(500) COMMENT '商品卖点'")
    private String sellPoint;

    //@Column(precision = 10, scale = 4, columnDefinition = "COMMENT '商品价格，单位为：分'")
// 整数位数是10-4=6位，超过及报错，小数是4位，不足补0，超过就四舍五入
    private BigDecimal price;

    //@Column(columnDefinition = " COMMENT '库存数量'")
    private Integer num;

    //@Column(columnDefinition = "varchar(30)  COMMENT '商品条形码'")
    private String barcode;

//    //@Column(columnDefinition = "varchar(500)  COMMENT '商品图片'")
    private String image;

    //@Column(columnDefinition = "bigint(10) COMMENT '所属类目，叶子类目'")
    private Long cid;

    //@Column(nullable = false, columnDefinition = "tinyint(4) DEFAULT '1' COMMENT '商品状态，1-正常，2-下架，3-删除'")
    private Integer status;

    //@Column(columnDefinition = " COMMENT '上架时间'")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime upTime;

//    //@Column(columnDefinition = " COMMENT '下架时间'")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  这个注解没有起作用
    private LocalDateTime downTime;

    @CreatedDate
    private LocalDateTime createTime;

    @CreatedBy
    private String createBy;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @LastModifiedBy
    private String updateBy;

}
