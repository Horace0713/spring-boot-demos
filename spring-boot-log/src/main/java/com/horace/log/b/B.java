package com.horace.log.b;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-29 18:06
 */
@Service
@Slf4j
public class B {
    public void debug() {
        log.info(this.getClass().getSimpleName() + "这是info日志");
        log.debug(this.getClass().getSimpleName() + "这是debug日志");
    }
}
