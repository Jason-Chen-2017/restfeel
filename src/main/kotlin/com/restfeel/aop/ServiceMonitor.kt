package com.restfeel.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

/**
 * Created by jack on 2017/3/29.
 */
@Aspect
@Component
class ServiceMonitor {
    internal var logger = LoggerFactory.getLogger(ServiceMonitor::class.java)

    @AfterReturning("execution(* com.restfeel.controller.rest.*.*(..))")
    fun logServiceAccess(joinPoint: JoinPoint) {
        logger.info("Completed: " + joinPoint)
    }
}
