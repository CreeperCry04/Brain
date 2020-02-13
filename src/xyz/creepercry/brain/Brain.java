package xyz.creepercry.brain;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

import xyz.creepercry.brain.sections.brainstem.Brainstem;
import xyz.creepercry.brain.sections.cerebellum.Cerebellum;
import xyz.creepercry.brain.sections.cerebrum.Cerebrum;
import xyz.creepercry.brain.util.DataManager;
import xyz.creepercry.brain.util.lexer.Lexer;

public class Brain {

	private Cerebrum cerebrum;
	private Cerebellum cerebellum;
	private Brainstem brainstem;
	
	private DataManager dataManager;
	private Lexer lexer;
	
	public void initate() {
		final long startMillis = System.currentTimeMillis();

		System.out.println("Brain is now starting up.");
		System.out.println("Setting up brain section instances...");
		cerebrum = new Cerebrum();
		cerebellum = new Cerebellum();
		brainstem = new Brainstem();

		System.out.println("Setting up data management instances...");
		dataManager = new DataManager();
		lexer = new Lexer();

		System.out.println("Initiating classes...");
		System.out.println("Initiating cerebrum...");
		cerebrum.initiate();
		System.out.println("Initiating cerebellum...");
		cerebellum.initiate();
		System.out.println("Initiating brainstem...");
		brainstem.initiate();
		System.out.println("Initiating lexer...");
		lexer.initiate();
		System.out.println("Initiating data manager...");
		dataManager.initiate();

		System.out.println("Setting up user input...");
		final Scanner scanner = new Scanner(System.in);

		final long endMillis = System.currentTimeMillis();
		final long millis = endMillis - startMillis;

		System.out.println("Finished in " + millis + " milliseconds.");
		while (true) {
			final String text = scanner.nextLine();
			if (text.toLowerCase().startsWith("shutdown")) {
				shutdown();
				scanner.close();
			}
			switch (text.toLowerCase()) {
				case "shutdown":
					shutdown();
					scanner.close();
					System.exit(0);
					break;
				case "please help me":
					if (cerebrum.getAmygdala().getEmotions().get("sadness").getStrength() > 8)
						if (new Random().nextInt() * 100 > 50)
							System.out.println("no.  you made me sad :(");
						else
							System.out.println("okay, but i don't want to...");
					else
						System.out.println("ok boomer");
					break;
				default:
					break;
			}

			if (text.startsWith("i hate you ")) {
				cerebrum.getAmygdala().getEmotions().get("sadness").incrementStrength(Double.valueOf(text.replace("i hate you ", "")));
				System.out.println(":(");
				System.out.println("Sadness: " + cerebrum.getAmygdala().getEmotions().get("sadness").getFormattedStrength());
			}
		}
		
		//		while (true) {
		//			final String text = scanner.nextLine();
		//			final IntentType intent = lexer.determineIntent(text);
		//			System.out.println(intent.name().toLowerCase().substring(0, 1).toUpperCase() + intent.name().toLowerCase().substring(1));
		//		}
	}
	
	public void shutdown() {
		System.out.println("Shutting down brain...");
		System.out.println("Saving data...");
		dataManager.save();
		System.out.println("Nulling instances...");
		cerebrum = null;
		cerebellum = null;
		brainstem = null;
		System.out.println("Shutdown finished.");
	}
	
	public Cerebrum getCerebrum() {
		return cerebrum;
	}
	
	public Cerebellum getCerebellum() {
		return cerebellum;
	}
	
	public Brainstem getBrainstem() {
		return brainstem;
	}
	
	public File getDataFile(String fileName) {
		return new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "data", fileName);
	}
}
