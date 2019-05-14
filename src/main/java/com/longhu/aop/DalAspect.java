package com.longhu.aop;

/**
 * @author: houyong
 * @description:
 * @create: 2019-04-12 15:22
 */

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class DalAspect {

    /**
     * 切入点表达式
     */
    @Pointcut("execution(* com.longhu.dao..*.*(..))")
    public void daoPointCut() {
    }

    @Pointcut("execution(* com.longhu.repository..*.*(..))")
    public void repositoryPointCut() {
    }


    /**
     * 统计方法耗时环绕通知
     *
     * @param joinPoint
     */
    @Around("daoPointCut() || repositoryPointCut()")
    public Object timeAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime;
        long E_time;
        Object obj;
        // 获取开始时间
        startTime = System.currentTimeMillis();
        // 获取返回结果集
        obj = joinPoint.proceed(joinPoint.getArgs());
        // 获取方法执行时间
        E_time = System.currentTimeMillis() - startTime;
        String classAndMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        log.info("执行 " + classAndMethod + " 方法，耗时为：" + E_time + "ms");
        return obj;
    }
}
