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

import javax.validation.constraints.NotBlank;
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
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @NotBlank(message = "名字不能为空", groups = {Group1.class, Group2.class})  //分组校验，如果根据业务需求，不需要做这么多校验，
    // 这时可以对规则分组，在校验时指定分组 ,但如果指定了分组，使用时未指定分组，则指定了分组的校验不生效，只有未指定分组的生效
    private String name;

    @NotBlank(message = "作者不能为空", groups = Group2.class)
    private String author;

    @NotBlank(message = "ISBN 不能为空")
    private String ISBN;

    @JsonIgnore  //转json忽略该值
    private BigDecimal price;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //转成特定的格式给前端
    private LocalDateTime pubTime;

    @NotBlank(message = "手机号 不能为空", groups = Group1.class)
    @PhoneCheck(groups = Group2.class)
    private String phone;
}
