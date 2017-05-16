package com.xiangyong.utils;

import com.xiangyong.exception.DataNotFoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by yuxiangyong on 2017/5/7.
 */
@Component
@Aspect
public class ControllerAdvice {
    @Pointcut("execution(* com.xiangyong.controller.ContactController.*(..))")
    public void actionName(){};

    private static final Logger logger= LoggerFactory.getLogger(ControllerAdvice.class);

    @Around("actionName()")
    public Object aroundActionAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long end = System.currentTimeMillis();
        logger.info("Time cost: {}",(end - start));

        return obj;
    }

    @AfterThrowing(value = "actionName()",throwing = "e")
    public void afterThrowingAdvice(Throwable e)
    {
        if(e instanceof DataNotFoundException)
        {
            logger.error("DataNotFoundException: {}", e.toString());
        }else{
            logger.error("Internal Server Error: {}",e.toString());
        }
    }
}
