package com.horace.log.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-29 18:38
 */
@Slf4j
@Service
public class MobileService {
    public void call(String mobileNo) {

        log.error("给{}打电话", mobileNo);
        log.warn("给{}打电话", mobileNo);
        log.info("给{}打电话", mobileNo);
        log.debug("给{}打电话", mobileNo);
        log.trace("给{}打电话", mobileNo);
    }
}
