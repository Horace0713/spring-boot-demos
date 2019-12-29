package com.horace.log.desensitize;

import org.springframework.stereotype.Component;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-29 22:14
 */
@Component
public class NameMask implements LogMask {
    @Override
    public String regex() {
        return null;
    }

    @Override
    public String mask(String oriStr) {
        return null;
    }
}
