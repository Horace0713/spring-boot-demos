package com.horace.web.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Horace
 * @desc: 自定义HttpMessageConverter消息转换器，原理参考: https://blog.csdn.net/weixin_43453386/article/details/83615829
 *
 * spring默认用MappingJackson2HttpMessageConverter转Json
 * * 此配置的意思是用FastJsonHttpMessageConverter，实际开发中一般不会重写MappingJackson2HttpMessageConverter够用
 * @project: spring-boot-demos
 * @create: 2020-01-01 11:16
 */
//@Configuration  实际开发中一般不会重写MappingJackson2HttpMessageConverter够用
public class MyFastJsonConfig {

    /**
     * 依赖要排除jackson-databind
     *
     * <dependency>
     * <groupId>org.springframework.boot</groupId>
     * <artifactId>spring-boot-starter-web</artifactId>
     * <exclusions>
     * <exclusion>
     * <groupId>com.fasterxml.jackson.core</groupId>
     * <artifactId>jackson-databind</artifactId>
     * </exclusion>
     * </exclusions>
     * </dependency>
     * <dependency>
     * <groupId>com.alibaba</groupId>
     * <artifactId>fastjson</artifactId>
     * <version>1.2.47</version>
     * </dependency>
     */


    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //日期格式化
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss"); // 日期格式一律会转
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,//生成的Json格式化
                SerializerFeature.BrowserCompatible,
                SerializerFeature.WriteMapNullValue,//是否输出value为null的值
                SerializerFeature.DisableCircularReferenceDetect
        );
        converter.setFastJsonConfig(fastJsonConfig);
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastMediaTypes.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(fastMediaTypes);
        converter.setFastJsonConfig(fastJsonConfig);
        return converter;
    }
}
