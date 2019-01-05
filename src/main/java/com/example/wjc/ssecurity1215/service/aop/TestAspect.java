package com.example.wjc.ssecurity1215.service.aop;

import com.example.wjc.ssecurity1215.bean.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wjc
 * @Description:  切面
 * @Date: created in 2018/12/24 20:48
 */
@Aspect
@Component
public class TestAspect {

    private Logger logger= (Logger) LoggerFactory.getLogger(TestAspect.class);

    @Pointcut("execution(public * com.example.wjc.ssecurity1215.controller.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("方法执行前...");
        ServletRequestAttributes sra =  (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        logger.info("url: " + request.getRequestURI());
        logger.info("ip: " + request.getRemoteHost());
        logger.info("method: "+request.getMethod());
        logger.info("class.method: " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //logger.info("args: "+joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(JoinPoint joinPoint){
        logger.info("方法执行后...");
    }

    @AfterReturning(returning="result", pointcut="log()")
    public void doAfterReturnint(Object result){
        logger.info("方法返回值：" + result);
    }

}
