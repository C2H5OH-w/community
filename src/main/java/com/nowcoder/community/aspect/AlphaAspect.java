package com.nowcoder.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class AlphaAspect {

    @Pointcut("execution(* com.nowcoder.community.service.*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("AfterReturning");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("AfterThrowing");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Around before");
        Object obj = joinPoint.proceed();
        System.out.println(obj);
        System.out.println("Around after");
        return obj;
    }
}
