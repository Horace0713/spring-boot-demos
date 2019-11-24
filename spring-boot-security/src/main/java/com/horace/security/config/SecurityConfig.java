package com.horace.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author: Horace
 * @desc: securiy 配置
 * @project: spring-boot-demos
 * @create: 2019-11-24 21:44
 */
@Configuration
public class SecurityConfig {
//    @Bean
//    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
//        return new WebSecurityConfigurerAdapter() {
//            @Override
//            protected void configure(HttpSecurity http) throws Exception {
//                http.authorizeRequests()
//                        .anyRequest().permitAll();//所有请求全部放行
//            }
//        };
//    }

    @Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                        .antMatchers("/horace/*").permitAll() // 访问'/horace/*'一律放行
//                        .antMatchers("/hello/*").hasRole("admin")
                        .anyRequest().authenticated(); //其他的都要登录

            }

//            @Override
//            protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//                        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//
//                auth
//                        .inMemoryAuthentication()
//                        .passwordEncoder(new BCryptPasswordEncoder())
//                        .withUser("horace")
//                        .password("123")
//                        .roles("admin");
//            }
        };
    }

}
