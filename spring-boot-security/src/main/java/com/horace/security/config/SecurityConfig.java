package com.horace.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-15 18:47
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); //如果没有的话，会报java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { //这是基于内存的配置，则yml中配置的不生效
        auth.inMemoryAuthentication()
                .withUser("admin3").password("admin3").roles("ADMIN", "USER")
                .and()
                .withUser("user").password("123").roles("USER");
    }
}
