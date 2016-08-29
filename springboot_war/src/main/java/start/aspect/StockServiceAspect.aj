package start.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by z0019mz on 5/14/16.
 */

@Aspect
public class StockServiceAspect {

    @Before("execution(* PriceService.getPrice())")
    public void logPriceServiceBefore(JoinPoint joinPoint) {
        System.out.println("******");
        System.out.println("StockServiceAspect.logAfter() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");

    }

    @Before("execution(* PriceService.get*())")
    public void logStockServiceBefore(JoinPoint joinPoint) {
        System.out.println("******");
        System.out.println("StockServiceAspect.logBefore() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");

    }

    @Before("execution(* PriceService.getPrice(..))")
    public void log(JoinPoint joinPoint) {
        System.out.println("******");
        System.out.println("StockServiceAspect.log() is running!");
        System.out.println("hijacked : " + joinPoint.getSignature().getName());
        System.out.println("******");
    }
}
