package com.coderefer.learnspringaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Aspect
@Configuration
@Slf4j
public class MyAspect {

    @Before("execution(* com.coderefer.learnspringaop.service.AOPService.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("method name: " + joinPoint.getSignature().getName());
    }
    @After("execution(* com.coderefer.learnspringaop.service.AOPService.*(..))")
    public void after(JoinPoint joinPoint) {
        log.info("exiting method: " + joinPoint.getSignature().getName());
    }
}
