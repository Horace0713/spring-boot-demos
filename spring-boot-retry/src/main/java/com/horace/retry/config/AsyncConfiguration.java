package com.horace.retry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: base-demo
 * @description: todo 不自定义线程池，也有默认的线程池，大小为8，但默认线程池可能不会防止内存溢出
 * @author: yigong.hu
 * @create: 2019-09-27 13:36
 **/
@Configuration
public class AsyncConfiguration {
    public static final String THREAD_NAME_PREFIX = "async-t-";
    private int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
    private int maxPoolSize = 30;
    private int queueCapacity = 10;

    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor e = new ThreadPoolTaskExecutor();
        e.setCorePoolSize(corePoolSize);
        e.setMaxPoolSize(maxPoolSize);
        e.setQueueCapacity(queueCapacity);
        e.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        e.setThreadNamePrefix(THREAD_NAME_PREFIX);
        return e;
    }
}
