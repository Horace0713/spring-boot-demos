package com.horace.log.desensitize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-29 22:16
 */
@Component
public class LogApplicationRunner implements ApplicationRunner {

    @Autowired
    private List<LogMask> logMasks;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println(logMasks.toString());
    }
}
