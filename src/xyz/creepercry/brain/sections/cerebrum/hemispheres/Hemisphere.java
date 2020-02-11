package xyz.creepercry.brain.sections.cerebrum.hemispheres;

import xyz.creepercry.brain.sections.cerebrum.amygdala.Amygdala;

public abstract class Hemisphere {
	
	public Amygdala amygdala;
	
	public void initiate() {
		this.amygdala = new Amygdala();
	}
}