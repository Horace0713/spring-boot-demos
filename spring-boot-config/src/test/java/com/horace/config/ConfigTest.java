package com.horace.config;

import com.horace.config.config.PersonConfig;
import com.horace.config.config.PersonValue;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-12 20:54
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ConfigTest {

    @Autowired
    private PersonValue personValue;
    @Autowired
    private PersonConfig config;
    @Autowired
    private ApplicationContext ioc;

    @Test
    public void personValue() {
        Assert.assertNotNull(personValue.getLastName());
        Assert.assertNotNull(personValue.getAge());
        Assert.assertEquals(personValue.getBoss(), true);
        assertThat(personValue.getAge()).isEqualTo(20);
    }

    @Test
    public void personConfig() {
        assertThat(config.getAge()).isEqualTo(18);
        assertThat(config.getLists().size()).isEqualTo(2);
        assertThat(config.getShuangyinhao()).contains("\n");
        assertThat(config.getDanyinhao()).doesNotContain("\n");
        assertThat(config.getDanyinhao()).contains("\\n");
        assertThat(config.getEmail()).isNotNull();
        assertThat(config.getMoney()).isNotNull();
        assertThat(config.getDogList().get(0).getName()).startsWith("wenwen");
        assertThat(config.getVersion()).startsWith("1.8");
    }

    @Test
    public void beanConfig() {
       assertThat(ioc.containsBean("hello")).isTrue(); // 默认方法名就是id
       assertThat(ioc.containsBean("helloworld")).isFalse();
       assertThat(ioc.containsBean("helloService")).isFalse();
    }
}