package se.patrikbergman.java.aspectj;

public class Doer {

	public Doer() {
		System.out.println("constructor");
	}

	public static void doingSomethingStatic() {
		System.out.println("doing something static");
	}

	public static void doingSomethingStaticAgain() {
		System.out.println("doing something static again");
	}

	public void doingSomething() {
		System.out.println("doing something");
	}
}
