package xyz.creepercry.brain.sections.cerebrum.amygdala;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xyz.creepercry.brain.Main;
import xyz.creepercry.brain.util.EnumCollection.EmotionType;

public class Amygdala {

	// ease of access
	private final Map<String, Emotion> emotions = new HashMap<>();

	public static final Emotion EMOTION_JOY = new Emotion(EmotionType.JOY);
	public static final Emotion EMOTION_EXCITEMENT = new Emotion(EmotionType.EXCITEMENT);
	public static final Emotion EMOTION_SURPRISE = new Emotion(EmotionType.SURPRISE);
	public static final Emotion EMOTION_SADNESS = new Emotion(EmotionType.SADNESS);
	public static final Emotion EMOTION_ANGER = new Emotion(EmotionType.ANGER);
	public static final Emotion EMOTION_DISGUST = new Emotion(EmotionType.DISGUST);
	public static final Emotion EMOTION_CONTEMPT = new Emotion(EmotionType.CONTEMPT);
	public static final Emotion EMOTION_FEAR = new Emotion(EmotionType.FEAR);
	public static final Emotion EMOTION_SHAME = new Emotion(EmotionType.SHAME);
	public static final Emotion EMOTION_GUILT = new Emotion(EmotionType.GUILT);

	public void initiate() {
		emotions.put("joy", EMOTION_JOY);
		emotions.put("excitement", EMOTION_EXCITEMENT);
		emotions.put("surprise", EMOTION_SURPRISE);
		emotions.put("sadness", EMOTION_SADNESS);
		emotions.put("anger", EMOTION_ANGER);
		emotions.put("disgust", EMOTION_DISGUST);
		emotions.put("contempt", EMOTION_CONTEMPT);
		emotions.put("fear", EMOTION_FEAR);
		emotions.put("shame", EMOTION_SHAME);
		emotions.put("guilt", EMOTION_GUILT);
		setupEmotions();
	}

	public Map<String, Emotion> getEmotions() {
		return emotions;
	}

	public void saveEmotions() {
		try {
			final File emotionsFile = Main.getBrain().getDataFile("emotions.txt");
			if (!emotionsFile.exists()) emotionsFile.createNewFile();
			final FileWriter fw = new FileWriter(emotionsFile, false);
			final BufferedWriter bw = new BufferedWriter(fw);
			final List<String> emotionList = new ArrayList<>();
			for (final Emotion emotion : emotions.values())
				emotionList.add(emotion.getType().name() + ":" + emotion.getStrength());
			final String text = String.join(",", emotionList); // primitive but it works
			System.out.println(text);
			bw.write(text);
			bw.close();
			fw.close();
		} catch (final Exception e) {
			System.err.println("The following error occured whilst saving data for the Amygdala: \n");
			e.printStackTrace();
		}
	}

	public void setupEmotions() {
		try {
			final File emotionsFile = Main.getBrain().getDataFile("emotions.txt");
			if (!emotionsFile.exists())
				emotionsFile.createNewFile();
			final LineNumberReader lnr = new LineNumberReader(new FileReader(emotionsFile));
			final String[] response = lnr.readLine().split(",");
			for (final String namedResponse : response) {
				final String[] emotionResponse = namedResponse.split(":");
				final EmotionType type = EmotionType.valueOf(emotionResponse[0]);
				final double strength = Double.valueOf(emotionResponse[1]);
				emotions.get(type.name().toLowerCase()).setStrength(strength);
			}
			lnr.close();
		} catch (final Exception e) {
			System.err.println("The following error occured whilst reading data for the Amygdala: \n");
			e.printStackTrace();
		}
	}
}