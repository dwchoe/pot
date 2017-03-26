package aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by z0019mz on 5/15/16.
 */

@Aspect
public class LogAspect {

    @Before("execution(* service.MyService.getPrice(..))")
    public void logAroundAdvice(JoinPoint pjp) throws Throwable {
        System.out.println("LogAspect called");
    }

    @Before("execution(* getPrice(..))")
    public void logAroundAdvice2(JoinPoint pjp) throws Throwable {
        System.out.println("LogAspect called");
    }


    @After("execution(* service.MyService.getPrice(..))")
    public void logAfter(JoinPoint pjp) throws Throwable {
        System.out.println("LogAspect called");
    }
}
