package com.dressup.demo.config.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ControlAspect {


    @Before(value = "execution(* com.dressup.demo.repositories.*.*(..))")
    public void before(JoinPoint joinPoint) {
        log.info("DB request " + joinPoint);
    }

    @AfterThrowing(pointcut = "execution(* com.dressup.demo.repositories.*.*(..))", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        log.info("GOOD GAME " + joinPoint + " " + error);
    }


}