package com.cinbo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("aopconfig")
@Aspect
public class AopConfig {
    private static final Logger log = LoggerFactory.getLogger(AopConfig.class);

    @Pointcut("execution(* com.cinbo.testbean.myclass2.*(..))")
    public void testAop(){}



    @Before("testAop()")
    public void runbefore(JoinPoint joinPoint){
        System.out.println("before aop");
    }

    @After("testAop()")
    public void runafter(JoinPoint joinPoint){
        System.out.println("after aop");
    }


    @Around("testAop()")
    public Object process(ProceedingJoinPoint point) throws Throwable{
        System.out.println("around before run.");
      Object obj =  point.proceed(point.getArgs());
        System.out.println("around after run.");
        return obj;
    }

}
