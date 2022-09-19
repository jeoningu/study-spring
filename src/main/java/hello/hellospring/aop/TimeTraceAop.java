package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")
    private Object timeExecute(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        try{
            return joinPoint.proceed();
        } finally {
            Long endTime = System.currentTimeMillis();
            Long timeMs = endTime - startTime;
            System.out.println("End: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }

}
