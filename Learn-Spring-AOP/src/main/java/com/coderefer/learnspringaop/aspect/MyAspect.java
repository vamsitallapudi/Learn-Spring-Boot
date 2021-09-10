package com.coderefer.learnspringaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

@EnableAspectJAutoProxy
@Aspect
@Configuration
@Slf4j
public class MyAspect {

    @Pointcut(value = "execution(* com.coderefer.learnspringaop.service.AOPService.*(..))")
    public void anyServicePointcut() {}

    @Before("anyServicePointcut()")
    public void before(JoinPoint joinPoint) {
        log.info("method name: " + joinPoint.getSignature().getName());
    }
    @AfterReturning(pointcut = "anyServicePointcut()",returning = "result")
    public void audit(JoinPoint joinPoint, Object result) throws Throwable {
        log.info("returned " + result);
    }

    @After("anyServicePointcut()")
    @Order(1)
    public void after(JoinPoint joinPoint) {
        log.info("exiting method: " + joinPoint.getSignature().getName());
    }
    @After("anyServicePointcut()")
    @Order(2)
    public void flush(JoinPoint joinPoint) {
        log.info("exiting method: " + joinPoint.getSignature().getName());
    }
}
