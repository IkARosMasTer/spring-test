//package org.choviwu.movie.config;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.choviwu.movie.annotation.Validator;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class LogAspect {
//
//    @Pointcut(value = "@annotation(org.choviwu.movie.annotation.Validator)")
//    public void poinCut(){
//
//    }
//
//    @Around(value = "poinCut()&&@annotation(validator)")
//    public Object before( ProceedingJoinPoint joinPoint,Validator validator) throws Throwable {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Object retValue = joinPoint.proceed();
//        return retValue;
//    }
//
//}
