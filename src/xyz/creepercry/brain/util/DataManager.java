package xyz.creepercry.brain.util;

import xyz.creepercry.brain.Main;
import xyz.creepercry.brain.sections.cerebrum.amygdala.Amygdala;

public class DataManager {
	
	public void save() {
		System.out.println("Saving data for the amygdala...");
		final Amygdala amygdala = Main.getBrain().getCerebrum().getAmygdala();
		amygdala.saveEmotions();
		
	}

	public void initiate() {

	}
}