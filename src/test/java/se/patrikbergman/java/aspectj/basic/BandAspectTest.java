package se.patrikbergman.java.aspectj.basic;

import org.junit.Test;

public class BandAspectTest {

	@Test
	public void doingSomething() {
		Band band = new Band("Accept");
		band.play();
	}
}
