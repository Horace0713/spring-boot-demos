package com.horace.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2020-01-01 18:05
 */
@Service
@Slf4j
public class BookServce {

    public String book() {
        log.info(this.getClass().getSimpleName() + "book");
        return "三体";
    }
}
