
package aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.stereotype.Component;

/**
 *
 * @author agolu
 */
@Aspect
@Component
public class Aspects {
    
    @Before("execution(* com.agolumbowski.*.*(..))")
    public void beforeAllMethods(JoinPoint joinPoint){
      
        System.out.println(joinPoint.getSignature()+"----------------------");
    }
}
