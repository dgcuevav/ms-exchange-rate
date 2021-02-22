package com.inteligo.exchangerate.config.aspect;

import com.inteligo.exchangerate.util.Utils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.util.StopWatch;

import java.util.Arrays;

@Aspect
public class LogginAspect {

  private static final Logger LOG = LoggerFactory.getLogger(LogginAspect.class);

  private final Environment env;

  public LogginAspect(Environment env) {
    this.env = env;
  }

  //CONTROLLER LAYER ====================================================
  @Pointcut("within(com.inteligo.exchangerate.controller..*)")
  public void loggingPointcutController() {

  }

  @Around("loggingPointcutController()")
  public Object logAroundController(ProceedingJoinPoint joinPoint) throws Throwable {

    StopWatch sw = new StopWatch();
    AuditLogger.log(LOG, "START CALL to {}.{}() - [PARAMETERS:] {}",
        joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
        Utils.printJsonFormat(joinPoint.getArgs()));
    try {

      sw.start();
      Object result = joinPoint.proceed();
      sw.stop();
      AuditLogger.log(LOG, "END CALL to {}.{}() - TIME: {} Millis - [RESPONSE:] {}",
          joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
          sw.getTotalTimeMillis(),
          Utils.printJsonFormat(result));
      return result;

    } catch (IllegalArgumentException e) {
      LOG.info("Illegal argument: {} in {}.{}()", Arrays.toString(joinPoint.getArgs()),
          joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
      throw e;
    }
  }

  @AfterThrowing(pointcut = "loggingPointcutController()", throwing = "e")
  public void logAfterThrowingController(JoinPoint joinPoint, Throwable e) {

    LOG.error("Exception in {}.{}() with cause = {} and exception = {}",
        joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(),
        Utils.getCause(e),  Utils.printJsonFormat(e));

  }

}
