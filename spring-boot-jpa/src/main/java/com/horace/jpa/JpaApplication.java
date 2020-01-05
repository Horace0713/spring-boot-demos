package com.horace.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-11-21 22:09
 */
@SpringBootApplication
@EnableJpaAuditing
public class JpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }
}
