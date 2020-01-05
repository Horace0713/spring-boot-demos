package com.horace.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2020-01-01 18:05
 */
@Service
@Slf4j
public class BookServce {

    @Autowired
    private RestTemplate restTemplate;

    public String book() {
        log.info(this.getClass().getSimpleName() + "book");
        return "三体";
    }

    public String jpa() {
        /**
         * 关于实现  用1个TxId 查一次请求 在不同服务上log 的总结
         * 1. eureka ：
         * 2. gateway ：转发A B的服务，负载均衡，并注册到eureka，引入sleuth服务
         * 3. A 服务：注册到eureka，引入sleuth服务，spring.application.name , servlet.context-path都要配，A调B服务，
         *      必须自定义Restemplate，并且必须加@LoadBalanced，否则不走door，各服务TxId不一样
         * 4. B 服务：注册到eureka，引入sleuth服务，spring.application.name , servlet.context-path都要配
         * 5. todo logback.xml 明确TxId在日志中的格式
         * 6. todo accesslog 在tomcat中配，带上TxId
         */
        String result = restTemplate.getForObject("http://SPRING-BOOT-JPA/jpa/rest/hello", String.class);
        return result;
    }

    public Map retry() {
        Map result = restTemplate.postForObject("http://SPRING-BOOT-RETRY/retry/rest/sign", null, Map.class);
        return result;
    }
}
