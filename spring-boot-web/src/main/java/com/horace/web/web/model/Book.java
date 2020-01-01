package com.horace.web.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.horace.web.utils.validate.PhoneCheck;
import com.horace.web.utils.validate.groups.Group1;
import com.horace.web.utils.validate.groups.Group2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-16 22:55
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @NotBlank(message = "名字不能为空", groups = {Group1.class, Group2.class})  //分组校验，如果根据业务需求，不需要做这么多校验，
    // 这时可以对规则分组，在校验时指定分组 ,但如果指定了分组，使用时未指定分组，则指定了分组的校验不生效，只有未指定分组的生效
    private String name;

    @NotBlank(message = "作者不能为空")
    private String author;

    @NotBlank(message = "ibsn 不能为空")
    private String ibsn;

    @JsonIgnore  //转json忽略该值
    private BigDecimal price;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //转成特定的格式给前端 // 管用  默认用MappingJackson2HttpMessageConverter转Json
    private LocalDateTime pubTime;

    @NotBlank(message = "手机号 不能为空")
    @PhoneCheck(groups = Group2.class)
    private String phone;

//    @Digits(integer = 100, fraction = 2)
    @Max(2000)
    @Min(1)
    private String totalPage;//总页数

    @Future(message = "上架时间 不能早于现在") //被注解的元素必须是一个未来或当前的时间
    private Date upTime;

    @FutureOrPresent(message = "下架时间不能早于现在") //被注解的元素必须是一个未来或当前的时间，适用于java.time包下的时间类+Date+Calender
    private LocalDateTime downTime;

    @PastOrPresent(message = " 写书时间必须是过去时间")
    private LocalDateTime writeTime;
}
