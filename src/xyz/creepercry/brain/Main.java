package xyz.creepercry.brain;

public class Main {
	
	private static Brain brain;
	
	public static void main(String[] args) {
		brain = new Brain();
		brain.initate();
	}

	public static Brain getBrain() {
		return brain;
	}
}