package com.horace.config.config;

import com.horace.config.model.Dog;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-11 21:35
 */
//@PropertySource(value = {"classpath:application-person.yml"}) 加载指定配置文件  todo 不好用
@ConfigurationProperties(prefix = "person") //默认当前环境中变量中获取值
@Component
@Slf4j
@Data
@Validated  //todo JSR303 数据校验，只要加这一个注解
public class PersonConfig {

   /*
   @Value 不支持复杂数据，如集合，对象
    */

    private String lastName;

    private Integer age;

    private Boolean boss;

    private Date birth;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    private String email;

    private String shuangyinhao;

    private String danyinhao;

    private String bigStr;

    private Map<String, Object> maps;

    private Map<String, Object> maps2;

    private List<Object> lists;

    private Dog dog;

    private List<Dog> dogList;

    private Map<String, List<Dog>> dogMap;

    @PostConstruct
    public void init() {
        log.info("{} {}", this.getClass().getSimpleName(), this);
    }
}
