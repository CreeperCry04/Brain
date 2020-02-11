package xyz.creepercry.brain.sections.cerebrum.amygdala;

import java.text.DecimalFormat;

import xyz.creepercry.brain.util.EnumCollection.EmotionType;

public class Emotion {
	
	public static final double DEFAULT_STRENGTH = 0;
	public static final double MAX_STRENGTH = 10;
	
	private EmotionType type;
	private double strength;
	
	public Emotion(EmotionType type, double strength) {
		this.type = type;
		this.strength = strength;
	}
	
	public Emotion(EmotionType type) {
		this.type = type;
		this.strength = DEFAULT_STRENGTH;
	}

	public EmotionType getType() {
		return type;
	}

	public double getStrength() {
		return strength;
	}

	public void setType(EmotionType type) {
		this.type = type;
	}

	public void setStrength(double strength) {
		if (strength > MAX_STRENGTH) strength = MAX_STRENGTH;
		this.strength = strength;
	}

	public void incrementStrength(double increase) {
		setStrength(strength + increase);
	}

	public void decreaseStrength(double decrease) {
		setStrength(strength - decrease);
	}
	
	public String getFormattedStrength() {
		return new DecimalFormat("0.#").format(strength);
	}
}