package com.horace.log.desensitize;

import org.springframework.stereotype.Component;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-29 22:12
 */
@Component
public interface LogMask {

    String maskChar = "*";

    String regex();

    String mask(String oriStr);
}
