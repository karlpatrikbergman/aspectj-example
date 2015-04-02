package se.patrikbergman.java.aspectj;

import org.junit.Test;

public class AspectJTest {

	@Test
	public void doingSomething() {
		Band band = new Band("Accept");
		band.play();
		System.out.println(((ChangeMonitorAspect.Monitorable)band).testAndReset());
	}
}
