package com.vk.service.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class AppAspect {

  @Before("execution(public * com.vk.service.impl.AspectServiceImpl.*(..))")
  public void beforeAdvice(JoinPoint joinPoint) {
    log.info("'Before advice' is called...");
  }

  @After("execution(public * com.vk.service.impl.AspectServiceImpl.*(..))")
  public void afterAdvice(JoinPoint joinPoint) {
    log.info("'After advice' is called...");
  }

}
