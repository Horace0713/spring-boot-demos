package com.horace.web.core.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @author: Horace
 * @desc: 启动系统任务
 * @project: spring-boot-demos
 * @create: 2020-01-01 17:23
 */
@Component
@Order(1) //表示执行顺序，数字越小越先执行
@Slf4j
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // MIF 在项目启动的时候做一些事
        log.info(this.getClass().getSimpleName() + "run");
        Set<String> optionNames = args.getOptionNames();
        List<String> nonOptionArgs = args.getNonOptionArgs();
        optionNames.stream().forEach((o) -> System.out.println(o));
        nonOptionArgs.stream().forEach((a) -> System.out.println(a));
    }
}

