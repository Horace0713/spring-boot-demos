package com.horace.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2020-03-13 21:42
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public void login() {
        SecurityManager sm = new DefaultSecurityManager();
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken("", "");
//        subject.login();
    }
}
