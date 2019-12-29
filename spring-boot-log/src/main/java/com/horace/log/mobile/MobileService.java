package com.horace.log.mobile;

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
        log.info(mobileNo);
    }
}
