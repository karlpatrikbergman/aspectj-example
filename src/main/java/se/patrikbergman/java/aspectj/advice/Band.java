package se.patrikbergman.java.aspectj.advice;

class Band {

	public final String name;

	public Band(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void play() {
		System.out.printf("Band (%s) is playing\n", name);
	}
}
