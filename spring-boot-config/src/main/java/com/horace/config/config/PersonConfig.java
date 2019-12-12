package com.horace.config.config;

import com.horace.config.model.Dog;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-11 21:35
 */
@ConfigurationProperties(prefix = "person")
@Component
@Slf4j
@Data
public class PersonConfig {

    private String lastName;

    private Integer age;

    private Boolean boss;

    private Date birth;

    private String email;

    private String shuangyinhao;

    private String danyinhao;

    private String bigStr;

    private Map<String, Object> maps;

    private Map<String, Object> maps2;

    private List<Object> lists;

    private Dog dog;

    private List<Dog> dogList;

    private Map<String,List<Dog>> dogMap;

    @PostConstruct
    public void init() {
        log.info("{} {}", this.getClass().getSimpleName(), this);
    }
}
