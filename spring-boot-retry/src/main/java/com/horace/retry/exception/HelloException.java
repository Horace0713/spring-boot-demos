package com.horace.retry.exception;

import lombok.*;

import java.util.Map;

/**
 * @author: Horace
 * @desc:
 * @project: base-demo
 * @create: 2019-12-14 10:51
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Builder
public class HelloException extends RuntimeException{

    private int status; //http状态码
    private boolean isServerSide; //是不是server异常
    private boolean retryAble; // 是否重试，如果不是client_error就会重试
    private String code;
    private String message; //异常信息的body
    private Map<String,String> detail;
}
