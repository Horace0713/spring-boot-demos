package com.horace.config.config;

import com.horace.config.model.Dog;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
//@ConfigurationProperties(prefix = "person")
@Component
@Slf4j
@Data
public class PersonValue {

    /**
     * <bean class="Person">
     *      <property name="lastName" value="
     *      1.字面量/
     *      2.${key}从环境变量、配置文件中获取值/
     *      3.#{SpEL}"></property>  spring EL表达式
     * <bean/>
     */

    @Value("${person.last-name}") // 从环境变量、配置文件中获取值
//    @Value("${person.lastName}")  todo 不支持松散绑定，lastName既能取到lastName，又能取到last-name，叫做松散绑定，ConfigurationProperties能做到松散绑定
    private String lastName;

    @Value("#{10*2}")
    private Integer age; //   spring EL表达式

    @Value("true") // 字面量
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
