package se.patrikbergman.java.aspectj.logging;

import org.junit.Test;

public class LoggingTest {

	@Test
	public void doingSomething() {
		Band band = new Band("Accept");
		band.play();
	}
}
