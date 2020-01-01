package com.horace.web.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2020-01-01 17:40
 */
@Aspect
@Slf4j
@Component
public class LogAspect {

    @Pointcut("execution(* com.horace.web.service.*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint jp) {
        String name = jp.getSignature().getName();
        log.info(name + "方法开始执行...");
    }

    @After("pointcut()")
    public void after(JoinPoint jp) {
        String name = jp.getSignature().getName();
        log.info(name + "方法开始结束...");
    }


    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        String name = jp.getSignature().getName();
        log.info(name + "方法返回值为：" + result);
    }


    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e) {
        String name = jp.getSignature().getName();
        log.info(name + "方法抛异常了，异常时" + e.getMessage());
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("参数预处理");
        pjp.proceed();
        log.info("可以日志持久化");
    }
}
