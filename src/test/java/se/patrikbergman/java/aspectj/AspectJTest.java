package se.patrikbergman.java.aspectj;

import org.junit.Test;

public class AspectJTest {

	@Test
	public void doingSomethingStatic() {
		Doer.doingSomethingStatic();
	}

	@Test
	public void doingSomethingStaticAgain() {
		Doer.doingSomethingStaticAgain();
	}

	@Test
	public void doingSomething() {
		Doer doer = new Doer();
		doer.doingSomething();
	}
}
