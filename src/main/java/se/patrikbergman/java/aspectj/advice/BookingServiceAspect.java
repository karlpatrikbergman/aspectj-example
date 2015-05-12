package se.patrikbergman.java.aspectj.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import se.patrikbergman.java.aspectj.logging.*;

@Aspect
public class BookingServiceAspect {

    //Pointcut defined together with advice
    @Before("call(* se.patrikbergman.java.aspectj.advice..*(..)) && this(callee)")
    public void callFromFoo(JoinPoint thisJoinPoint, BookingService callee) {
        System.out.println("Call from BookingService");
    }
}
