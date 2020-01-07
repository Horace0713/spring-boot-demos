package com.horace.test.web;

import com.horace.test.web.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2020-01-07 22:43
 */
@RunWith(SpringRunner.class)
@JsonTest //注解将自动配置 Jackson O均ectMapper 、 ＠JsonComponent 以及 Jackson Modules 。
public class JSONTest {
    @Autowired
    JacksonTester<Book> jacksonTester;

    @Test
    public void testDeserialize() throws IOException {
        String s = "{\"id\":\"1\",\"name\":\"三体\",\"author\":\"大刘\"}";
        Book book = jacksonTester.parseObject(s);
        assertThat(book.getName()).isEqualTo("三体");//反序列化

        assertThat(jacksonTester.write(book)).isEqualToJson("book.json");

    }

}
