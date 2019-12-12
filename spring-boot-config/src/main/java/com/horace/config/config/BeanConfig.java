package com.horace.config.config;

import com.horace.config.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Horace
 * @desc: @Configuration：指明当前类是一个spring配置类；就是来替代之前的Spring配置文件
 * *
 * * 在配置文件中用<bean><bean/>标签添加组件
 * @project: spring-boot-demos
 * @create: 2019-12-12 22:41
 */
@Configuration
public class BeanConfig {

    /**
     * //将方法的返回值添加到容器中；容器中这个组件 todo 默认的对象id就是方法名
     * @return
     */
//    @Bean(name = "helloworld") //定义id
    @Bean  //默认的对象id就是方法名
    public HelloService hello() {
        return new HelloService();
    }
}
