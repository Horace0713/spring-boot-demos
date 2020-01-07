package com.horace.test.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author: Horace
 * @desc: TestRestTemplate 测试方式 ，使用一个真实的 Servlet 环境而不是模拟
 * 的 Servlet 环境
 * @project: spring-boot-demos
 * @create: 2020-01-02 21:00
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class TestRestTemplateTest {

    /**
     * 需要将＠Spring BootTest 注解中
     * webEnvironment 属’性的默认值由 WebEnvironment.MOCK 修改为 WebEnvironment.DEFINED PORT
     * 或者 WebEnvironment.RANDOM PORT
     */

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void hello() {

        String name = "胡浩然";
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/hello?name=" + name, String.class);
        assertThat(responseEntity.getBody()).isEqualTo("hello " + name);
    }
}