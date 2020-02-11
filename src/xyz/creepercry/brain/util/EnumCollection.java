package xyz.creepercry.brain.util;

import java.util.Random;

public class EnumCollection {

	public enum EmotionType {
		JOY,
		EXCITEMENT,
		SURPRISE,
		SADNESS,
		ANGER,
		DISGUST,
		CONTEMPT,
		FEAR,
		SHAME,
		GUILT;

		public String getFormattedName() {
			return getName().substring(0, 1).toUpperCase() + getName().substring(1);
		}

		public String getName() {
			return name().toLowerCase();
		}
		
		public static EmotionType getRandom() {
			return values()[new Random().nextInt(values().length)];
		}
	}
}