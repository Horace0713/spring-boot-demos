package com.horace.web.service;

import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate ;

    public String book() {
        log.info(this.getClass().getSimpleName() + "book");
        return "三体";
    }

    public String jpa() {
        String result = restTemplate.getForObject("http://SPRING-BOOT-JPA/jpa/rest/hello", String.class);
        return result;
    }
}
