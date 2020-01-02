package com.horace.test.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.horace.test.web.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author: Horace
 * @desc:  MockMvc 测试方式
 * @project: spring-boot-demos
 * @create: 2020-01-02 21:00
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class HelloControllerTest {

    @Autowired
    private WebApplicationContext wac; //注入一个 WebApplicationContext 用来模拟 ServletContext 环境。

    private MockMvc mockMvc;

    @Before
    public void before() {
        //在每个测试方法执行前进行 MockMvc 的初始化操作
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void hello() throws Exception {

        String name = "胡浩然";
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("name", name))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("hello " + name);
    }

    @Test
    public void addBook() throws Exception {
        Book book = Book.builder()
                .author("刘慈欣")
                .name("三体")
                .id(10000)
                .build();
        String s = new ObjectMapper().writeValueAsString(book);

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(s))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo(book.toString());
    }
}