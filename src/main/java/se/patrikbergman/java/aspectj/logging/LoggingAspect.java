package se.patrikbergman.java.aspectj.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Aspect
public class LoggingAspect {

	Logger log = LoggerFactory.getLogger(LoggingAspect.class);

	//Pointcut defined together with advice
	@Before("call(* se.patrikbergman.java.aspectj.logging..*(..)) && target(callee)")
	public void bandPublicMethodBeforeAdvice(JoinPoint thisJoinPoint,
											 JoinPoint.StaticPart thisJoinPointStaticPart,
											 JoinPoint.EnclosingStaticPart thisEnclosingJoinPointStaticPart,
											 Band callee) {
		String thisJoinPointKind = thisJoinPoint.getKind();
		log.info("thisJoinPointKind: " + thisJoinPointKind);


		Signature sig = thisJoinPointStaticPart.getSignature();
		int line = thisJoinPointStaticPart.getSourceLocation().getLine();
		String sourceName = thisJoinPointStaticPart.getSourceLocation().getWithinType().getCanonicalName();

		log.info("Signature: " + sig);
		log.info("Signature.getName(): " + sig.getName());
		log.info("Line: " + line);
		log.info("SourceName: " + sourceName);
	}


}
