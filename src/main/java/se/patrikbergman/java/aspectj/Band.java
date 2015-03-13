package se.patrikbergman.java.aspectj;

public class Band {

	private final String name;

	public Band(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void play() {
		System.out.println("Band is playing");
	}
}
