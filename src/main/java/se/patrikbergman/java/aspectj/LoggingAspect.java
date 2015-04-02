package se.patrikbergman.java.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

	//Pointcut defined together with advice
	@Before("call(* se.patrikbergman.java.aspectj..*(..)) && target(callee)")
	public void bandPublicMethodBeforeAdvice(JoinPoint thisJoinPoint,
											 JoinPoint.StaticPart thisJoinPointStaticPart,
											 JoinPoint.EnclosingStaticPart thisEnclosingJoinPointStaticPart,
											 Band callee) {
		String thisJoinPointKind = thisJoinPoint.getKind();
		System.out.println("thisJoinPointKind: " + thisJoinPointKind);


		Signature sig = thisJoinPointStaticPart.getSignature();
		int line = thisJoinPointStaticPart.getSourceLocation().getLine();
		String sourceName = thisJoinPointStaticPart.getSourceLocation().getWithinType().getCanonicalName();

		System.out.println("Signature: " + sig);
		System.out.println("Signature.getName(): " + sig.getName());
		System.out.println("Line: " + line);
		System.out.println("SourceName: " + sourceName);
	}
}
