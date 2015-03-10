package se.patrikbergman.java.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	// This point cut aims to define all methods.
	// i.e: this point cut define all methods in the project
	// This formula * *.*(..) defines the methods represented by this
	// point cut. First * means that I don't care about return type.
	// Second * means I don't care about package and class names. Third ones
	// means I don't care what is the method name. Finally this (..) means I
	// don't care about the method arguments.
	@Pointcut("execution(* *.*(..))")
	void anyCallToMethod() {
	}

	// The code written inside this method (Advice) will be executed before any
	// method execution in the project. This is because the method is annotated
	// @Before and it apply to anyCallToMethod() which defines a pattern
	// applied to any method. By another words the method annotated with
	// @Pointcut is responsible on telling the compiler what methods to consider
	// when running the advises.
	@Before("anyCallToMethod()")
	public void beforeLogging() {
		System.out.println("Before Method execution");
	}
}
