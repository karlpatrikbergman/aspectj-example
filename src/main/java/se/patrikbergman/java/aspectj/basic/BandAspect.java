package se.patrikbergman.java.aspectj.basic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class BandAspect {

    // This point cut picks out all Band's public methods
    @Pointcut("call(* se.patrikbergman.java.aspectj.basic.Band.*(..)) && target(callee)")
    void bandPublicMethods(Band callee) {
    }

    //This is a piece of advice, i.e. code executing at join points matching pointcut
    // defined in "bandPublicMethod
    @Before("bandPublicMethods(callee)")
    public void bandPublicMethodBeforeAdviceWithPointCutDefinedSeparately(JoinPoint joinPoint, Band callee) {
        System.out.printf("Before Band.play() (%s) execution\n", callee.name);
    }

    @AfterReturning("bandPublicMethods(callee)")
    public void bandPublicMethodAfterReturningAdvice(JoinPoint joinPoint, Band callee) {
        System.out.printf("AfterReturning Band.play() (%s) execution\n", callee.name);
    }

    //After is run after method returning or method throwing exception, = finally
    @After("bandPublicMethods(callee)")
    public void bandPublicMethodAfterAdvice(JoinPoint joinPoint, Band callee) {
        System.out.printf("After Band.play() (%s) execution\n", callee.name);
    }

    /*
    This point cut aims to define all methods.
    i.e: this point cut define all methods in the project
    This formula * *.*(..) defines the methods represented by this
    point cut. First * means that I don't care about return type.
    Second * means I don't care about package and class names. Third ones
    means I don't care what is the method name. Finally this (..) means I
    don't care about the method arguments.
    */
//    @Pointcut("execution(* *.*(..))")
//    void anyCallToMethod() {
//    }

    /*
    The code written inside this method (Advice) will be executed before any
    method execution in the project. This is because the method is annotated
    @Before and it apply to anyCallToMethod() which defines a pattern
    applied to any method. By another words the method annotated with
    @Pointcut is responsible on telling the compiler what methods to consider
    when running the advises.
    */
//    @Before("anyCallToMethod()")
//    public void beforeLogging() {
//        System.out.println("Before Method execution");
//    }
}
