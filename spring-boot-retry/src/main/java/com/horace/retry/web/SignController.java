package com.horace.retry.web;

import com.horace.retry.exception.HelloException;
import com.horace.retry.service.SignService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-17 22:26
 */
@RestController
@Slf4j
public class SignController {

    @Autowired
    private SignService signService;

    @PostMapping("/sign")
    public Map<String, String> sign() throws InterruptedException {
        log.info("sign方法 当前线程是 "+Thread.currentThread().getName());

        signService.signContract(); //todo 如果不自定义线程池，什么情况会内存溢出，另外如果停服重启，如何继续重试

        Map<String, String> map = new HashMap<>();
        map.put("bizNo", UUID.randomUUID().toString());
        return map;
    }
}
